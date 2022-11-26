package util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class ExcelUtils {
    static XSSFWorkbook workbook = new XSSFWorkbook();
    public static XSSFSheet createSheet(String sheetName){

        return workbook.createSheet(sheetName);
    }

    public static void write(FileOutputStream out) throws IOException {
         workbook.write(out);
    }

    public static void setRow(Row row, String ...rowVals){
        IntStream.range(0,rowVals.length)
                .forEach(index->row.createCell(index).setCellValue(rowVals[index]));
    }

}
