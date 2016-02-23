package ClientServer;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClient {

    /**
     * create connection to server
     */
    static Client connector;

    /**
     * statment for check correct ip
     */
    static boolean check = false;

    /**
     * ip idress
     */
    static String log;

    public static void main(String[] args) throws InterruptedException {

        while (!check) {
            log = JOptionPane.showInputDialog("Input IP");
            if (checkIp(log)) {
                check = true;
                System.out.println(log + "Conncection");
            } else {
                System.out.println(log + "Wrong adress!");
            }
        }
        connector = new Client(log);
    }


    /**
     * method for check correct ip adress
     */
    public static boolean checkIp(String str) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}