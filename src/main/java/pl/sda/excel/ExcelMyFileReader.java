package pl.sda.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.MyFileReader;
import pl.sda.MyGeneral;
import pl.sda.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelMyFileReader implements MyFileReader{
    public MyGeneral readData(String filePath) throws IOException {
        MyGeneral dataSets = new MyGeneral();

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        List<String> headers=new ArrayList<>();
        Row headerRow = rowIterator.next();
        Iterator<Cell> headerRowIterator = headerRow.iterator();
        while(headerRowIterator.hasNext()){
            Cell cell = headerRowIterator.next();
            headers.add(cell.getStringCellValue());
        }
        dataSets.setHeaders(headers);

        while(rowIterator.hasNext()){
            Map<String,String> map = new HashMap<>();
            Row row = rowIterator.next();
            for (int j = 0; j < headers.size(); j++) {
                Cell cell = row.getCell(j);
                String value;
                if(cell!=null){
                    CellType cellType = cell.getCellTypeEnum();
                    if(CellType.NUMERIC.equals(cellType)){
                        Double valueD=cell.getNumericCellValue();
                        value= String.valueOf(valueD.intValue());
                    }
                    else{
                        value=cell.getStringCellValue();
                    }
                    map.put(headers.get(j),value);
                }else{
                    map.put(headers.get(j),"");
                }
            }
            dataSets.add(map);
        }
        return dataSets;
    }
    //dziala ale nie jest odporne na puste komorki
//    public MyGeneral readData(String filePath) throws IOException {
//        MyGeneral dataSets = new MyGeneral();
//
//        FileInputStream inputStream = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(inputStream);
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        Iterator<Row> rowIterator = sheet.iterator();
//
//        List<String> headers=new ArrayList<>();
//        Row headerRow = rowIterator.next();
//        Iterator<Cell> headerRowIterator = headerRow.iterator();
//        while(headerRowIterator.hasNext()){
//            Cell cell = headerRowIterator.next();
//            headers.add(cell.getStringCellValue());
//        }
//        dataSets.setHeaders(headers);
//
//        while(rowIterator.hasNext()){
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.iterator();
//            Map<String,String> map = new HashMap<>();
//            for (int j = 0; j < headers.size(); j++) {
//                Cell cell = cellIterator.next();
//                CellType cellType = cell.getCellTypeEnum();
//                String value;
//                if(CellType.NUMERIC.equals(cellType)){
//                    Double valueD=cell.getNumericCellValue();
//                    value= String.valueOf(valueD.intValue());
//                }
//                else{
//                    value=cell.getStringCellValue();
//                }
//                map.put(headers.get(j),value);
//            }
//
//            dataSets.add(map);
//        }
//
//        return dataSets;
//    }
}
