package pl.sda.csv;

import pl.sda.MyFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CSVMyFileWriter implements MyFileWriter {

    public void writeData(String filePath, MyGeneral datesets) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            String tmp = "";
            for (int i = 0; i < datesets.getHeaders().size() - 1; i++) {
                tmp += datesets.getHeaders().get(i) + ";";
            }
            tmp += datesets.getHeaders().get(datesets.getHeaders().size() - 1)+"\n";
            bufferedWriter.write(tmp);
            for (int i = 0; i < datesets.getDatesets().size(); i++) {
                tmp = "";
                for (int j = 0; j < datesets.getHeaders().size() - 1; j++) {
                    tmp += datesets.getDatesets().get(i).get(datesets.getHeaders().get(j))+";";
                }
                tmp += datesets.getDatesets().get(i).get(datesets.getHeaders().get(datesets.getHeaders().size()-1))+"\n";
                bufferedWriter.write(tmp);
            }
        } finally {
            if (fileWriter != null) {
                bufferedWriter.close();
            }
        }
    }
}
