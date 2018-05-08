package pl.sda.csv;


import pl.sda.MyFileReader;
import pl.sda.MyGeneral;
import pl.sda.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVMyFileReader implements MyFileReader {

    public MyGeneral readData(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String line;
        List<String> headers = new ArrayList<>();
        MyGeneral dateSets = new MyGeneral();
        int i=0;
        while((line=bufferedReader.readLine()) != null && !line.isEmpty()){
            if(i==0){
                String[] hTemp=line.split(";");
                for (int j = 0; j < hTemp.length; j++) headers.add(hTemp[j]);
                dateSets.setHeaders(headers);
                i++;
            }
            else{
                String[] tmp = line.split(";");
                Map<String,String> map = new HashMap<>();
                for (int j = 0; j < headers.size(); j++) {
                    map.put(headers.get(j),tmp[j]);
                }
                dateSets.add(map);
            }
        }
        return dateSets;
    }





    public List<Person> readPersonData(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        String[] headers = null;
        List<Person> persons = new ArrayList<>();

        int i=0;
        while((line=bufferedReader.readLine()) != null && !line.isEmpty()){
            if(i==0){
                headers= line.split(";");
                i++;
            }
            else{
                Person parsePerson = parseCSVRow(headers,line);
                persons.add(parsePerson);
            }
        }
        return persons;
    }

    private Person parseCSVRow(String[] headers, String line) {
        Person person = new Person();
        String[] values = line.split(";");
        for (int i = 0; i < headers.length; i++) {
            setPersonFieldFromCSVFile(person,headers[i],values[i]);
        }
        return person;
    }

    private void setPersonFieldFromCSVFile(Person person, String header, String value) {
        switch(header){
            case "name":
                person.setName(value);
                break;
            case "lastName":
                person.setLastName(value);
                break;
            case "age":
                person.setAge(Integer.parseInt(value));
                break;
            default:
                System.out.println("brak takiego pola");
        }
    }

}
