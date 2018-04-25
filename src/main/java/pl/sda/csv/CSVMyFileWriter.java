package pl.sda.csv;

import pl.sda.MyFileWriter;
import pl.sda.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVMyFileWriter implements MyFileWriter {

    public void writeData(String filePath, MyGeneral datesets) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        boolean flag = true;
        try {
            fileWriter = new FileWriter(filePath);

            String tmp = "";
            for (int i = 0; i < datesets.getHeaders().size() - 1; i++) {
                tmp += datesets.getHeaders().get(i) + ";";
            }
            tmp += datesets.getHeaders().get(datesets.getHeaders().size() - 1)+"\n";
            fileWriter.write(tmp);
            for (int i = 0; i < datesets.getDatesets().size(); i++) {
                tmp = "";
                for (int j = 0; j < datesets.getHeaders().size() - 1; j++) {
                    tmp += datesets.getDatesets().get(i).get(datesets.getHeaders().get(j))+";";
                }
                tmp += datesets.getDatesets().get(i).get(datesets.getHeaders().get(datesets.getHeaders().size()-1))+"\n";
                fileWriter.write(tmp);
            }


        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }


    }


}
