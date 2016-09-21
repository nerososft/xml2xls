package xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-20
 * time: 下午10:56.
 */
public class Xml extends VisitorSupport {
    // 从文件读取XML，输入文件名，返回XML文档
    public Document read(File file) throws MalformedURLException, DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }


    //获取root节点
    public Element getRootElement(Document doc){
        return doc.getRootElement();
    }

    //获取所有节点
    public List<Element> getAllElement(Element element){
        // 枚举所有子节点
        List<Element> elements = new ArrayList<Element>();
        for (Iterator i = element.elementIterator(); i.hasNext(); ) {
            elements.add((Element) i.next());
        }
        return elements;
    }

    //获取节点属性
    public List<Attribute> allAttribute(Element element){
        List<Attribute> attributes  =new ArrayList<Attribute>();
        // 枚举属性
        for ( Iterator i = element.attributeIterator(); i.hasNext(); ) {
            attributes.add((Attribute) i.next());
        }
        return attributes;
    }

    //获取节点名称
    public void visit(Element element){
        System.out.println(element.getName());
    }
    //获取属性名称
    public void visit(Attribute attr){
        System.out.println(attr.getName());
    }





}
