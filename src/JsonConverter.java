import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Created by hina on 2017/01/07.
 */
public class JsonConverter {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonConverter() {
        // do nothing
    }

    public static String toString(final Object object) throws JsonGenerationException, JsonMappingException,
            IOException {

        String json = mapper.writeValueAsString(object);

        return json;
    }

    public static <T> T toObject(final File jsonString, final TypeReference<GoogleImgList> clazz) throws JsonParseException,
            JsonMappingException, IOException {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        T object = null;

        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, clazz);

        return object;
    }

    public static <T> T toObject(String jsonString,
                                 TypeReference<T> valueTypeRef) throws JsonParseException, JsonMappingException, IOException{

        //未知フィールドにも対応
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        T object = null;

        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, valueTypeRef);

        return object;
    }
}
