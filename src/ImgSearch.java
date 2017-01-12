import com.fasterxml.jackson.core.type.TypeReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

/**
 * Created by hina on 2017/01/10.
 */
public class ImgSearch {

private static String getGoogleResult(String color) {
        try {
            String apikey = "AIzaSyCQhhCeglUhk8ORw-GvIdpFr4783Gw8o84";
            String searchEngineID = "008054080017512746605:go5ve5appbm";

            URL url = new URL(
                    "https://www.googleapis.com/customsearch/v1?key="+ apikey +"&"+"cx="+ searchEngineID +"&searchType=image&q=コーデ,"+color+","+getSeson()+"&num=2&excludeTerms=メンズ"
            );
            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                            StandardCharsets.UTF_8);
                         BufferedReader reader = new BufferedReader(isr)) {
                        String line;
                        StringBuilder result = new StringBuilder();
                        while ((line = reader.readLine()) != null) {
                            //System.out.println(line);
                            result.append(line + "\n");
                        }
                        return new String(result);
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

    private static String getSeson(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;
        String result;
        switch (month)
        {
            case 3:
            case 4:
            case 5:
                result= "春";
                break;
            case 6:
            case 7:
            case 8:
                result= "夏";
                break;
            case 9:
            case 10:
            case 11:
                result= "秋";
                break;
            case 12:
            case 1:
            case 2:
                result= "冬";
                break;
            default:
                result= "";
        }

        return result;
    }

    public static GoogleImgList getImage(String color) throws IOException{
        String json = getGoogleResult(color);
        GoogleImgList jsonObject = JsonConverter.toObject(json, new TypeReference<GoogleImgList>() {});
//        GoogleImgList jsonObject = JsonConverter.toObject(new File("test.json"), new TypeReference<GoogleImgList>() {});

        return jsonObject;
    }

}
