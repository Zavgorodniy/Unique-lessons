package DataBase;

public class MainDataBase {

    public static void main(String[] args) {

        try {
            DB.connect();
//            DB.createTables();
//            DB.writeTables();
            DB.readTables();

            DB.selectRows();
//            DB.deleteRows();
//
//            DB.readTables();
//            DB.deleteTables();
            DB.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
