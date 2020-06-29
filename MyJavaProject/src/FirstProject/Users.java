package src.ProjectExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import src.ProjectExcel.Accounts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Users extends Accounts {
    ArrayList<String> IDs = new ArrayList<> ();
    ArrayList<String> passwords = new ArrayList<> ();
    ArrayList<String> names = new ArrayList<> ();



    public void OpenDatabase()
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Karina Meliksetova\\Desktop\\ATMDatabase.xlsx"));

            Workbook workbook = WorkbookFactory.create(file);

            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

              for(int i = 1; i < sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(0);
                    names.add (cell.getStringCellValue());

                }


            for(int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(1);
                passwords.add (cell.getStringCellValue());

            }


            for(int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(2);
                IDs.add (cell.getStringCellValue());

            }


            XSSFSheet sheet2 = (XSSFSheet) workbook.getSheetAt(1);

            for(int i = 1; i < sheet2.getLastRowNum(); i++) {
                Row row = sheet2.getRow(i);
                Cell cell = row.getCell(0);
                AcctNames.add (cell.getStringCellValue());

            }


            for(int i = 1; i < sheet2.getLastRowNum(); i++) {
                Row row = sheet2.getRow(i);
                Cell cell = row.getCell(1);
                acctnumbers.add (cell.getStringCellValue());

            }


            for(int i = 1; i < sheet2.getLastRowNum(); i++) {
                Row row = sheet2.getRow(i);
                Cell cell = row.getCell(2);
                accttypes.add (cell.getStringCellValue());

            }


            for(int i = 1; i < sheet2.getLastRowNum(); i++) {
                Row row = sheet2.getRow(i);
                Cell cell = row.getCell(3);
                balances.add (cell.getNumericCellValue ());

            }



            for(int i = 1; i < sheet2.getLastRowNum(); i++) {
                Row row = sheet2.getRow(i);
                Cell cell = row.getCell(4);
                withdraws.add ((int)cell.getNumericCellValue ());

            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


public void SaveDatabase(){




    XSSFWorkbook workbook = new XSSFWorkbook();

    //Create a blank sheet
    XSSFSheet sheet = workbook.createSheet("Users");

    ArrayList<String> header = new ArrayList<> ();
    header.add ("Name");
    header.add ("Password");
    header.add ("ID");

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 12);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    Row headerRow = sheet.createRow(0);

    // Create cells
    for(int i = 0; i < header.size (); i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(header.get (i));
        cell.setCellStyle(headerCellStyle);
    }


    // Create Other rows and cells with employees data
    int rowNum = 1;
    for(int i=0; i<names.size (); i++) {
        Row row = sheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(names.get (i));

        row.createCell(1)
                .setCellValue(passwords.get (i));

        row.createCell(2)
                .setCellValue(IDs.get (i));
    }



    XSSFSheet sheet2 = workbook.createSheet ("Accounts");

    ArrayList<String> header2 = new ArrayList<> ();
    header2.add ("Name");
    header2.add ("Account");
    header2.add ("Type");
    header2.add ("Amount");
    header2.add ("W/O");

    Row headerRow2 = sheet2.createRow(0);

    // Create cells
    for(int i = 0; i < header2.size (); i++) {
        Cell cell = headerRow2.createCell(i);
        cell.setCellValue(header2.get (i));
        cell.setCellStyle(headerCellStyle);
    }


    // Create Other rows and cells with employees data
    int rowNum2 = 1;
    for(int i=0; i<AcctNames.size (); i++) {
        Row row2 = sheet2.createRow(rowNum2++);

        row2.createCell(0)
                .setCellValue(AcctNames.get (i));

        row2.createCell(1)
                .setCellValue(acctnumbers.get (i));

        row2.createCell(2)
                .setCellValue(accttypes.get (i));

        row2.createCell(3)
                .setCellValue(balances.get (i));

        row2.createCell(4)
                .setCellValue(withdraws.get (i));

    }



    //Save the excel sheet
    try{
        FileOutputStream out = new FileOutputStream(
                new File ("C:\\Users\\Karina Meliksetova\\Desktop\\ATMDatabase2.xlsx"));
        workbook.write(out);
        out.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    names.clear ();
    passwords.clear ();
    IDs.clear ();
    AcctNames.clear ();
    acctnumbers.clear ();
    accttypes.clear ();
    balances.clear ();
    withdraws.clear ();



}








    public void Database() {
        names.add ("Karina");
        names.add ("Irina");
        names.add ("Alex");
        names.add ("Betty");
        names.add ("Tom");
        names.add ("Jerry");
        names.add ("Sam");
        names.add ("Henry");
        names.add ("Sabrina");
        names.add ("Margo");
        passwords.add ("run");
        passwords.add ("fox");
        passwords.add ("fun");
        passwords.add ("key");
        passwords.add ("tom");
        passwords.add ("cat");
        passwords.add ("dog");
        passwords.add ("box");
        passwords.add ("rom");
        passwords.add ("bug");
        IDs.add ("1111");
        IDs.add ("2222");
        IDs.add ("3333");
        IDs.add ("4444");
        IDs.add ("5555");
        IDs.add ("5566");
        IDs.add ("6666");
        IDs.add ("7777");
        IDs.add ("8888");
        IDs.add ("9999");


        setAccount ("Karina", "11111", "Checking", 1500.00, 10);
        setAccount ("Karina", "11112", "Savings", 3000.00, 4);
        setAccount ("Karina", "11113", "Money Market", 10000, 0);
        setAccount ("Karina", "11114", "Money Market", 5000.00, 7);
        setAccount ("Karina", "11115", "Checking", 1500.00, 85);
        setAccount ("Irina", "22221", "Checking", 500.00, 100);
        setAccount ("Irina", "22222", "Savings", 8000.00, 5);
        setAccount ("Alex", "33331", "Checking", 500.00, 48);
        setAccount ("Alex", "33332", "Savings", 50.00, 4);
        setAccount ("Betty", "44441", "Checking", 15000.00, 10);
        setAccount ("Tom", "55554", "Money Market", 5000.00, 7);
        setAccount ("Tom", "55555", "Checking", 1500.00, 85);
        setAccount ("Tom", "55551", "Checking", 500.00, 100);
        setAccount ("Jerry", "55661", "Savings", 8000.00, 5);
        setAccount ("Jerry", "55662", "Checking", 500.00, 48);
        setAccount ("Jerry", "55663", "Money Market", 5000.00, 7);
        setAccount ("Sam", "66661", "Checking", 1500.00, 85);
        setAccount ("Sam", "66662", "Checking", 500.00, 100);
        setAccount ("Henry", "77771", "Savings", 8000.00, 5);
        setAccount ("Henry", "77772", "Checking", 500.00, 48);
        setAccount ("Sabrina", "88881", "Money Market", 5000.00, 7);
        setAccount ("Sabrina", "88882", "Checking", 1500.00, 85);
        setAccount ("Margo", "99991", "Checking", 500.00, 100);
        setAccount ("Margo", "99992", "Savings", 8000.00, 5);
        setAccount ("Margo", "99993", "Checking", 500.00, 48);



        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Users");

        ArrayList<String> header = new ArrayList<> ();
        header.add ("Name");
        header.add ("Password");
        header.add ("ID");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < header.size (); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header.get (i));
            cell.setCellStyle(headerCellStyle);
        }


        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(int i=0; i<names.size (); i++) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(names.get (i));

            row.createCell(1)
                    .setCellValue(passwords.get (i));

            row.createCell(2)
                    .setCellValue(IDs.get (i));
        }



        XSSFSheet sheet2 = workbook.createSheet ("Accounts");

        ArrayList<String> header2 = new ArrayList<> ();
        header2.add ("Name");
        header2.add ("Account");
        header2.add ("Type");
        header2.add ("Amount");
        header2.add ("W/O");

        Row headerRow2 = sheet2.createRow(0);

        // Create cells
        for(int i = 0; i < header2.size (); i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(header2.get (i));
            cell.setCellStyle(headerCellStyle);
        }


        // Create Other rows and cells with employees data
        int rowNum2 = 1;
        for(int i=0; i<AcctNames.size (); i++) {
            Row row2 = sheet2.createRow(rowNum2++);

            row2.createCell(0)
                    .setCellValue(AcctNames.get (i));

            row2.createCell(1)
                    .setCellValue(acctnumbers.get (i));

            row2.createCell(2)
                    .setCellValue(accttypes.get (i));

            row2.createCell(3)
                    .setCellValue(balances.get (i));

            row2.createCell(4)
                    .setCellValue(withdraws.get (i));

        }



        //Save the excel sheet
        try{
            FileOutputStream out = new FileOutputStream(
                    new File ("C:\\Users\\Karina Meliksetova\\Desktop\\ATMDatabase.xlsx"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        names.clear ();
        passwords.clear ();
        IDs.clear ();
        AcctNames.clear ();
        acctnumbers.clear ();
        accttypes.clear ();
        balances.clear ();
        withdraws.clear ();



    }

    }



