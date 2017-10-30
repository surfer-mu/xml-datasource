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
     * 添加联系人 要求id要唯一
     * @param con
     * @throws IOException 
     * @throws DocumentException 
     */
    public void addContact(Contact con) throws IOException, DocumentException {
            //读取XML文件
            File file=new File("./src/contact.xml");
            if(file.exists()){
            	file.createNewFile();
            }
            Document doc=Dom4jUtil.getDocument(file);
            //添加信息
            Element rootEle=doc.getRootElement();
            //根据根节点添加contact节点
            Element conEle=rootEle.addElement("contact");
            //编号使用UUID算法生成一个随机且唯一的字符串
            conEle.addAttribute("id", UUID.randomUUID().toString());
            conEle.addElement("name").addText(con.getName());
            conEle.addElement("phone").addText(con.getPhone());
            
            //将xml文件写入到磁盘中
            Dom4jUtil.writeXML(file, doc);
    }
    /**
     * 修改联系人
     * @param con
     * @throws DocumentException 
     */
    public void updateContact(Contact con) throws DocumentException {
            //读取XML文件
            File file=new File("./src/contact.xml");
            Document doc=Dom4jUtil.getDocument(file);
            String id=con.getId();
            //XPath技术，快速找出联系人
            Element conEle=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
            conEle.element("name").setText(con.getName());

            conEle.element("phone").setText(con.getPhone());
 
            //将xml文件写入到磁盘中
            Dom4jUtil.writeXML(file, doc);
    }
    /**
     * 根据id删除联系人
     * @param id 
     * @throws DocumentException 
     */
    public void deleteContact(String id) throws DocumentException {
        //读取XML文件
        File file=new File("./src/contact.xml");
        Document doc=Dom4jUtil.getDocument(file);
        //Xpath技术,快速找出联系人
        Element conEle=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
        doc.getRootElement().remove(conEle);
        //将xml文件写入到磁盘中
        Dom4jUtil.writeXML(file, doc);
    }
    /**
     * 查询联系人
     * @return XML文件所有联系人的集合
     * @throws DocumentException 
     */
    public List<Contact> findAll() throws DocumentException {
        //定义一个集合用于装所有的联系人信息
        List<Contact> conList=new ArrayList<Contact>();
        //读取XML文件
        File file=new File("./src/contact.xml");
        Document doc=Dom4jUtil.getDocument(file);
        //获得XML文件中联系人列表
        List<Element> list=doc.getRootElement().elements("contact");
        //遍历联系人列表
        for(Element conEle:list){
            Contact con=new Contact();
            con.setId(conEle.attributeValue("id"));
            con.setName(conEle.elementText("name"));
        
            con.setPhone(conEle.elementText("phone"));

            //每封装一个联系人信息，就添加到集合中
            conList.add(con);
        }
        return conList;
    }
}