package test.util.files;

import java.io.FileNotFoundException;
import java.io.IOException;

import test.testcase.one.TestOneProperty;

public class Main {

	public static void main(String[] args) {

		TestOneProperty testProperty = new TestOneProperty();
		//ReportExcel report = new ReportExcel();
		InputExcel input = new InputExcel();
		
		try {
			testProperty.initiateProperty();
			testProperty.setInputFileName();
			testProperty.setInputSheetName();
			//report.createFile(testProperty.getResultSheetName());
//			input.openInputFile("INPUT.xlsx", "input_one");
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		testProperty.setInputFileName();
		testProperty.setInputSheetName();
		
		/*String fileName = testProperty.getInputFileName();
		String sheetName = testProperty.getInputSheetName();*/
		try {
			input.openInputFile(testProperty.getInputFileName(), testProperty.getInputSheetName()); //"INPUT.xlsx", "input_one"
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(testProperty.getInputFileName());
		System.out.println(testProperty.getInputSheetName());
		
		/*String[] columnName = new String[testProperty.getTotalColumnCount()];
		columnName = testProperty.getColumnNames();*/		

		//System.out.println(input.doesFileExist(testProperty.getInputFileName()));
		System.out.println(input.getTotalRowCount());
		System.out.println(input.getTotalColumnCount(2));
		System.out.println(input.getTotalColumnCount(0));
		input.readRow(1);
		System.out.println(input.readCell(1));
		
/*		for(int i=0; i<20; i++) {
			if (i==0 || i==1) {
				report.createRows(i, "heading");
			} else {
				report.createRows(i, "default");
			}

			for(int j=0; j<testProperty.getTotalColumnCount(); j++) {

				if (i==0) {
					if (j==0) {
						report.setCustomCellValue("Report" + report.writeDate() + "#TC1:Verify the heading-Payment more than 100 days Outstanding");
						report.createCells(j);
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 14, "black", true, false, false);
						report.formatColor("orange");
						report.mergeCells(i, i, j, (testProperty.getTotalColumnCount() - 1));
						report.setStyle();
					} else {
						report.createCells(j, "");
					}					
				} else if(i==1) {
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
						report.createCells(j, i-1);
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatBorder("thin", false, true, false, true);
						report.formatColor("yellow");
						report.setStyle();
						break;
					case 1: 
						report.createCells(j, i-1 + ". www.google.com");
						report.formatBorder("thin", false, false, false, true);
						report.formatCells(true, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 2: 
						report.createCells(j, "haqasad" + (i-1));
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 3: 
						report.createCells(j, "asad" +  (i-1));
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 4: 
						report.createCells(j, "Pass");
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					case 5: 
						report.createCells(j, "Test Passed");
						report.formatCells(false, "center");
						report.formatText("Times New Roman", 10, "black", false, false, false);
						report.formatColor("yellow");
						report.formatBorder("thin", false, true, false, true);
						report.setStyle();
						break;
					}
				}		
			}
		}*/

		try {
			/*report.writeToFile(testProperty.getResultFileName());
			report.closeFile();*/
			input.closeFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
