
import jxl.write.Label;
import jxl.write.WritableSheet;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import xml.Xml;

import java.io.File;
import java.net.MalformedURLException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-20
 * time: 下午11:58.
 */
public class Test {

    public static void main(String[] args){

        File xmlFile = new File("/home/nero/code/xml2xls/src/test/resources/test.xml");
        File xlsFile = new File("/home/nero/code/xml2xls/src/test/resources/test.xls");

        Xml xml = new Xml();//xml资源加载器管理器
        Xml2Xls xml2Xls = new Xml2Xls(xlsFile,"genes"); //转换器
        xml2Xls.init();
        try {
            int row = 0;
            for(Element element:xml.getAllElement(xml.getRootElement(xml.read(xmlFile)))){
                int column = 0;
                for (Element childElement:xml.getAllElement(element)){
                    System.out.print(" |"+childElement.getText());
                    xml2Xls.in2xls(new Label(column,row,childElement.getText()));
                    column++;
                }
                System.out.println(" |");
                row++;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        xml2Xls.exit();
    }
}
