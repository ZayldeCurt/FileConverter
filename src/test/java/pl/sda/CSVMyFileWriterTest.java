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
        CSVMyFileReader reader = new CSVMyFileReader();
        CSVMyFileWriter write = new CSVMyFileWriter();
        MyGeneral dateSets = null;

        try {
            dateSets = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\ludziska.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //when
        try {
            write.writeData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\ludziska2.csv",dateSets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyGeneral dateSets2 = null;
        try {
            dateSets2 = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\ludziska2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then

        Assert.assertEquals(dateSets,dateSets2);


    }
}
