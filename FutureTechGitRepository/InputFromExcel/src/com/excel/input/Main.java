package com.excel.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
	/*	// TODO Auto-generated method stub
		String excelFilePath = "Books.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
         
        workbook.close();
        inputStream.close();*/
	
	try {
		FileInputStream readFile = new FileInputStream("INPUT.xlsx");
		Workbook workBook = new XSSFWorkbook(readFile);
		Sheet sheet = workBook.getSheet("input_one");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		System.out.println(sheet.getLastRowNum());
		workBook.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		//return null;
	} catch (IOException e) {
		e.printStackTrace();
		//return null;
	}
    }
}


