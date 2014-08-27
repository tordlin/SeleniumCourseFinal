package lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/*
 *  Class that provides methods for extracting data from Excel tables.
 */
public class ExcelDriver {

	/*
	 * Static method that retrieves testing data from multiple data Excel table and returns it
	 * as Map collection of key-value pairs. Column Number indicates number of data set. Note, please, that returned values
	 * are String. We should take care of value's type by himself when will use
	 * data values in the test.
	 */
	public static Map getMultipleData(String dataFileName, String sheetName, int columnNumber) throws IOException {
		Map<String, String> testData = new HashMap<String, String>();
		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName);
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
		// Get Excel sheet from WorkBook
		HSSFSheet sheet = wb.getSheet(sheetName);

		// Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 2;
		// Look over the table and put key-value pairs into the Map collection
		for (int k = 2; k < (dataSize + 2); k++) {
			HSSFCell keyCell = sheet.getRow(k).getCell(0);
			HSSFCell valueCell = sheet.getRow(k).getCell(columnNumber);
			valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
		}

		input.close();
		return testData;
	}


    /*
      * Static method that retrieves testing data from Excel table and returns it
      * as Map collection of key-value pairs. Note, please, that returned values
      * are String. We should take care of value's type by himself when will use
      * data values in the test.
      */
    public static Map getData(String dataFileName, String sheetName) throws IOException {
        Map<String, String> testData = new HashMap<String, String>();
        // Create stream for reading from file
        InputStream input = new FileInputStream(dataFileName);
        // Get Excel WorkBook from input stream
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        // Get Excel sheet from WorkBook
        HSSFSheet sheet = wb.getSheet(sheetName);

        // Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 1;
        // Look over the table and put key-value pairs into the Map collection
        for (int k = 1; k < (dataSize + 1); k++) {
            HSSFCell keyCell = sheet.getRow(k).getCell(0);
            HSSFCell valueCell = sheet.getRow(k).getCell(1);
            valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }

	

	/*
	 * Static method that retrieves testing data from Excel table and returns it
	 * as Map collection of key-value pairs. Note, please, that returned values
	 * are String. We should take care of value's type by himself when will use
	 * data values in the test.
	 */
	public static Map getDataRow(String dataFileName, String sheetName) throws IOException {
		Map<String, String> testData = new HashMap<String, String>();
		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName);
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
		// Get Excel sheet from WorkBook
		HSSFSheet sheet = wb.getSheet(sheetName);

		// Get number of data values
		int dataSize = sheet.getRow(2).getPhysicalNumberOfCells();
		// Look over the table and put key-value pairs into the Map collection
		for (int k = 0; k < (dataSize); k++) {
			HSSFCell keyCell = sheet.getRow(2).getCell(k);
			HSSFCell valueCell = sheet.getRow(3).getCell(k);
			valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
		}

		input.close();
		return testData;
	}

	/*
	 * Retrieves multiple testing data from Excel table and returns it as Map
	 * collection of key-value pairs. Note, please, that returned values are
	 * ArrayList of Strings. Each ArrayList may contain different number of
	 * values.
	 */
	/*public static Map<String, ArrayList<String>> getMultipleDataRow(String dataFileName, String sheetName)
			throws IOException {
		Map<String, ArrayList<String>> dataSet = new HashMap<String, ArrayList<String>>();

		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName);
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
		// Get Excel sheet from WorkBook
		HSSFSheet sheet = wb.getSheet(sheetName);

		// Get number of parameters
		int dataSize = sheet.getRow(2).getPhysicalNumberOfCells();

		// Count max number of data rows
		int rows = sheet.getPhysicalNumberOfRows();

		// Look over the data table column by column
		for (int j = 0; j < (dataSize); j++) {

			HSSFCell keyCell = sheet.getRow(2).getCell(j);
			ArrayList<String> valueSet = new ArrayList<String>();

			// Put column's values into the ArrayList
			for (int k = 3; k < (rows); k++) {
				HSSFRow r = sheet.getRow(k);

				try {
					HSSFCell valueCell = sheet.getRow(k).getCell(j);
					valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
					valueSet.add(valueCell.getStringCellValue());
				} catch (NullPointerException e) {
				}
			}

			// Put column's header and Set of values into the Map collection of
			// key-value pair
			dataSet.put(keyCell.getStringCellValue(), valueSet);
		}

		input.close();
		return dataSet;
	}*/

	
}
