package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Set;

public class JsonParsingTest {


    @Test
    public void jsonTest(){
        String json=
                "{"+
                        "\"klucz1\" : {" +
                        "\"zagniezdonyKlucz1\" : \"zagniezdzonaWartosc1\"," +
                        "\"zagniezdonyKlucz2\" : \"zagniezdzonaWartosc2\"" +
                        "}," +
                        "\"klucz2\" : \"wartosc2\","+
                "}";
        JSONObject jsonObject = new JSONObject(json);
////        Set<String> keyset = jsonObject.keySet();
//        System.out.println(jsonObject.get("klucz1"));
//        System.out.println(jsonObject.get("klucz2"));


        JSONObject nestedJsonObject = new JSONObject(jsonObject.get("klucz1").toString());

//        System.out.println(nestedJsonObject.get("zagniezdonyKlucz1"));
//        System.out.println(nestedJsonObject.get("zagniezdonyKlucz2"));

    }

    @Test
    public void jsonTest2(){
        String json= "{\"values\":["+
                "{\"klucz1\": \"wartosc1\"},"+
                "{\"klucz2\": \"wartosc2\"}]}";

        JSONObject jsonObject = new JSONObject(json);
//        System.out.println(jsonObject);

        JSONArray jsonArray = new JSONArray(jsonObject.get("values").toString());
//        System.out.println(jsonArray.get(0));

        JSONObject jsonFromArray = new JSONObject(jsonArray.get(0).toString());
//        System.out.println(jsonFromArray.get("klucz1"));


    }

}
