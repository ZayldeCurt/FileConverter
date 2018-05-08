package pl.sda.excel;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.MyFileWriter;
import pl.sda.MyGeneral;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelMyFileWriter implements MyFileWriter {

    @Override
    public void writeData(String filePath, MyGeneral datesets) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Contacts");
        Row headerRow = sheet.createRow(0);


        for (int i = 0; i < datesets.getHeaders().size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(datesets.getHeaders().get(i));
        }

        int rowNum = 1;

        for (int i = 0; i < datesets.getDatesets().size(); i++) {
            Row row=sheet.createRow(rowNum++);
            for (int j = 0; j < datesets.getHeaders().size(); j++) {
                row.createCell(j).setCellValue(datesets.getDatesets().get(i).get(datesets.getHeaders().get(j)));
            }
        }
        for (int i = 0; i < datesets.getHeaders().size(); i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = null;

        fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();

    }
}
