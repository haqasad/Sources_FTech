package test.testcase.one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestOneProperty {
	
	Properties property;
	
	private int totalCells;
	private String inputFileName;
	private String inputSheetName;
	
	public void initiateProperty() throws FileNotFoundException, IOException {
		property = new Properties();
		property.load(new FileInputStream("C:\\Users\\Mushfiq\\workspace\\WebTableTest_CustomFramework\\src\\test\\testcase\\one\\testone.properties"));
	}
	
	public String getResultFileName() {
		return property.getProperty("outputFileName");
	}

	public String getResultSheetName() {
		return property.getProperty("outputSheetName");
	}
	
	public int getTotalColumnCount() {
		return Integer.parseInt(property.getProperty("colCount"));
	}
	
	public String[] getColumnNames() {
		String[] columnHeading = new String[this.totalCells];
		columnHeading = property.getProperty("colNames").split(";");
		return columnHeading;
	}
	
	public void setInputFileName() {
		this.inputFileName = property.getProperty("inputFileName");
	}
	
	public String getInputFileName() {
		return this.inputFileName;
	}
	
	public void setInputSheetName() {
		this.inputSheetName = property.getProperty("inputSheetName");
	}
	
	public String getInputSheetName() {
		return inputSheetName;
	}
}
