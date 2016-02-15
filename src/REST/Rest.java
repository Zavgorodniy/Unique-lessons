//package REST;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class Rest {
//    public static void getRest(String stringUrl, String key) {
//        URL url;
//        HttpURLConnection connection;
//        StringBuilder buff = new StringBuilder();
//
//        try {
//            url = new URL(stringUrl);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                buff.append(in.readLine());
//            }else{
//                System.out.println("connection is fail");
//            }
//
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) parser.parse(buff.toString());
//
//            System.out.print(jsonObject.get(key));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
