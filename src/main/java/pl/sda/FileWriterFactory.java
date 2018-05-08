package pl.sda;

import pl.sda.csv.CSVMyFileWriter;
import pl.sda.excel.ExcelMyFileWriter;
import pl.sda.pdf.PDFMyFileWriter;

public class FileWriterFactory {
    public static MyFileWriter produce(String filePath){
        MyFileWriter result = null;

        if(filePath.toLowerCase().endsWith(".csv")){
            result = new CSVMyFileWriter();
        }else if(filePath.toLowerCase().endsWith(".pdf")){
            result = new PDFMyFileWriter();
        }else if(filePath.toLowerCase().endsWith(".xlsx")){
            result = new ExcelMyFileWriter();
        }


        return result;
    }
}
