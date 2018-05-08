package pl.sda;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.csv.CSVMyFileReader;
import pl.sda.csv.CSVMyFileWriter;
import pl.sda.excel.ExcelMyFileReader;
import pl.sda.excel.ExcelMyFileWriter;

import java.io.IOException;

public class ExcelMyFileWriterTest {
    @Test
    public void testWriteData() {
        //given
        String EXCEL_FILE_NAME_TEST_DATE = "ludziska.csv";

        CSVMyFileReader readerCSV = new CSVMyFileReader();
        ExcelMyFileReader reader = new ExcelMyFileReader();
        ExcelMyFileWriter write = new ExcelMyFileWriter();
        MyGeneral dateSets = null;

        String filePathTestDate = getClass().getClassLoader().getResource(EXCEL_FILE_NAME_TEST_DATE).getPath();


        try {
            dateSets = readerCSV.readData(filePathTestDate);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        //when
        try {
            write.writeData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\src\\test\\resources\\ludziska1.xlsx", dateSets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyGeneral dateSets2 = null;
        try {
            dateSets2 = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\src\\test\\resources\\ludziska1.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then

        Assert.assertEquals(dateSets, dateSets2);
    }

}
