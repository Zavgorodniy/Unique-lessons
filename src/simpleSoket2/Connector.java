package simpleSoket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Connector implements Runnable{

	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static Socket connection;
	private static boolean isRunning = true;

	@Override
	public void run() {
		try {
			while(isRunning){
				connection = new Socket(InetAddress.getByName("localhost"), 1111);
				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input = new ObjectInputStream(connection.getInputStream());
				String response = (String)input.readObject();

				JOptionPane.showMessageDialog(null, response);
			}
			close();
		}catch(Exception e) {
			e.printStackTrace();
			}
		finally{
			close();
		}
	}

	public void sendMessage(String s){
		try {
			output.flush();
			output.writeObject(s);
			output.flush();
		} catch (Exception e) {e.printStackTrace();}
	}

	public void close() {
		try {
			isRunning = false;
			output.close();
			input.close();
			connection.close();
		} catch (Exception e) {e.printStackTrace();}
	}

}
