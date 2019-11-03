package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) {
		getTestDataForClass();
	}

	public static Map<String, List<ArrayList<String>>> getTestDataForClass() {
		Object[][] sheetData = null;
		File file = null;
		XSSFWorkbook book = null;
		XSSFSheet sheet = null;
		int rowCount = 0;
		int cellCount = 0;
		XSSFRow row = null;
		Cell cell = null;
		int rowIndex = 0, colIndex = 0;
		Map<String, List<ArrayList<String>>> dataMap = new HashMap<String, List<ArrayList<String>>>();
		List<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();

		String excelFilePath = System.getProperty("user.dir")
				+ "/TestData.xlsx";
		System.out.println("Reading data from the file: " + excelFilePath);

		int i, numberOfSheets = 0;
		i = 2;

		try {
			file = new File(excelFilePath);
			InputStream inputSteam = new FileInputStream(file);
			book = new XSSFWorkbook(inputSteam);
			DataFormatter cellFormat = new DataFormatter();

			numberOfSheets = book.getNumberOfSheets();

			while (i < numberOfSheets) {
				// sheet = book.getSheet(className);
				sheet = book.getSheetAt(i);
				rowIndex = colIndex = 0;
				System.out.println(sheet.getSheetName());

				try {
					rowCount = sheet.getLastRowNum();
				} catch (Exception e) {
					rowCount = 0;
				}
				try {
					cellCount = sheet.getRow(0).getLastCellNum();
				} catch (Exception e) {
					cellCount = 0;
				}

				if (rowCount == 0 && cellCount == 0) {
					return dataMap;
				}

				String cellValue = "";
				String key = "";
				boolean isCommentsColumnPresent = false;
				ArrayList<String> list = new ArrayList<String>();

				Iterator<Row> rowIterator = sheet.rowIterator();

				if (sheet.getRow(0)
						.getCell(sheet.getRow(0).getLastCellNum() - 1)
						.toString().equalsIgnoreCase("Comments"))
					isCommentsColumnPresent = true;

				if (isCommentsColumnPresent)
					sheetData = new Object[rowCount][cellCount - 1];
				else
					sheetData = new Object[rowCount][cellCount];

				rowIterator.next(); // Skip Headers row
				Iterator<Cell> cellIterator = null;

				while (rowIterator.hasNext()) {
					row = (XSSFRow) rowIterator.next();
					cellIterator = row.cellIterator();
					colIndex = 0;

					while (cellIterator.hasNext()) {
						cell = (Cell) cellIterator.next();

						if (isCommentsColumnPresent && !cellIterator.hasNext())
							break;

						cellValue = cellFormat.formatCellValue(cell);

						if (colIndex == 0)
							key = cellValue;
						else
							list.add(cellValue);

						if (key.length() > 0)
							sheetData[rowIndex][colIndex] = cellValue;

						// }
						colIndex++;
					}

					if (dataMap.containsKey(key)) {
						finalList = dataMap.get(key);
					}

					if (list.size() > 0) {
						finalList.add(new ArrayList<String>(list));
						dataMap.put(key, new ArrayList<ArrayList<String>>(
								finalList));
						finalList.clear();
					}
					list.clear();
					key = "";

					rowIndex++;
				}

				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception." + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out
					.println("Exception while reading data from the Excel File: ");
			e.printStackTrace();
		} finally {
			try {
				if(book != null) book.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Print class data
		System.out.println("Number of rows in the class data is: "
				+ dataMap.size());
		System.out
				.println("******************Print Class Data Start*************");
		for (Entry<String, List<ArrayList<String>>> e : dataMap.entrySet()) {
			System.out.println("Key is: " + e.getKey());
			for (ArrayList<String> l : e.getValue()) {
				System.out.println("Input length is: " + l.size());
				for (String s : l) {
					System.out.print(s + "\t");
				}
				System.out.println("");
			}
		}
		System.out
				.println("******************Print Class Data END*************");

		return dataMap;
	}

}
