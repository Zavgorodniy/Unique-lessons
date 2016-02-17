package DataBase;

import java.sql.*;

/**
 * DB class for connection with database
 * @see MainDataBase
 * @author Nick
 * @version 1.0 beta
 * @since 2016 February 16
 */
public class DB {

    /** object connection to database */
    public static Connection conn;

    /** object for statement creation */
    public static Statement statmt;

    /** object for statement creation */
    public static ResultSet resSet;

    /**
     * function for connection to database
     * declares driver for SQLite database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void connect() throws ClassNotFoundException, SQLException {

        conn = null;
        Class.forName("org.sqlite.JDBC");

//        conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");

        conn = DriverManager.getConnection("jdbc:sqlite://home/nick/IdeaProjects/ships.sqlite");

        System.out.println("Connection created");
    }

    /**
     * Function that creates statement and inserts tables in database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void createTables() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();

        statmt.execute("CREATE TABLE if not exists 'classes' ('class' varchar (50) NOT NULL, 'type' varchar (2) NOT NULL, " +
                "'country' varchar (20) NOT NULL, 'numGuns' tinyint, 'bore' real, 'displacement' int);");
        statmt.execute("CREATE TABLE if not exists 'ships' ('name' varchar (50) PRIMARY KEY NOT NULL, 'class' varchar (50) NOT NULL, 'launched' smallint);");
        statmt.execute("CREATE TABLE if not exists 'outcomes' ('ship' varchar (20) NOT NULL, 'battle' varchar (20) NOT NULL, 'result' varchar(10) NOT NULL, PRIMARY KEY('ship', 'battle'));");
        statmt.execute("CREATE TABLE if not exists 'battles' ('name' varchar (50) PRIMARY KEY NOT NULL, 'date' datetime NOT NULL);");

        System.out.println("Tables created or exist");
    }

    /**
     * Function that fills data into tables
     * @throws SQLException
     */
    public static void writeTables() throws SQLException {
//        statmt.execute("INSERT INTO 'classes' " +
//                "('class','type', 'country', 'numGuns', 'bore', 'displacement') " +
//                "VALUES " +
//                "('Bismarck','bb','Germany','8','15.0','42000'), " +
//                "('Iowa','bb','USA','9','16.0','46000'), " +
//                "('Kongo','bc','Japan','8','14.0','32000')," +
//                "('North Carolina','bb','USA','12','16.0','37000')," +
//                "('Renown','bc','Gt.Britain','6','15.0','32000')," +
//                "('Revenge','bb','Gt.Britain','8','15.0','29000')," +
//                "('Tennessee','bb','USA','12','14.0','32000')," +
//                "('Yamato','bb','Japan','9','18.0','65000'); ");
//
//        statmt.execute("INSERT INTO 'ships' " +
//                "('name', 'class', 'launched') " +
//                "VALUES " +
//                "('California', 'Tennessee', '1921'), " +
//                "('Haruna', 'Kongo', '1916'), " +
//                "('Hiei', 'Kongo', '1914')," +
//                "('Iowa', 'Iowa', '1943')," +
//                "('Kirishima', 'Kongo', '1915')," +
//                "('Kongo', 'Kongo', '1913')," +
//                "('Missouri', 'Iowa', '1944')," +
//                "('Musashi', 'Yamato', '1942')," +
//                "('New Jersey', 'Iowa', '1943')," +
//                "('North Carolina', 'North Carolina', '1941')," +
//                "('Ramillies', 'Revenge', '1917')," +
//                "('Renown', 'Renown', '1916')," +
//                "('Repulse', 'Renown', '1916')," +
//                "('Resolution', 'Renown', '1916')," +
//                "('Revenge', 'Revenge', '1916')," +
//                "('Royal Oak', 'Revenge', '1916')," +
//                "('Royal Sovereign', 'Revenge', '1916')," +
//                "('South Dakota', 'North Carolina', '1941')," +
//                "('Tennessee', 'Tennessee', '1920')," +
//                "('Washington', 'North Carolina', '1941')," +
//                "('Wisconsin', 'Iowa', '1944')," +
//                "('Yamato', 'Yamato', '1941'); ");
//
//        statmt.execute("INSERT INTO 'outcomes' " +
//                "('ship', 'battle', 'result') " +
//                "VALUES " +
//                "('Bismarck', 'North Atlantic', 'sunk'), " +
//                "('California', 'Guadalcanal', 'damaged'), " +
//                "('California', 'Surigao Strait', 'ok')," +
//                "('Duke of York', 'North Cape', 'ok')," +
//                "('Fuso', 'Surigao Strait', 'sunk')," +
//                "('Hood', 'North Atlantic', 'sunk')," +
//                "('King George V', 'North Atlantic', 'ok')," +
//                "('Kirishima', 'Guadalcanal', 'sunk')," +
//                "('Prince of Wales', 'North Atlantic', 'damaged')," +
//                "('Rodney', 'North Atlantic', 'ok')," +
//                "('Schamhorst', 'North Cape', 'sunk')," +
//                "('South Dakota', 'Guadalcanal', 'damaged')," +
//                "('Tennessee', 'Surigao Strait', 'ok')," +
//                "('Washington', 'Guadalcanal', 'ok')," +
//                "('West Virginia', 'Surigao Strait', 'ok')," +
//                "('Yamashiro', 'Surigao Strait', 'sunk'); ");
//
//        statmt.execute("INSERT INTO 'battles' " +
//                "('name', 'date') " +
//                "VALUES " +
//                "('#Cuba62a', '1962-10-20 00:00:00.000'), " +
//                "('#Cuba62b', '1962-10-25 00:00:00.000'), " +
//                "('Guadalcanal', '1942-11-15 00:00:00.000')," +
//                "('North Atlantic', '1941-05-25 00:00:00.000')," +
//                "('North Cape', '1943-12-26 00:00:00.000')," +
//                "('Surigao Strait', '1944-10-25 00:00:00.000'); ");

        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Bismarck','bb','Germany','8','15.0','42000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Iowa','bb','USA','9','16.0','46000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Kongo','bc','Japan','8','14.0','32000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('North Carolina', 'bb','USA','12','16.0','37000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Renown','bc','Gt.Britain','6','15.0','32000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Revenge','bb','Gt.Britain','8','15.0','29000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Tennessee','bb','USA','12','14.0','32000');");
        statmt.execute("INSERT INTO Classes('class', 'type', 'country', 'numGuns', 'bore', 'displacement') VALUES ('Yamato','bb','Japan','9','18.0','65000');");

        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES ('California','Tennessee','1921');");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Haruna','Kongo','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Hiei','Kongo','1914')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Iowa','Iowa','1943')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Kirishima','Kongo','1915')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Kongo','Kongo','1913')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Missouri','Iowa','1944')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Musashi','Yamato','1942')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('New Jersey','Iowa','1943')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('North Carolina','North Carolina','1941')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Ramillies','Revenge','1917')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Renown','Renown','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Repulse','Renown','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Resolution','Renown','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Revenge','Revenge','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Royal Oak','Revenge','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Royal Sovereign','Revenge','1916')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('South Dakota','North Carolina','1941')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Tennessee','Tennessee','1920')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Washington','North Carolina','1941')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Wisconsin','Iowa','1944')");
        statmt.execute("INSERT INTO Ships('name', 'class', 'launched') VALUES('Yamato','Yamato','1941');");

        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('#Cuba62a','1962-10-20 00:00:00.000');");
        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('#Cuba62b','1962-10-25 00:00:00.000');");
        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('Guadalcanal','1942-11-15 00:00:00.000');");
        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('North Atlantic','1941-05-25 00:00:00.000');");
        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('North Cape','1943-12-26 00:00:00.000');");
        statmt.execute("INSERT INTO Battles('name', 'date') VALUES ('Surigao Strait','1944-10-25 00:00:00.000');");

        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Bismarck','North Atlantic','sunk');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('California','Guadalcanal','damaged');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('California','Surigao Strait','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Duke of York','North Cape','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Fuso','Surigao Strait','sunk');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Hood','North Atlantic','sunk');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('King George V','North Atlantic','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Kirishima','Guadalcanal','sunk');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Prince of Wales','North Atlantic','damaged');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Rodney','North Atlantic','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Schamhorst','North Cape','sunk');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('South Dakota','Guadalcanal','damaged');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Tennessee','Surigao Strait','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Washington','Guadalcanal','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('West Virginia','Surigao Strait','ok');");
        statmt.execute("INSERT INTO Outcomes('ship', 'battle', 'result')VALUES ('Yamashiro','Surigao Strait','sunk');");

        System.out.println("Tables filled");
    }

    /**
     * function that reads database and prints data to console
     * use result set from statement
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void readTables() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();

        resSet = statmt.executeQuery("SELECT * FROM 'battles'");

        System.out.println("All battles:");
        System.out.printf("%20s%30s\n\n", "NAME", "DATE");


        while(resSet.next())
        {
            String name = resSet.getString("name");
            String date = resSet.getString("date");

            System.out.printf("%20s%30s\n", name, date);
        }

        System.out.println("------------------------------------------------------------------------------------------");

        resSet = statmt.executeQuery("SELECT * FROM 'outcomes'");

        System.out.println("All outcomes:");
        System.out.printf("%20s%20s%20s\n\n", "SHIP", "BATTLE", "RESULT");


        while(resSet.next())
        {
            String ship = resSet.getString("ship");
            String battle = resSet.getString("battle");
            String result = resSet.getString("result");

            System.out.printf("%20s%20s%20s\n", ship, battle, result);
        }

        System.out.println("------------------------------------------------------------------------------------------");

        resSet = statmt.executeQuery("SELECT * FROM 'ships'");

        System.out.println("All ships:");
        System.out.printf("%20s%20s%20s\n\n", "NAME", "CLASS", "LAUNCHED");

        while(resSet.next())
        {
            String name = resSet.getString("name");
            String shipClass = resSet.getString("class");
            int launched = resSet.getInt("launched");

            System.out.printf("%20s%20s%20s\n", name, shipClass, launched);
        }

        System.out.println("------------------------------------------------------------------------------------------");

        resSet = statmt.executeQuery("SELECT * FROM 'classes'");

        System.out.println("All classes:");
        System.out.printf("%15s%15s%15s%15s%15s%15s\n\n", "CLASS", "TYPE", "COUNTRY", "NUMGUNS", "BORE", "DISPLACEMENT");


        while(resSet.next())
        {
            String shipClass = resSet.getString("class");
            String type = resSet.getString("type");
            String country = resSet.getString("country");
            int numGuns = resSet.getInt("numGuns");
            double bore = resSet.getInt("bore");
            int displacement = resSet.getInt("displacement");

            System.out.printf("%15s%15s%15s%15s%15s%15s\n", shipClass,type, country, numGuns, bore, displacement);
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Tables showed");
    }

    /**
     * deletes all tables from database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void deleteTables() throws ClassNotFoundException, SQLException {

//        statmt = conn.createStatement();

        statmt.execute("DROP TABLE 'ships'");
        statmt.execute("DROP TABLE 'classes'");
        statmt.execute("DROP TABLE 'outcomes'");
        statmt.execute("DROP TABLE 'battles'");

        System.out.println("Tables deleted");
    }

    /**
     * Closes all connections
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void closeDB() throws ClassNotFoundException, SQLException {
        conn.close();
        resSet.close();

        System.out.println("Connections closed");
    }

    /**
     * Deletes some rows from tables in database, according for some conditions
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void deleteRows() throws ClassNotFoundException, SQLException {

        statmt.execute("DELETE FROM battles WHERE date > '1944-01-01'");

        statmt.execute("DELETE FROM outcomes WHERE battle NOT IN (SELECT name FROM battles)");

        statmt.execute("DELETE FROM ships WHERE name IN(SELECT ship FROM outcomes WHERE outcomes.battle NOT IN (SELECT name FROM battles))");

        statmt.execute("DELETE FROM classes WHERE class NOT IN (SELECT class FROM ships)");

        System.out.println("Rows deleted");
    }
}
