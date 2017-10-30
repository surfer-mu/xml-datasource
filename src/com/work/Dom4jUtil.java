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
     * ��ȡXML�ļ�
     * @param f Ҫ��ȡ��XML�ļ�
     * @return  Document �ļ�
     * @throws DocumentException 
     */
    public static Document getDocument(File f) throws DocumentException{
    	Document doc=new SAXReader().read(f);
            return doc;
        
    }
    /**
     * ���޸ĺõ��ļ�д�뵽Դ�ļ���
     * @param f Ҫд����ļ�
     * @param doc д����ĵ�
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

