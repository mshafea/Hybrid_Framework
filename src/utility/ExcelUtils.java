package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;

import setup.TestBase;

public class ExcelUtils extends TestBase {

	private static XSSFCell cell;

	@DataProvider(name = "NewUsers")
	public static Object[][] getNewUsersData() {
		Object[][] testObjArray = ExcelUtils.getTableArray(Constant.File_TestData, Constant.Sheet_TestData);

		return testObjArray;
	}

	@DataProvider(name = "loginUsers")
	public static Object[][] getLoginUsersData() {
		Object[][] testObjArray = ExcelUtils.getTableArray(Constant.File_TestData, Constant.Sheet_Login_TestData);

		return testObjArray;
	}

	
	@SuppressWarnings("deprecation")
	public static String[][] getTableArray(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wBook = new XSSFWorkbook(fs);
			XSSFSheet eSheet = wBook.getSheet(sheetName);

			int totalNoOfCols = eSheet.getRow(0).getLastCellNum();
			int totalNoOfRows = eSheet.getLastRowNum();

			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];

			// Loop through All rows in the sheet
			// Start at row 1 as row 0 is our header row

			for (int i = 1; i <= totalNoOfRows; i++) {
				XSSFRow row = eSheet.getRow(i);
				for (int j = 0; j < totalNoOfCols; j++) {
					cell = row.getCell(j);

					Object result;

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
							result = dateFormat.format(cell.getDateCellValue());
						} else {
							result = cell.getNumericCellValue();
						}
						break;

					case Cell.CELL_TYPE_STRING:
						result = cell.getStringCellValue();
						break;

					case Cell.CELL_TYPE_BOOLEAN:
						result = cell.getBooleanCellValue();
						break;

					case Cell.CELL_TYPE_FORMULA:
						result = cell.getCellFormula();
						break;

					default:
						throw new RuntimeException("Unknown Cell Type");
					}

					// String value = cell.getStringCellValue();
					arrayExcelData[i - 1][j] = result.toString();
				}
			}
			wBook.close();
			fs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;

	}

}