//************************************************************************************
//                             ExcelFileClass.java
//************************************************************************************

package com.haqasad.excelinput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileClass {
	FileOutputStream writeFile;
	Workbook workBook;
	Sheet sheet;
	Row row;
	Cell cell;
	
	public void writeToFile(String studentName) {
		
		workBook = new XSSFWorkbook();
		sheet = workBook.createSheet("st_name");
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(studentName);
		try {
			writeFile = new FileOutputStream("NAME.xlsx");
			workBook.write(writeFile);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String retrieveFromFile() {
		
		try {
			FileInputStream readFile = new FileInputStream("NAME.xlsx");
			workBook = new XSSFWorkbook(readFile);
			sheet = workBook.getSheet("st_name");
			row = sheet.getRow(1);
			cell = row.getCell(0);
			workBook.close();
			return cell.getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
