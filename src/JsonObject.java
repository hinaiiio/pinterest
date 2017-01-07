/**
 * Created by hina on 2017/01/07.
 */
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObject {

    public int value;

    public String string;

    public Map<String, String> map;

    public List<String> list;


}
