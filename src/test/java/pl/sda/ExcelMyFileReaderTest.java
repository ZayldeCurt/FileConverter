package pl.sda;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.excel.ExcelMyFileReader;
import pl.sda.excel.ExcelMyFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelMyFileReaderTest {

    @Test
    public void testReadData() {
        //given
        MyGeneral testDate = new MyGeneral();
        List<String> headers = new ArrayList<>();
        headers.add("name");
        headers.add("lastName");
        headers.add("age");
        testDate.setHeaders(headers);
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "michal");
        map1.put("lastName", "swiatowy");
        map1.put("age", "25");
        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "adam");
        map2.put("lastName", "nowak");
        map2.put("age", "12");
        Map<String, String> map3 = new HashMap<>();
        map3.put("name", "julia");
        map3.put("lastName", "okulska");
        map3.put("age", "19");
        testDate.add(map1);
        testDate.add(map2);
        testDate.add(map3);

        MyGeneral dataSets=new MyGeneral();
        ExcelMyFileReader reader = new ExcelMyFileReader();

        String CSV_FILE_NAME = "ludziska.xlsx";
        String filePath = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        //when

        try {

            dataSets = reader.readData(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then

        Assert.assertEquals(testDate,dataSets);



    }
}
