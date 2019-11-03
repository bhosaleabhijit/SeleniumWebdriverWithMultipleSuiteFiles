package tests;

import org.testng.annotations.Test;

import excelUtils.ExcelReader;

public class ExcelFileTest {

	
	public static void readFileData()
	{
		excelUtils.ExcelReader.getTestDataForClass();
	}
	
	public static void main(String[] args) {
		readFileData();
	}
}
