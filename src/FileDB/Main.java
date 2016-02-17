package FileDB;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Data.Conn();
            Data.readTables();
            Data.writeFiles();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
