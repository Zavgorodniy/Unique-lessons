package DataBase;

import java.sql.*;

public class SQLite {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite://D:\\dev\\SQLiteStudio\\ships");

        System.out.println("Connection created");
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
//        statmt.execute("CREATE TABLE if not exists 'students' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'nick' varchar , 'teacher' bool);");

        System.out.println("Table created or exist");
    }

    public static void WriteDB() throws SQLException
    {
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Holodov', 'true'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Nick', 'false'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Ksey', 'false'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('June', 'false'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Mark', 'false'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Lego', 'false'); ");
//        statmt.execute("INSERT INTO 'students' ('nick', 'teacher') VALUES ('Skif', 'false'); ");

        System.out.println("Table filled");
    }

    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM students");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  nick = resSet.getString("nick");
            String  teacher = resSet.getString("teacher");
            System.out.println( "id = " + id );
            System.out.println( "nick = " + nick );
            System.out.println( "teacher = " + teacher );
            System.out.println();
        }

        System.out.println("Table showed");

        statmt.execute("DROP TABLE 'students'");
    }

    public static void closeDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        resSet.close();

        System.out.println("Connections closed");
    }
}
