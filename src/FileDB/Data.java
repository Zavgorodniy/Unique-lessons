package FileDB;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

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

        System.out.println("Connection created");
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

        try {
            is = new FileInputStream(shipsTxt);
            StringBuilder str = new StringBuilder();

            Field[] field = Ship.class.getFields();

            int i;
            while((i = is.read()) != -1) {

                if((char) i != ',') {
                    str.append((char) i);
                } else {
                    str.setLength(0);
                }
            }

            is.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
