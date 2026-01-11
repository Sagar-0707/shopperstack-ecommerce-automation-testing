package com.Shopperstack_GenericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.ss.usermodel.DataFormatter;  //...... (updated for Edit address section)
import org.apache.poi.ss.usermodel.Row;  //...... (updated for Edit address section)
import org.apache.poi.ss.usermodel.Cell; //...... (updated for Edit address section)


public class File_Utility 
{
    public String readDataFromPropertyFile(String key) throws IOException
    {
        FileInputStream fis=new FileInputStream(FrameWorkConstants.propertyFilepath);
        Properties pro = new Properties();
        pro.load(fis);
        String value = pro.getProperty(key);
        return value;
    }
    
    
    public String readDataFromExcelFile(String sheetName,int rowNum,int CellNum) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis = new FileInputStream(FrameWorkConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		  // its getting fail this (...... update for edit address section)
		
	    //String value = wb.getSheet(sheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
		//return value;
		
		
		Row row = wb.getSheet(sheetName).getRow(rowNum);
        Cell cell = row.getCell(CellNum);
        
        // Initialize DataFormatter (you can also initialize it globally in the class)
        DataFormatter formatter = new DataFormatter();
        
        // This line handles all data types (String, Numeric, etc.) and returns a String
        String value = formatter.formatCellValue(cell);
        
        // Close resources
        wb.close();
        fis.close();
        
		return value;
	}
}
