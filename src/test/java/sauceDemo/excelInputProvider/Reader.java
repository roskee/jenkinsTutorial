package sauceDemo.excelInputProvider;

import jxl.Cell;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    Workbook workbook;// = Workbook.createWorkbook(new File("sample.xls"));
    public Reader(){
        try{
            workbook = Workbook.getWorkbook(new File("sampleexcel.xls"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getUsername(String type){
        Cell label = workbook.getSheet(0).findCell(type);
        return workbook.getSheet(0).getRow(label.getRow())[label.getColumn()+1].getContents();
    }
    public String getPassword(String type){
        Cell label = workbook.getSheet(0).findCell(type);
        return workbook.getSheet(0).getRow(label.getRow())[label.getColumn()+2].getContents();
    }
    public String[] getAllUsernames(){
        List<String> usernames = new ArrayList<String>();
        Cell[] column = workbook.getSheet(0).getColumn(0);
        for(int i=1;i<5;i++)
            usernames.add(column[i].getContents());
        return usernames.toArray(new String[]{});
    }
    public  String getStandardUsername(){
        Cell label = workbook.getSheet(0).findCell("standardUser");
        return workbook.getSheet(0).getRow(label.getRow())[label.getColumn()+1].getContents();
    }
    public String getStandardPassword(){
        Cell label = workbook.getSheet(0).findCell("standardUser");
        return workbook.getSheet(0).getRow(label.getRow())[label.getColumn()+2].getContents();
    }
    public String[] getAllPasswords(){
        List<String> passwords = new ArrayList<String>();
        Cell[] column = workbook.getSheet(0).getColumn(1);
        for(int i=1;i<5;i++)
            passwords.add(column[i].getContents());
        return passwords.toArray(new String[]{});
    }
}
