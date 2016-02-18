package FileDB;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Data {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    static File shipsTxt = new File("src/FileDB/ships.txt");
    static File classesTxt = new File("src/FileDB/classes.txt");

    public static ArrayList<Ship> shipsArray = new ArrayList<>();
    public static ArrayList<ShipClass> classesArray = new ArrayList<>();

    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite://home/nick/IdeaProjects/ships.sqlite");
//        conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");
    }

    public static void readTables() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();

        resSet = statmt.executeQuery("SELECT * FROM 'ships'");

        while(resSet.next())
        {
            String name = resSet.getString("name");
            String shipClass = resSet.getString("class");
            int launched = resSet.getInt("launched");

            shipsArray.add(new Ship(name, shipClass, launched));
        }

        resSet = statmt.executeQuery("SELECT * FROM 'classes'");

        while(resSet.next())
        {
            String shipClass = resSet.getString("class");
            String type = resSet.getString("type");
            String country = resSet.getString("country");
            int numGuns = resSet.getInt("numGuns");
            double bore = resSet.getInt("bore");
            int displacement = resSet.getInt("displacement");

            classesArray.add(new ShipClass(shipClass, type,country, numGuns, bore, displacement));
        }
    }

    public static void writeFiles() {

        OutputStream os;

        try {
            os = new FileOutputStream(shipsTxt);
            String str;

            for (Ship ship: shipsArray) {
                str = ship.name + "," + ship.shipClass + "," + ship.launched + "\n";
                os.write(str.getBytes());
            }

            os = new FileOutputStream(classesTxt);

            for (ShipClass shipClass: classesArray) {
                str = shipClass.shipClass + "," + shipClass.type + "," + shipClass.country + "," + shipClass.numGuns + "," + shipClass.bore + "," + shipClass.displacement + "\n";
                os.write(str.getBytes());
            }

            os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFiles() {

        InputStream is;
        String[] data;
        shipsArray = new ArrayList<>();
        classesArray = new  ArrayList<>();

        try {
            is = new FileInputStream(shipsTxt);
            StringBuilder str = new StringBuilder();

            int i;
            while((i = is.read()) != -1) {
                if (((char) i) == '\n') {
                    str.append(',');
                    continue;
                }
                str.append((char) i);
            }

            data = str.toString().split(",");

            for (int j = 2; j < data.length; j += 3) {
                shipsArray.add(new Ship(data[j - 2], data[j - 1], Integer.parseInt(data[j])));
            }

            System.out.println("Ships:");
            for (Ship ship: shipsArray) {
                System.out.println(ship.toString());
            }

            is = new FileInputStream(classesTxt);
            str.setLength(0);

            while((i = is.read()) != -1) {
                if (((char) i) == '\n') {
                    str.append(',');
                    continue;
                }
                str.append((char) i);
            }

            data = str.toString().split(",");

            System.out.println();

            for (int j = 5; j < data.length; j += 6) {
                classesArray.add(new ShipClass(data[j - 5], data[j - 4], data[j - 3], Integer.parseInt(data[j - 2]),
                                Double.parseDouble(data[j - 1]), Integer.parseInt(data[j])));
            }

            System.out.println("Classes:");
            for (ShipClass shipClass: classesArray) {
                System.out.println(shipClass.toString());
            }

            is.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replace() {
        ArrayList<String> markers = new ArrayList<>();

        for (ShipClass shipClass: classesArray) {
            if (shipClass.country.equals("USA"))
                markers.add(shipClass.shipClass);
        }

        for (Ship ship: shipsArray) {
            for (String marker: markers) {
                if (ship.shipClass.equals(marker)) {
                    ship.name += "USA";
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("New ships:");
        for (Ship ship: shipsArray) {
            System.out.println(ship.toString());
        }
    }
}
