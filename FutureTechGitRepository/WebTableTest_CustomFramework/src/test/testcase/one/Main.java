package test.testcase.one;

import java.io.IOException;

import test.util.files.InputExcel;
import test.util.files.ReportExcel;
import test.util.htmlelements.Heading;

public class Main {

	public static void main(String[] args) {
		TestOneProperty testProperty = new TestOneProperty();
		ReportExcel report = new ReportExcel();
		InputExcel input = new InputExcel();
		Heading headingTitle = new Heading();
		Validation validation = new Validation();
		
		String actual = null;
		String expected = null;
						
		try {
			testProperty.initiateProperty();
			testProperty.setInputFileName();
			testProperty.setInputSheetName();
			report.createFile(testProperty.getResultSheetName());
			input.openInputFile(testProperty.getInputFileName(), testProperty.getInputSheetName());
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		String[] columnName = new String[testProperty.getTotalColumnCount()];
		columnName = testProperty.getColumnNames();		
				
		headingTitle.openFirefox();
		
		for(int i=0; i<(input.getTotalRowCount()+1); i++) {
			if (i==0 || i==1) {
				report.createRows(i, "heading");
			} else {
				report.createRows(i, "default");
			}

			for(int j=0; j<testProperty.getTotalColumnCount(); j++) {

				if (i==0) {
					if (j==0) {
						report.setCustomCellValue("Report  TC1: Verify the heading-Payment more than 100 days Outstanding");
						report.createCells(j);
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 14, "black", true, false, false);
						report.formatColor("orange");
						report.mergeCells(i, i, j, (testProperty.getTotalColumnCount() - 1));
						report.setStyle();
					} else if (j==(testProperty.getTotalColumnCount()-1)) {
						report.createCells(j, "");
						report.createCells((j+3), "Date: " + report.writeDate());
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 14, "black", true, false, false);
						report.formatColor("gold");
						report.formatBorder("thick", true, true, true, true);
						report.setStyle();
						report.setCellWidth(j+3);										
					} else {
						report.createCells(j, "");
					}					
				} else if (i==1) {
					report.createCells(j, "");												

				} else if(i==2) {					
						report.createCells(j, columnName[j]);
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 14, "black", true, false, false);
						report.formatColor("gold");
						report.formatBorder("thick", true, true, false, true);
						report.setStyle();
						report.setCellWidth(j);					
				} else {
					int cellOptions = j;
					switch (cellOptions) {
					case 0: 
						report.createCells(j, i-2);
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatBorder("thin", false, true, false, true);
						report.formatColor("yellow");
						report.setStyle();
						break;
					case 1: 
						input.readRow(i);						
						report.createCells(j, input.readCell(j));
						report.formatBorder("thin", false, false, false, true);
						report.formatCells(true, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();						
						headingTitle.goToPage(input.readCell(j));
						break;
					case 2:
						input.readRow(i);				
						expected = input.readCell(j);
						report.createCells(j, input.readCell(j));
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 3: 
						actual = headingTitle.getTag("h1");						
						report.createCells(j, headingTitle.getTag("h1"));
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 4: 
						if (validation.isValid(expected, actual)) {						
							report.createCells(j, "Pass");
							report.formatCells(false, "center");
							report.formatText("Times New Roman", 10, "black", false, false, false);
							report.formatColor("yellow");
							report.formatBorder("thin", false, true, false, true);
							report.setStyle();
						} else {							
							report.createCells(j, "Fail");
							report.formatCells(false, "center");
							report.formatText("Times New Roman", 10, "orange", false, false, false);
							report.formatColor("red");
							report.formatBorder("thin", false, true, false, true);
							report.setStyle();
						}
						break;
					case 5: 
						if (validation.isValid(expected, actual)) {						
							report.createCells(j, "Test Passed");
							report.formatCells(false, "center");
							report.formatText("Times New Roman", 10, "black", false, false, false);
							report.formatColor("yellow");
							report.formatBorder("thin", false, true, false, true);
							report.setStyle();
						} else {							
							report.createCells(j, "Test Failed");
							report.formatCells(false, "center");
							report.formatText("Times New Roman", 10, "orange", false, false, false);
							report.formatColor("yellow");
							report.formatBorder("thin", false, true, false, true);
							report.setStyle();
						}
						break;
					}
				}		
			}
		}

		headingTitle.closeBrowser();
		try {
			report.writeToFile(testProperty.getResultFileName());
			report.closeFile();
			input.closeFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}


