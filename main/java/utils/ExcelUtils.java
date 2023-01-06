package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelUtils {
	Workbook book;
	public Sheet sheet;

	public ExcelUtils(String filePath, String sheetName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			if (filePath.endsWith(".xls")) {
				book = new HSSFWorkbook(fileInputStream);
			} else if (filePath.endsWith(".xlsx")) {
				book = new XSSFWorkbook(fileInputStream);
			}
			sheet = book.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
			//JavaLog.log("File Not Found at : " + filePath);
		}
	}

	public String[][] dataTable() {
		String[][] arrays = null;
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		int yRows = 0;

		for (int i = 1; i <= rows; i++) {
			try {
				if (sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Y")) {
					yRows++;
				}
			} catch (NullPointerException e) {

			}
		}

		//System.out.println("Rows with Y : " + yRows);
		
		arrays = new String[yRows][cols - 3]; // Array Length will be as it is, not start from zero. -3 for columns that we are not going to use

		int y = 0;
		for (int i = 1; i <= rows; i++) {
			Row row = sheet.getRow(i);
			try {
				if (row.getCell(2).getStringCellValue().equalsIgnoreCase("y") && y < yRows) {
					int cellNo = 0;
					for (int j = 3; j < row.getLastCellNum(); j++) {
						String cellValue = "";
						try {
							org.apache.poi.ss.usermodel.Cell cell = row.getCell(j);
							if (cell.getCellType() == CellType.STRING) {
								cellValue = cell.getStringCellValue();
							} else if (cell.getCellType() == CellType.BOOLEAN) {
								cellValue = String.valueOf(cell.getBooleanCellValue());
							}
							//System.out.println(cellValue);
						} catch (NullPointerException e) {
							//System.out.println("Null at " + i + " : " + j);
						}
						//System.out.println(y +" <<>>"+ cellNo);
						arrays[y][cellNo] = cellValue;	
						cellNo++;
					}
					//System.out.println("Last cell : " + cellNo);
					cellNo = 0;
					y++;
					//System.out.println(y);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		return arrays;
	}
}