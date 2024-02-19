package LPMAOSeleniumPOC.Utilities.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ExcelObject {
	
	private String filePath;
	private String sheetName;
	Workbook wrkBook;
	WritableWorkbook wrtWorkBook;
	Sheet sheet;
	WritableSheet wrtSheet;
	
	public ExcelObject(String filePath, String sheetName){
		this.filePath = filePath;
		this.sheetName = sheetName;
		
	}
	
	public void openExcel(){
		try {
				wrkBook = Workbook.getWorkbook(new FileInputStream(filePath));
				sheet = wrkBook.getSheet(sheetName);
				wrtWorkBook = Workbook.createWorkbook(new File(filePath),wrkBook);
				wrtSheet = wrtWorkBook.getSheet(sheetName);
				
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void getSheet(String sheetName){
		wrtSheet = wrtWorkBook.getSheet(sheetName);
		
	}
	
	public String readCellData(int rowNumber, int colNumber){
		Cell cell = wrtSheet.getCell(colNumber, rowNumber);	
		return cell.getContents();
		
	}
	
	
	public void writeCellData(int rowNumber, int colNumber, String data){
		try {
			wrtSheet.addCell(new Label(colNumber,rowNumber, data));
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeExcel(){
		try {
			wrtWorkBook.close();
			wrkBook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveExcel(){
		try {
			wrtWorkBook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
