package pl.sda;

import com.itextpdf.text.DocumentException;
import pl.sda.csv.CSVMyFileReader;
import pl.sda.csv.CSVMyFileWriter;
import pl.sda.csv.MyGeneral;

import java.io.IOException;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        CSVMyFileReader reader = new CSVMyFileReader();
        CSVMyFileWriter write = new CSVMyFileWriter();
        PDFMyFileWriter pdfWrite = new PDFMyFileWriter();
        MyGeneral dateSets;
        try {
//            dateSets = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\ludziska.csv");
            dateSets = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\mieszkania.csv");
//            write.writeData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\mieszkania2.csv",dateSets);
            pdfWrite.writeData("",dateSets);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("");

//        List<Person> people;
//        try {
//            people = reader.readPersonData("C:\\Users\\pllsym\\IdeaProjects\\javapoz7-design-patterns\\J7_FileParsing\\ludziska.csv");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("");

    }





}
