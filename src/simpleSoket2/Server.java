package simpleSoket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Server implements Runnable {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private boolean isRunning = true;
	protected Socket clientSocket;

	Server (Socket clientSoc) {
		clientSocket = clientSoc;
		run();
	}

	public void run() {
		try{
			server = new ServerSocket(1111);
			System.out.println("server started");

			while (isRunning) {
				connection = server.accept();
				output = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());

				System.out.println("connection created with " + connection.getInetAddress());
				sendAnswer("connected to " + connection.getLocalAddress());
				sendAnswer("please, make your request");

				Statement st = connectToDB();
				String request = "";
				while (!request.equals("exit")) {
					request = input.readObject().toString();
					System.out.println("Request from client: " + request);
					makeAnswer(st, request);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
	}

	private void makeAnswer(Statement st, String request) {
		String answer = "";
		boolean found = false;
		try {
			ResultSet resSet = st.executeQuery("SELECT * FROM classes");

			while(resSet.next()) {
				String country = resSet.getString("country");
				if (country.equalsIgnoreCase(request)) {
					request = country;
					found = true;
				}
			}

			if (!found) {
				sendAnswer("Matches not found");
			} else {
				resSet = st.executeQuery("SELECT * FROM ships LEFT JOIN classes ON ships.class = classes.class WHERE country = '" + request + "'");
				while (resSet.next()) {
					String name = resSet.getString("name");
					String shipClass = resSet.getString("class");
					int launched = resSet.getInt("launched");

					answer = name + ", " + shipClass + ", " + launched + "\n";
				}
				sendAnswer(answer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendAnswer(String answer) {
		System.out.println("Send answer:" + answer);
		try {
			output.writeObject(answer);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Statement connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
//			Connection conn = DriverManager.getConnection("jdbc:sqlite://home/nick/IdeaProjects/ships.sqlite");
        	Connection conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");

			return conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void close() {
		try{
			output.close();
			input.close();
			connection.close();
			isRunning = false;
		}catch(Exception e){e.printStackTrace();}
	}
}
