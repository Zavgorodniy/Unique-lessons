package DataBase;

import java.sql.*;

public class DB {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void connect() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");

        conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");

        System.out.println("Connection created");
    }

    public static void createTables() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();

        statmt.execute("CREATE TABLE if not exists 'classes' ('class' varchar (50) NOT NULL, 'type' varchar (2) NOT NULL, " +
                "'country' varchar (20) NOT NULL, 'numGuns' tinyint, 'bore' real, 'displacement' int);");
        statmt.execute("CREATE TABLE if not exists 'ships' ('name' varchar (50) PRIMARY KEY NOT NULL, 'class' varchar (50) NOT NULL, 'launched' smallint);");
        statmt.execute("CREATE TABLE if not exists 'outcomes' ('ship' varchar (20) NOT NULL, 'battle' varchar (20) NOT NULL, 'result' varchar(10) NOT NULL);");
        statmt.execute("CREATE TABLE if not exists 'battles' ('name' varchar (50) PRIMARY KEY NOT NULL, 'date' datetime NOT NULL);");

        System.out.println("Tables created or exist");
    }

    /**
     *
     * @throws SQLException
     */
    public static void writeTables() throws SQLException {
        statmt.execute("INSERT INTO 'classes' " +
                "('class','type', 'country', 'numGuns', 'bore', 'displacement') " +
                "VALUES " +
                "('Bismarck','bb','Germany','8','15.0','42000'), " +
                "('Iowa','bb','USA','9','16.0','46000'), " +
                "('Kongo','bc','Japan','8','14.0','32000')," +
                "('North Carolina','bb','USA','12','16.0','37000')," +
                "('Renown','bc','Gt.Britain','6','15.0','32000')," +
                "('Revenge','bb','Gt.Britain','8','15.0','29000')," +
                "('Tennessee','bb','USA','12','14.0','32000')," +
                "('Yamato','bb','Japan','9','18.0','65000'); ");

        statmt.execute("INSERT INTO 'ships' " +
                "('name', 'class', 'launched') " +
                "VALUES " +
                "('California', 'Tennessee', '1921'), " +
                "('Haruna', 'Kongo', '1916'), " +
                "('Hiei', 'Kongo', '1914')," +
                "('Iowa', 'Iowa', '1943')," +
                "('Kirishima', 'Kongo', '1915')," +
                "('Kongo', 'Kongo', '1913')," +
                "('Missouri', 'Iowa', '1944')," +
                "('Musashi', 'Yamato', '1942')," +
                "('New Jersey', 'Iowa', '1943')," +
                "('North Carolina', 'North Carolina', '1941')," +
                "('Ramillies', 'Revenge', '1917')," +
                "('Renown', 'Renown', '1916')," +
                "('Repulse', 'Renown', '1916')," +
                "('Resolution', 'Renown', '1916')," +
                "('Revenge', 'Revenge', '1916')," +
                "('Royal Oak', 'Revenge', '1916')," +
                "('Royal Sovereign', 'Revenge', '1916')," +
                "('South Dakota', 'North Carolina', '1941')," +
                "('Tennessee', 'Tennessee', '1920')," +
                "('Washington', 'North Carolina', '1941')," +
                "('Wisconsin', 'Iowa', '1944')," +
                "('Yamato', 'Yamato', '1941'); ");

        statmt.execute("INSERT INTO 'outcomes' " +
                "('ship', 'battle', 'result') " +
                "VALUES " +
                "('Bismarck', 'North Atlantic', 'sunk'), " +
                "('California', 'Guadalcanal', 'damaged'), " +
                "('California', 'Surigao Strait', 'ok')," +
                "('Duke of York', 'North Cape', 'ok')," +
                "('Fuso', 'Surigao Strait', 'sunk')," +
                "('Hood', 'North Atlantic', 'sunk')," +
                "('King George V', 'North Atlantic', 'ok')," +
                "('Kirishima', 'Guadalcanal', 'sunk')," +
                "('Prince of Wales', 'North Atlantic', 'damaged')," +
                "('Rodney', 'North Atlantic', 'ok')," +
                "('Schamhorst', 'North Cape', 'sunk')," +
                "('South Dakota', 'Guadalcanal', 'damaged')," +
                "('Tennessee', 'Surigao Strait', 'ok')," +
                "('Washington', 'Guadalcanal', 'ok')," +
                "('West Virginia', 'Surigao Strait', 'ok')," +
                "('Yamashiro', 'Surigao Strait', 'sunk'); ");

        statmt.execute("INSERT INTO 'battles' " +
                "('name', 'date') " +
                "VALUES " +
                "('#Cuba62a', '1962-10-20 00:00:00.000'), " +
                "('#Cuba62b', '1962-10-25 00:00:00.000'), " +
                "('Guadalcanal', '1942-11-15 00:00:00.000')," +
                "('North Atlantic', '1941-05-25 00:00:00.000')," +
                "('North Cape', '1943-12-26 00:00:00.000')," +
                "('Surigao Strait', '1944-10-25 00:00:00.000'); ");

        System.out.println("Tables filled");
    }

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

    public static void deleteTables() throws ClassNotFoundException, SQLException {

//        statmt = conn.createStatement();

        statmt.execute("DROP TABLE 'ships'");
        statmt.execute("DROP TABLE 'classes'");
        statmt.execute("DROP TABLE 'outcomes'");
        statmt.execute("DROP TABLE 'battles'");

        System.out.println("Tables deleted");
    }

    public static void closeDB() throws ClassNotFoundException, SQLException {
        conn.close();
        resSet.close();

        System.out.println("Connections closed");
    }

    public static void deleteRows() throws ClassNotFoundException, SQLException {

        statmt.execute("DELETE FROM battles WHERE date < '1944-01-01'");

        statmt.execute("DELETE FROM outcomes WHERE battle NOT IN (SELECT name FROM battles)");

        statmt.execute("DELETE FROM ships WHERE name NOT IN (SELECT ship FROM outcomes)");

        statmt.execute("DELETE FROM classes WHERE class NOT IN (SELECT class FROM ships)");

        System.out.println("Rows deleted");
    }

    public static void selectRows() throws ClassNotFoundException, SQLException {

        resSet = statmt.executeQuery("SELECT DISTINCT class FROM classes" +
                "JOIN ships ON ships.class = classes.class" +
                "JOIN outcomes ON outcomes.ship = ships.name" +
                "JOIN battles ON battles.name = outcomes.battle" +
                "WHERE battles.date > '1944-01-01'");

        System.out.println("Selected classes:");

        while(resSet.next())
        {
            String shipClass = resSet.getString("class");

            System.out.printf("%15s\n", shipClass);
        }

        System.out.println("Rows Selected");
    }
}
