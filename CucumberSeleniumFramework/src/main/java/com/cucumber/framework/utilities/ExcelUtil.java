package com.cucumber.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet worksheet;
    static Workbook workbook = null;
    static Hashtable dict = new Hashtable();

    public ExcelUtil(String ExcelSheetPath) throws IOException, BiffException {
        //Initialize
        String workingDir = System.getProperty("user.dir");
        workbook = workbook.getWorkbook(new File(workingDir + ExcelSheetPath));
        worksheet = workbook.getSheet("Sheet1");

        ColumnDictionary();
    }

    public static int RowCount(){
        return worksheet.getRows();
    }

    public static String ReadCell(int column, int row){
        return worksheet.getCell(column,row).getContents();
    }

    public static String ReadCell(String colname, int row){
        return ReadCell(GetCell(colname),row);
    }

    public static void ColumnDictionary(){
        for (int col = 0; col < worksheet.getColumns(); col++){
            //Assuming excel firstrow always column header
            dict.put(ReadCell(col,0),col);
        }
    }

    public static int GetCell(String colName){
        try {
            int value;
            return ((Integer) dict.get(colName)).intValue();
        } catch (NullPointerException e){
            return (0);
        }
    }
}