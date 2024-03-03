package com.prach_project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datadriven {

//	@DataProvider(name = "data from ramchi")
//	public Object[][] takeMyDataAndUse(String username, String password) {
//		Object[][] ramchi = new Object[3][2];
//
//		ramchi[0][0] = "user1";
//		ramchi[0][1] = "user1pw";
//
//		ramchi[1][0] = "user2";
//		ramchi[1][1] = "user2pw";
//
//		ramchi[2][0] = "user2";
//		ramchi[2][1] = "user2pw";
//
//		return ramchi;
//	}
	
	
//	way==2   //need to modify some
			
	@DataProvider(name = "data from ramchi2")
	public Object[][] takeMyDataAndUse(String username, String password) throws IOException {
		
		File file = new File("C:\\Users\\kahme\\OneDrive\\Desktop\\emptyexcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xbook = new XSSFWorkbook(fis);
		XSSFSheet xsheet = xbook.getSheet("sheet1");
		int totalrow = xsheet.getLastRowNum() + 1;
		int totalcolumn = xsheet.getRow(0).getLastCellNum();
		
		
		Object[][] ramchi = new Object[totalrow][totalcolumn];
		for (int currentrow = 0; currentrow < totalrow; currentrow++) {
			for (int currentcolumn = 0; currentcolumn < totalcolumn; currentcolumn++) {

				System.out.print(xsheet.getRow(currentrow).getCell(currentcolumn).toString()); // removed ln to print
																								// sidebyside
				System.out.print("\t"); // it will tell to give the secondvalue space and removing ln will give values
										// side by side

			}
			System.out.println();
		}

		
		return ramchi;
	}

	
	
//	way==3
	
//	public static void main(String[] args) throws IOException {
//
//		File file = new File("C:\\Users\\kahme\\OneDrive\\Desktop\\emptyexcel.xlsx");
//		FileInputStream fis = new FileInputStream(file);
//		XSSFWorkbook xbook = new XSSFWorkbook(fis);
//		XSSFSheet xsheet = xbook.getSheet("sheet1");
//		int totalrow = xsheet.getLastRowNum() + 1;
//		int totalcolumn = xsheet.getRow(0).getLastCellNum();
//
//		// for knowledge
//		System.out.println(totalrow); // 3
//		System.out.println(totalcolumn); // 2
//
//		for (int currentrow = 0; currentrow < totalrow; currentrow++) {
//			for (int currentcolumn = 0; currentcolumn < totalcolumn; currentcolumn++) {
//
//				System.out.print(xsheet.getRow(currentrow).getCell(currentcolumn).toString()); // removed ln to print
//																								// sidebyside
//				System.out.print("\t"); // it will tell to give the secondvalue space and removing ln will give values
//										// side by side
//
//			}
//			System.out.println();
//		}

			

}
