package pl.sda;

import java.io.IOException;

public interface MyFileReader {
    MyGeneral readData(String filePath) throws IOException;
}
