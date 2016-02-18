package simpleSoket2;

import FileDB.Ship;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Server implements Runnable{
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private boolean isRunning = true;
	
	@Override
	public void run() {
		ServerStarter();
	}
	
	public void ServerStarter(){
		try{
			server = new ServerSocket(1111);
			while (isRunning) {
				connection = server.accept();

				System.out.println("log: connection created with " + connection.getInetAddress());

				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();

				input = new ObjectInputStream(connection.getInputStream());

				String ask = input.readObject().toString();
				System.out.println("log: ask from client " + ask);

				output.writeObject(makeAnswer(ask));
				output.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	private void close() {
		try{
			output.close();
			input.close();
			connection.close();
			isRunning = false;
		}catch(Exception e){e.printStackTrace();}
	}

	private String makeAnswer(String ask) {
		String answer = new String();
		ArrayList<String> availableCountries = new ArrayList<>();
		boolean found = false;

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite://home/nick/IdeaProjects/ships.sqlite");

			Statement statmt = conn.createStatement();

			ResultSet resSet = statmt.executeQuery("SELECT * FROM classes");

			while(resSet.next()) {
				String country = resSet.getString("country");
				availableCountries.add(country);
			}

			resSet = null;

			for (String country: availableCountries) {
				if (country.equalsIgnoreCase(ask)) {
					ask = country;
					found = true;
				}
			}

			if (!found) {
				System.out.println("log: matches not found");
				return "log: matches not found";
			} else {
				resSet = statmt.executeQuery("SELECT * FROM ships JOIN classes ON ships.class = classes.class WHERE country = '" + ask + "'");
			}


			if (resSet == null) {
				while (resSet.next()) {

					String name = resSet.getString("name");
					int launched = resSet.getInt("launched");


					answer = name + ", " + launched + "\n";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("log: answer to client " + answer);
		return answer;
	}
}
