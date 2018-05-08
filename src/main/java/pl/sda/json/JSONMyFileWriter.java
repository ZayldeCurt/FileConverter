package pl.sda.json;

import com.itextpdf.text.DocumentException;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.MyFileWriter;
import pl.sda.MyGeneral;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONMyFileWriter implements MyFileWriter {
    @Override
    public void writeData(String filePath, MyGeneral datesets) throws IOException, DocumentException {
        List<String> dataToWrite= new ArrayList<>();
        dataToWrite.add("{");
        dataToWrite.add("\"values\": [");

        datesets.getDatesets().forEach(map -> {
            dataToWrite.add("{");
            datesets.getHeaders().forEach(e->dataToWrite.add("\""+e+"\": \""+map.get(e)+"\""));
            dataToWrite.add("},");}
            );
        dataToWrite.remove(dataToWrite.size()-1);
        dataToWrite.add("{");
        dataToWrite.add("]");
        dataToWrite.add("}");

        Path file = Paths.get("the-file-name.txt");
        Files.write(file,dataToWrite);
    }
    public void write(String filePath, MyGeneral dataSets) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            JSONArray jsonArray = new JSONArray();

            for(int i=0;i<dataSets.getDatesets().size();i++){
                JSONObject valueJSON = new JSONObject();
                for (int j = 0; j < dataSets.getHeaders().size(); j++) {
                    valueJSON.put(dataSets.getHeaders().get(j), dataSets.getDatesets().get(i).get(dataSets.getHeaders().get(j)));
                }
                jsonArray.put(valueJSON);
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", jsonArray);

            bufferedWriter.write(jsonObject.toString());

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
