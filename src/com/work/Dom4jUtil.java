package com.work;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtil {
    /**
     * 读取XML文件
     * @param f 要读取的XML文件
     * @return  Document 文件
     * @throws DocumentException 
     */
    public static Document getDocument(File f) throws DocumentException{
    	Document doc=new SAXReader().read(f);
            return doc;
        
    }
    /**
     * 将修改好的文件写入到源文件中
     * @param f 要写入的文件
     * @param doc 写入的文档
     */
    public static void writeXML(File f,Document doc){
        try {

            OutputStream ops=new FileOutputStream(f);
            OutputFormat format=OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter writer = new XMLWriter(ops,format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

