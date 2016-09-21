import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import xls.IXlsDocument;
import xml.IXmlDocument;

import java.io.File;
import java.io.IOException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-20
 * time: 下午10:40.
 */
public class Xml2Xls implements IXmlDocument, IXlsDocument {


    Workbook wb;

    WritableWorkbook book;

    WritableSheet sheet;

    String sheetName;

    File file;

    public Xml2Xls(File file,String sheetName) {
        this.file = file;
        this.sheetName = sheetName;
    }

    @Override
    public void parserXml(String fileName) {

    }


    public boolean in2xls(Label label) {
        try   {
            //  添加一个工作表
            sheet.addCell(label);
            return true;
        }   catch  (Exception e)  {
            System.out.println(e);
            return false;
        }

    }
    public boolean init(){
        try {
            wb  =  Workbook.getWorkbook(this.file);
            //  打开一个文件的副本，并且指定数据写回到原文件
            book  =  Workbook.createWorkbook(file,wb);
            //  Excel获得文件
            sheet = book.createSheet(this.sheetName,1);
            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        } catch (BiffException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean exit(){
        try {
            book.write();
            try {
                book.close();
                return  true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (WriteException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }





}
