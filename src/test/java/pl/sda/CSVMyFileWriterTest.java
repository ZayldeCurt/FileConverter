package pl.sda;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.csv.CSVMyFileReader;
import pl.sda.csv.CSVMyFileWriter;
import pl.sda.csv.MyGeneral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVMyFileWriterTest {

    @Test
    public void testWriteData(){

        //given
        String CSV_FILE_NAME_TEST_DATE = "ludziska.csv";

        CSVMyFileReader reader = new CSVMyFileReader();
        CSVMyFileWriter write = new CSVMyFileWriter();
        MyGeneral dateSets = null;

        String filePathTestDate = getClass().getClassLoader().getResource(CSV_FILE_NAME_TEST_DATE).getPath();


        try {
            dateSets = reader.readData(filePathTestDate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //when
        try {
            write.writeData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\src\\test\\resources\\ludziska2.csv",dateSets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyGeneral dateSets2 = null;
        try {
            dateSets2 = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\src\\test\\resources\\ludziska2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then

        Assert.assertEquals(dateSets,dateSets2);


    }
}
