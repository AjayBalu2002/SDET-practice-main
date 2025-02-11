package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<String> readExcelData(String filePath, String sheetName) {
        List<String> countryNames = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {
             
            Sheet sheet = workbook.getSheet(sheetName);

            // Debugging: Check if sheet exists
            if (sheet == null) {
                System.err.println("Error: Sheet '" + sheetName + "' not found in " + filePath);
                return countryNames; // Return empty list to avoid NullPointerException
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    countryNames.add(cell.getStringCellValue().trim());
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
        return countryNames;
    }
}
