import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hina on 2017/01/07.
 */
public class JsonConverter {
    private static final String SAMPLE_JSON = "{\"value\":100,\"string\":\"hogehoge\",\"map\":{\"key2\":\"value2\",\"key1\":\"value1\"},\"list\":[\"item1\",\"item2\"]}";
    public static void main(String[] args) throws IOException{
        JsonObject jsonObject = JsonConverter.toObject(SAMPLE_JSON, JsonObject.class);

        // Map⇒JSON文字列
        Map<String, JsonObject> jsonMap = new HashMap<String, JsonObject>();
        jsonMap.put("key1", jsonObject);

        String jsonString = JsonConverter.toString(jsonMap);

        System.out.println("jsonString=" + jsonString);

        // JSON文字列⇒Map
        Map<String, JsonObject> jsonMap2 = JsonConverter.toObject(jsonString,
                new TypeReference<Map<String, JsonObject>>() {
                });

        for (Map.Entry<String, JsonObject> e : jsonMap2.entrySet()) {
            JsonObject jsonObject2 = e.getValue();
            System.out.println(jsonObject2.value);
            System.out.println(jsonObject2.string);
            for(String str : jsonObject2.list) {
                System.out.println(str);
            }
            for(Map.Entry<String, String> e2 : jsonObject2.map.entrySet()) {
                System.out.println(String.format("%s=%s", e2.getKey(),e2.getValue()));
            }

        }

    }

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonConverter() {
        // do nothing.
    }

    public static String toString(final Object object) throws JsonGenerationException, JsonMappingException,
            IOException {

        String json = mapper.writeValueAsString(object);

        return json;
    }

    public static <T> T toObject(final String jsonString, final Class<T> clazz) throws JsonParseException,
            JsonMappingException, IOException {

        T object = null;

        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, clazz);

        return object;
    }

    public static <T> T toObject(String jsonString,
                                 TypeReference<T> valueTypeRef) throws JsonParseException, JsonMappingException, IOException {

        T object = null;

        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, valueTypeRef);

        return object;
    }
}
