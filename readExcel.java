//Imports
//Make sure you have the POI Jar library in your build path
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class readExcel

{

	public static void readFile(String path) throws IOException {
		// Path to the excel file
		File datafile = new File(path);
		// A Buffered File Input Stream to read the data
		InputStream fis = new BufferedInputStream(new FileInputStream(datafile));
		// We create a workbook which represents the excel file
		HSSFWorkbook book = new HSSFWorkbook(fis);
		// Next a sheet which represents the sheet within that excel file
		HSSFSheet sheet = book.getSheet("Details");
		// No of rows in the sheet
		int rowNum = sheet.getLastRowNum() + 1;
		// No of columns in the sheet
		int colNum = sheet.getRow(0).getLastCellNum();
		// A Two dimensional array of Strings which represents the data in the
		// sheet
		String[][] data = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			// Get the row
			HSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colNum; j++) {
				// Get the columns or cells for the first row and keep looping
				// for the other rows
				HSSFCell cell = row.getCell(j);
				// Make a call to the method cellToString which actually
				// converts the cell contents to String
				String value = cellToString(cell);
				data[i][j] = value;
				// Here is where you write the logic to handle the data.I am
				// just printing out the contents here.
				System.out.println("The value is " + value);
			}
		}
	}

	private static String cellToString(HSSFCell cell) {
		
		Object result;

		switch (cell.getCellType()) {
			
		case Cell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();
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

		return result.toString();
	}

}
