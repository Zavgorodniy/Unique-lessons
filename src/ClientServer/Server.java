package ClientServer;

import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Server extends Thread
{
    protected Socket clientSocket;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1111);
            System.out.println ("Server started");
            try {
                while (true)
                {
                    System.out.println ("Waiting for Connection");
                    Socket socket = serverSocket.accept();
                    new Server (socket);
                    System.out.println("Connection created with " + socket.getInetAddress());
                }
            }
            catch (IOException e)
            {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port: 1111.");
            System.exit(1);
        }
        finally
        {
            try {
                serverSocket.close();
            }
            catch (IOException e)
            {
                System.err.println("Could not close port: 1111.");
                System.exit(1);
            }
        }
    }

    private Server (Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run()
    {
        System.out.println("New communication thread started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String request;

            while ((request = in.readLine()) != null)
            {
                System.out.println("Request from " + clientSocket.getInetAddress() + ": " + request);

                if (request.equals("exit"))
                    break;
                else {
                    try {
                        String answer = "";
                        boolean found = false;
                        Class.forName("org.sqlite.JDBC");
//			                Connection conn = DriverManager.getConnection("jdbc:sqlite://home/nick/IdeaProjects/ships.sqlite");
                        Connection conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");

                        Statement st =  conn.createStatement();

                        ResultSet resSet = st.executeQuery("SELECT * FROM classes");

                        while(resSet.next()) {
                            String country = resSet.getString("country");
                            if (country.equalsIgnoreCase(request)) {
                                request = country;
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Matches not found");
                            out.println("Matches not found");
                        } else {
                            resSet = st.executeQuery("SELECT * FROM ships LEFT JOIN classes ON ships.class = classes.class WHERE country = '" + request + "'");
                            while (resSet.next()) {
                                String name = resSet.getString("name");
                                String shipClass = resSet.getString("class");
                                int launched = resSet.getInt("launched");

                                answer += name + ", " + shipClass + ", " + launched + "=";
                            }
                            System.out.println("Answer to " + clientSocket.getInetAddress() + ": " + answer);
                            out.println(answer);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            System.err.println("Problem with communication server");
            System.exit(1);
        }
    }
} 