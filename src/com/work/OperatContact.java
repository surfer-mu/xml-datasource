package com.work;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
public class OperatContact {
    /**
     * �����ϵ�� Ҫ��idҪΨһ
     * @param con
     * @throws IOException 
     * @throws DocumentException 
     */
    public void addContact(Contact con) throws IOException, DocumentException {
            //��ȡXML�ļ�
            File file=new File("./src/contact.xml");
            if(file.exists()){
            	file.createNewFile();
            }
            Document doc=Dom4jUtil.getDocument(file);
            //�����Ϣ
            Element rootEle=doc.getRootElement();
            //���ݸ��ڵ����contact�ڵ�
            Element conEle=rootEle.addElement("contact");
            //���ʹ��UUID�㷨����һ�������Ψһ���ַ���
            conEle.addAttribute("id", UUID.randomUUID().toString());
            conEle.addElement("name").addText(con.getName());
            conEle.addElement("phone").addText(con.getPhone());
            
            //��xml�ļ�д�뵽������
            Dom4jUtil.writeXML(file, doc);
    }
    /**
     * �޸���ϵ��
     * @param con
     * @throws DocumentException 
     */
    public void updateContact(Contact con) throws DocumentException {
            //��ȡXML�ļ�
            File file=new File("./src/contact.xml");
            Document doc=Dom4jUtil.getDocument(file);
            String id=con.getId();
            //XPath�����������ҳ���ϵ��
            Element conEle=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
            conEle.element("name").setText(con.getName());

            conEle.element("phone").setText(con.getPhone());
 
            //��xml�ļ�д�뵽������
            Dom4jUtil.writeXML(file, doc);
    }
    /**
     * ����idɾ����ϵ��
     * @param id 
     * @throws DocumentException 
     */
    public void deleteContact(String id) throws DocumentException {
        //��ȡXML�ļ�
        File file=new File("./src/contact.xml");
        Document doc=Dom4jUtil.getDocument(file);
        //Xpath����,�����ҳ���ϵ��
        Element conEle=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
        doc.getRootElement().remove(conEle);
        //��xml�ļ�д�뵽������
        Dom4jUtil.writeXML(file, doc);
    }
    /**
     * ��ѯ��ϵ��
     * @return XML�ļ�������ϵ�˵ļ���
     * @throws DocumentException 
     */
    public List<Contact> findAll() throws DocumentException {
        //����һ����������װ���е���ϵ����Ϣ
        List<Contact> conList=new ArrayList<Contact>();
        //��ȡXML�ļ�
        File file=new File("./src/contact.xml");
        Document doc=Dom4jUtil.getDocument(file);
        //���XML�ļ�����ϵ���б�
        List<Element> list=doc.getRootElement().elements("contact");
        //������ϵ���б�
        for(Element conEle:list){
            Contact con=new Contact();
            con.setId(conEle.attributeValue("id"));
            con.setName(conEle.elementText("name"));
        
            con.setPhone(conEle.elementText("phone"));

            //ÿ��װһ����ϵ����Ϣ������ӵ�������
            conList.add(con);
        }
        return conList;
    }
}