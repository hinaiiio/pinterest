import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hina on 2017/01/02.
 */
public class accessPinterest {


    private static ArrayList<String> json = new ArrayList<>();
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

    private static String executeGet(String urlString) {
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
//                            json.add(line);
                            return line;

                        }
                    }
                }
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String userID = "4868824896827835698";
        String token = "AXgwptye3at4hgMENgey1atnxM_3FJXotQ4k0dpDrV-Ar0AtWgAAAAA";
        String bordname = "hair";
        String urlstring
                = "https://api.pinterest.com/v1/boards/" + userID + "/" + bordname + "/pins/?access_token=" + token;
//        = "https://api.pinterest.com/v1/me/pins/";

//        accessPinterest pin = new accessPinterest();
//        String result = pin.getUrl(urlstring);
//        System.out.println(result);
        String date = "2017/01/01";
        String fortuneUrl = "http://api.jugemkey.jp/api/horoscope/free/"+date;

        String fortuneJson = executeGet(fortuneUrl);

        System.out.println(fortuneJson);

//        HoroscopeList jsonObject = JsonConverter.toObject(fortuneJson, HoroscopeList.class);

        // Map⇒JSON文字列
//        Map<String, HoroscopeList> jsonMap = new HashMap<String, HoroscopeList>();
//        jsonMap.put("key1", jsonObject);
//
//        String jsonString = JsonConverter.toString(jsonMap);
//
//        System.out.println("jsonString=" + jsonString);

        // JSON文字列⇒Map
        Map<String, HoroscopeList> jsonMap2 = JsonConverter.toObject(fortuneJson,
                new TypeReference<Map<String, HoroscopeList>>() {
                });

        for (Map.Entry<String, HoroscopeList> e : jsonMap2.entrySet()) {
            HoroscopeList jsonObject2 = e.getValue();
            System.out.println(jsonObject2);
        }

//        JsonDecode jsonDecode = new JsonDecode();
//        jsonDecode.parse("sample.json");
//        jsonDecode.parse("test.json");

    }

}
