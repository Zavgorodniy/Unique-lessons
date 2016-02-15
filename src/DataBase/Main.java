package DataBase;

public class Main {

    public static void main(String[] args) {

        try {
            DB.connect();
            DB.createTables();
            DB.writeTables();
            DB.readTables();
//            DB.statmt.execute("DELETE FROM 'ships' WHERE launched < 1940");
//            DB.readTables();
            DB.closeDB();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
