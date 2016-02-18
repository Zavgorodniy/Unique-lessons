package simpleSoket2;

import javax.swing.JOptionPane;

public class Main {
	
	static Server server = new Server();
	static Connector connector = new Connector();
	static Thread serverThread = new Thread (server);
	
	public static void main(String[] args) throws InterruptedException {	
		serverThread.start();
//		Thread clienrThread = new Thread(connector);
//		clienrThread.start();
//		String str = JOptionPane.showInputDialog("");
//		connector.sendMessage(str);
	}			
}
