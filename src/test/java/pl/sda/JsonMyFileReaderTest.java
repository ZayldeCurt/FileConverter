package pl.sda;

import com.itextpdf.text.DocumentException;
import org.junit.Assert;
import org.junit.Test;
import pl.sda.csv.CSVMyFileReader;
import pl.sda.json.JSONMyFileReader;
import pl.sda.json.JSONMyFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMyFileReaderTest {

    @Test
    public void testReadData() throws IOException, DocumentException {
        //given
        MyGeneral testDate = new MyGeneral();
        List<String> headers = new ArrayList<>();
        headers.add("name");
        headers.add("lastName");
        headers.add("age");
        testDate.setHeaders(headers);
        Map<String,String> map1 = new HashMap<>();
        map1.put("name","michal");
        map1.put("lastName","swiatowy");
        map1.put("age","25");
        Map<String,String> map2 = new HashMap<>();
        map2.put("name","adam");
        map2.put("lastName","nowak");
        map2.put("age","12");
        Map<String,String> map3 = new HashMap<>();
        map3.put("name","julia");
        map3.put("lastName","okulska");
        map3.put("age","19");
        testDate.add(map1);
        testDate.add(map2);
        testDate.add(map3);

        MyGeneral dateSets=new MyGeneral();
        JSONMyFileReader reader = new JSONMyFileReader();


        String JSON_FILE_NAME = "ludziska.json";
        String filePath = getClass().getClassLoader().getResource(JSON_FILE_NAME).getPath();
        //when
        try {
            dateSets = reader.readData(filePath.substring(1,filePath.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        Assert.assertEquals(testDate,dateSets);

    }
}
