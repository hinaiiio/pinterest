import sun.text.normalizer.UTF16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by hina on 2017/01/02.
 */
public class accessPinterest {
    public static void main(String[] args) {
        String userID = "4868824896827835698";
        String token = "AXgwptye3at4hgMENgey1atnxM_3FJXotQ4k0dpDrV-Ar0AtWgAAAAA";
        String bordname = "hair";
        String urlstring
                = "https://api.pinterest.com/v1/boards/" + userID + "/" + bordname + "/pins/?access_token=" + token;
//        = "https://api.pinterest.com/v1/me/pins/";

//        accessPinterest pin = new accessPinterest();
//        String result = pin.getUrl(urlstring);
//        System.out.println(result);
        String fortuneurl = "http://api.jugemkey.jp/api/horoscope/free/2017/01/01";
        executeGet(fortuneurl);

    }

    public String getUrl(String urlstring){
        try{
            URL url = new URL(urlstring);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);

            ArrayList<String> list= new ArrayList<>();
            while (reader.readLine() != null){
                list.add(reader.readLine());
                System.out.println(reader.lines());
            }
            return list.get(1);
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    private static void executeGet(String urlString) {
        System.out.println("===== HTTP GET Start =====");
        try {
//            URL url = new URL("http://localhost:8080/get?param=value");

            URL url = new URL(urlString);
            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                            StandardCharsets.UTF_8);
                         BufferedReader reader = new BufferedReader(isr)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
                System.out.println("flg");

            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===== HTTP GET End =====");
    }
}