package pl.sda;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface MyFileWriter {
    void writeData(String filePath, MyGeneral datesets) throws IOException, DocumentException;

}
