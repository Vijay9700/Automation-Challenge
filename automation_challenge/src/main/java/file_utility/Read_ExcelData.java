package file_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class has the functionality to read the data from excel file
 * plugin-->Apache poi-common(4.1.2)
 * 		 -->Apache poi-ooxml(4.1.2)
 */
/**
 * @author Vijay Ganesan
 */

public class Read_ExcelData {
	
	public String readExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		//file path
		String excel_path="./src/test/resources/Testscript_Data/Automation_Challenge.xlsx";
		//get the object of excel file
		FileInputStream fis=new FileInputStream(excel_path);
		//open excel in read mode
		Workbook workbook = WorkbookFactory.create(fis);
		//get sheet control
		Sheet sheet = workbook.getSheet(sheetname);
		//get row control
		Row row = sheet.getRow(rowno);
		//get cell control
		Cell cell = row.getCell(cellno);
		//read data
		String data = cell.getStringCellValue();
		//return data
		return data;
	}
}
