package ClientServer;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

    Client(String str){
        String serverHostname = str;
        System.out.println ("Connection to host " +
                serverHostname + " on port 1111.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 1111);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println ("Type message (\"exit\" to quit)");
        System.out.println ("Please, enter your request");
        try {
            while ((userInput = stdIn.readLine()) != null)
            {
                out.println(userInput);

                if (userInput.equals("exit"))
                    break;

                String st = in.readLine();
                String[] split = st.split("=");
                int i = 0;

                while (i<split.length){
                    System.out.println("Answer from server: " + split[i]);
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stdIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}