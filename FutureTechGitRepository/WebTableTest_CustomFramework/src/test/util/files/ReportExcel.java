package test.util.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportExcel {
	
	private FileOutputStream output;
	private Workbook outputWorkBook;
	private Sheet outputSheet;
	private Row outputRow;
	private Cell outputCell;
	private CellStyle style;
	private Font font;

	private Date date;
		
	private int countCells;	
	private String customCellValue;
	
	public String writeDate() {
		date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
		return dateFormat.format(date);
	}
	
	public void writeToFile(String outputFileName) throws FileNotFoundException, IOException {
		output = new FileOutputStream(outputFileName);
		outputWorkBook.write(output);
		System.out.println("Report file successfully generated");
	}
	
	public void createFile(String outputSheetName) throws FileNotFoundException, IOException {
		outputWorkBook = new XSSFWorkbook();
		outputSheet = outputWorkBook.createSheet(outputSheetName);
	}
	
	public void createRows(int rowNumber, String rowHeight) {
		outputRow = outputSheet.createRow(rowNumber);
		if (rowHeight.equals("heading")) {
			outputRow.setHeightInPoints(23);
		} else if (rowHeight.equals("default")) {
			outputRow.setHeightInPoints(15);
		} else {
			rowHeight = null;
		}		
	}
	
	public void createCells(int colNumber) {
		outputCell = outputRow.createCell(colNumber);
		outputCell.setCellValue(this.customCellValue);		
	}
	
	public void createCells(int colNumber, String cellValue) {
		outputCell = outputRow.createCell(colNumber);
		outputCell.setCellValue(cellValue);
	}
	
	public void createCells(int colNumber, int cellValue) {
		outputCell = outputRow.createCell(colNumber);
		outputCell.setCellValue(cellValue);
	}
	
	public void writeCellValues(String cellValue) {
		outputCell = outputRow.createCell(this.countCells);
		outputCell.setCellValue(cellValue);
	}
	
	public void setCustomCellValue(String cellValue) {
		this.customCellValue = cellValue;
	}
	
	public String getCustomCellValue() {
		return this.customCellValue;
	}
	
	public void setCellWidth(int colNumber) {
		outputSheet.autoSizeColumn(colNumber);
	}
	
	public void setCellCountToInitial() {
		this.countCells = 0;
	}	
		
	public void goToNextCell(int totalCells) {
		if (this.countCells<totalCells) {
			this.countCells++;
		} else {
			this.countCells=0;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void formatCells(boolean isWrapText, String horAlignment) {
		style = outputWorkBook.createCellStyle();
	    
		style.setWrapText(isWrapText);
		
		String horizontal = horAlignment;
		
		switch (horizontal) {
		
		case "center":
			style.setAlignment(CellStyle.ALIGN_CENTER);
			break;
			
		case "left":
			style.setAlignment(CellStyle.ALIGN_LEFT);			
			break;
			
		case "right":
			style.setAlignment(CellStyle.ALIGN_RIGHT);			
			break;
		}		
	}
	
	public void mergeCells(int rowFirst, int rowLast, int cellFirst, int cellLast) {
		outputSheet.addMergedRegion(new CellRangeAddress(
				rowFirst,
				rowLast,
				cellFirst,
				cellLast
	    ));
	}
	
	@SuppressWarnings("deprecation")
	public void formatColor(String cellColor) {
		String color = cellColor;
		
		switch (color) {
		
		case "red":
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "blue":
			style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "light blue":
			style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "green":
			style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "gold":
			style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "orange":
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "yellow":
			style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "coral":
			style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "lavender":
			style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "grey25":
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "grey40":
			style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		case "grey50":
			style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			break;
		}
	}
	
	public void formatText(String fontName, int fontSize, String fontColor, boolean isBold, boolean isItalic, boolean isStrikeThrough) {
		String color = fontColor;
		
		font = outputWorkBook.createFont();
	    font.setFontHeightInPoints((short)fontSize);
	    font.setFontName(fontName);
	    font.setBold(isBold);
	    font.setItalic(isItalic);
	    font.setStrikeout(isStrikeThrough);
	    
	    switch (color) {
	    case "black": font.setColor(IndexedColors.BLACK.getIndex());
	    break;
	    case "blue": font.setColor(IndexedColors.DARK_BLUE.getIndex());
	    break;
	    case "red": font.setColor(IndexedColors.RED.getIndex());
	    break;
	    }
	    	    
	    style.setFont(font);
	}
	
	@SuppressWarnings("deprecation")
	public void formatBorder(String borderWeight, boolean isTopBorder, boolean isBottomBorder, boolean isRightBorder, boolean isLeftBorder) {
		
		String weight = borderWeight;		
		
		switch (weight) {
		case "thin":
		if (isTopBorder) {
			style.setBorderTop(CellStyle.BORDER_THIN);
		    style.setTopBorderColor(IndexedColors.BLACK.getIndex());			
		}
		
		if (isBottomBorder) {
			style.setBorderBottom(CellStyle.BORDER_THIN);
		    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		}
		
		if (isRightBorder) {
			style.setBorderRight(CellStyle.BORDER_THIN);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		}
		
		if (isLeftBorder) {
			style.setBorderLeft(CellStyle.BORDER_THIN);
		    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		}		
		break;
		
		case "thick":
		if (isTopBorder) {
			style.setBorderTop(CellStyle.BORDER_THICK);
		    style.setTopBorderColor(IndexedColors.BLACK.getIndex());			
		}
		
		if (isBottomBorder) {
			style.setBorderBottom(CellStyle.BORDER_THICK);
		    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		}
		
		if (isRightBorder) {
			style.setBorderRight(CellStyle.BORDER_THICK);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		}
		
		if (isLeftBorder) {
			style.setBorderLeft(CellStyle.BORDER_THICK);
		    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		}
		break;
		}				
	}
	
	public void setStyle() {
		outputCell.setCellStyle(style);
	}
	
	public void closeFile() throws IOException {
		outputWorkBook.close();
	}

}
