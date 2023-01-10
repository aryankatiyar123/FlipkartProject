package flipkart.testcases;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


public class ReadExcelData 
{
    private static Map<String, String> testCaseMap = null;

    //************main method to start execution**************
    public static void main(String args[]) throws IOException 
    {
    	//*************Initializing the path of excel file********************
        FileInputStream fis = new FileInputStream(".\\excelFile\\excelTestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        
        testCaseMap = new HashMap<>();
        
        //*******Reading input line by line**********
        while (rows.hasNext()) 
        {
            Row row = rows.next();
            testCaseMap.put(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
        }
        workbook.close();
    }
    
    
    //********Taking a method name as input********* 
    public static String isExecuteCase(String key) 
    {
        if(testCaseMap == null)
        {
            try 
            {
            	main(null);
            } 
            catch (IOException e) 
            {
                return "No";
            }
        }
        String value = testCaseMap.get(key);
        if(value == null)
        	return "No";
        return value;
    }
}