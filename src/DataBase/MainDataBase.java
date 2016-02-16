package DataBase;

import java.sql.SQLException;

public class MainDataBase {

    public static void main(String[] args) {

        try {
            DB.connect();
            DB.createTables();
            DB.writeTables();
            DB.readTables();

            DB.deleteRows();

            DB.readTables();
            DB.deleteTables();
            DB.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        } finally {

        }
    }

}