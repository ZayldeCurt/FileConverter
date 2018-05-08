package pl.sda.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.sda.MyFileWriter;
import pl.sda.MyGeneral;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PDFMyFileWriter implements MyFileWriter {
    @Override
    public void writeData(String filePath, MyGeneral datesets) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("iTextHelloWorld.pdf"));
        document.open();

        int numColumns = datesets.getHeaders().size();
        PdfPTable table = new PdfPTable(numColumns);
        addTableHeader(table,datesets.getHeaders());
        addRows(table,datesets.getDatesets(),datesets.getHeaders());

        document.add(table);
        document.close();
    }


    private void addRows(PdfPTable table, List<Map<String, String>> datesets, List<String> headers) {
        for (int i = 0; i < datesets.size(); i++) {
            for (int j = 0; j < headers.size(); j++) {
                table.addCell(datesets.get(i).get(headers.get(j)));
            }
        }
    }

    private void addTableHeader(PdfPTable table, List<String> headers) {
        headers.stream().forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }
}
