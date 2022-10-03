package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ExcelReader(String filePath, String sheetName) throws IOException {
        wb = new XSSFWorkbook(filePath);
        sheet = wb.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellValue(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }
}
