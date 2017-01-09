import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by hina on 2017/01/02.
 */
public class WebFortune {

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

//        WebFortune pin = new WebFortune();
//        String result = pin.getUrl(urlstring);
//        System.out.println(result);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String today = dateFormat.format(new Date());
        System.out.println(today);
        String fortuneUrl = "http://api.jugemkey.jp/api/horoscope/free/"+ today;

        String fortuneJson = executeGet(fortuneUrl);

        fortuneJson = fortuneJson.replace(today, "dayInfo");
        System.out.println(fortuneJson);
        HoroscopeList jsonObject = JsonConverter.toObject(fortuneJson, new TypeReference<HoroscopeList>() {
        });
        System.out.println(jsonObject.getHoroscope().getDayInfo().get(0).getContent());

    }

}
