package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.MyFileReader;
import pl.sda.MyGeneral;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JSONMyFileReader implements MyFileReader {
    @Override
    public MyGeneral readData(String filePath) throws IOException {
        MyGeneral dataSets = new MyGeneral();
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes,"UTF-8");


        JSONObject jsonObject = new JSONObject(json);
        String rootKey = jsonObject.keySet().iterator().next();
        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        boolean flaga=true;

        for(Object rawValue : rawValues){
            JSONObject value = new JSONObject(rawValue.toString());
            Map<String,String> map = new HashMap<>();

            if(flaga){
                List<String> headerList;//=new ArrayList<>();
//                Set<String> headerSet= value.keySet();
                headerList = new ArrayList<>(value.keySet());
                dataSets.setHeaders(headerList);
                flaga=false;
            }
            dataSets.getHeaders().forEach(s->map.put(s,value.get(s).toString()));
            dataSets.add(map);
        }

        return dataSets;
    }

//    public static void main(String[] args) {
//        MyGeneral dataSets = new MyGeneral();
//        try {
//            dataSets = readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\src\\test\\resources\\ludziska.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
