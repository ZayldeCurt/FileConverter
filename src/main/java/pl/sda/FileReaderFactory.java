package pl.sda;

import pl.sda.csv.CSVMyFileReader;
import pl.sda.excel.ExcelMyFileReader;
import pl.sda.json.JSONMyFileReader;

public class FileReaderFactory {
    public static MyFileReader produce(String filePath){
        MyFileReader result = null;

        if(filePath.toLowerCase().endsWith(".csv")){
            result = new CSVMyFileReader();
        }else if(filePath.toLowerCase().endsWith(".json")){
            result = new JSONMyFileReader();

        } else if(filePath.toLowerCase().endsWith(".xlsx")){
            result = new ExcelMyFileReader();
        }
        return result;
    }
}
