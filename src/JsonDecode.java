import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hina on 2017/01/03.
 */
public class JsonDecode {
    public void parse(String json) throws JsonParseException,
            JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
//        json = mapper.writeValueAsString(new HyyoroscopeList());
//        json = mapper.writeValueAsString(new Test.PersonList());
//        HoroscopeList horoscopeList = mapper.readValue(new File("sample.json"), HoroscopeList.class);
//     Test.PersonList horoscopeList = mapper.readValue(new File("test.json"), Test.PersonList.class);
//        System.out.println(horoscopeList.getPersons().get(2).getName());
//        System.out.println(horoscopeList.getHoroscope().getDate().get(1).getSign());

//        FortuneInfo fortuneInfo = new ObjectMapper().readValue(new File(json), FortuneInfo.class);
//
//        FortuneInfo.Horoscopes horoscopes = fortuneInfo.getHoroscope();

//        for(Map.Entry<String, Horoscope> HoroscopesEntry : horoscopes.getHoroscopes().entrySet()){
//            if(HoroscopesEntry.getKey() == "2017/01/01"){
//                Horoscope horoscope = HoroscopesEntry.getValue();
//                System.out.println(horoscope.getSign());
//
//            }
//
//        }

    }

}
