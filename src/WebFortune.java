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

    public WebFortune() {
    }

    private static String executeGet(String urlString) {
        try {
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

    public static HoroscopeList getFortune() throws IOException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String today = dateFormat.format(new Date());
        String fortuneUrl = "http://api.jugemkey.jp/api/horoscope/free/"+ today;

        String fortuneJson = executeGet(fortuneUrl);

        fortuneJson = fortuneJson.replace(today, "dayInfo");
        HoroscopeList jsonObject = JsonConverter.toObject(fortuneJson, new TypeReference<HoroscopeList>() {
        });

        return jsonObject;
    }

}
