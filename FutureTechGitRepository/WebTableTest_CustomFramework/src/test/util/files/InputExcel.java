package test.util.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputExcel {
	
//	private FileInputStream input;
	private Workbook inputWorkBook;
	private Sheet inputSheet;
	private Row inputRow;
	private Cell inputCell;
		
	public void openInputFile(String inputFileName, String inputSheetName) throws FileNotFoundException, IOException {
		FileInputStream input = new FileInputStream(inputFileName);
		inputWorkBook = new XSSFWorkbook(input);
		inputSheet = inputWorkBook.getSheet(inputSheetName);
	}
	
	public boolean doesFileExist(String location) {
		File file = new File(location);
		
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getTotalRowCount() {
		return inputSheet.getLastRowNum();
		/*int lastRowIndex = -1;
		if( inputSheet.getPhysicalNumberOfRows() > 0 )
		{
		    // getLastRowNum() actually returns an index, not a row number
		    lastRowIndex = inputSheet.getLastRowNum();

		    // now, start at end of spreadsheet and work our way backwards until we find a row having data
		    for( ; lastRowIndex >= 0; lastRowIndex-- ){
		        inputRow = inputSheet.getRow( lastRowIndex );
		        if( inputRow != null ){		    		       
		            break;
		        }
		    }		    
		}
		return lastRowIndex;*/		
	}
	
	public int getTotalColumnCount(int rowNumber) {
		return inputSheet.getRow(rowNumber).getLastCellNum();
	}
	
	public void readRow(int rowNumber) {
		inputRow = inputSheet.getRow(rowNumber);
	}
	
	public String readCell(int cellNumber) {
		inputCell = inputRow.getCell(cellNumber);
		return inputCell.getStringCellValue();
	}
	
	public void closeFile() throws IOException {
		inputWorkBook.close();
	}
}
