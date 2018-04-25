package pl.sda;

import pl.sda.csv.MyGeneral;

import java.io.IOException;

public interface MyFileReader {
    MyGeneral readData(String filePath) throws IOException;
}
