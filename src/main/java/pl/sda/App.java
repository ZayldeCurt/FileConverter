package pl.sda;

import pl.sda.csv.CSVMyFileReader;
import pl.sda.csv.CSVMyFileWriter;
import pl.sda.csv.MyGeneral;

import java.io.IOException;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        CSVMyFileReader reader = new CSVMyFileReader();
        CSVMyFileWriter write = new CSVMyFileWriter();
        MyGeneral dateSets;
        try {
//            dateSets = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\ludziska.csv");
            dateSets = reader.readData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\mieszkania.csv");
            write.writeData("C:\\Users\\pllsym\\IdeaProjects\\J7_FileParsing\\mieszkania2.csv",dateSets);
        } catch (IOException e) {
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
