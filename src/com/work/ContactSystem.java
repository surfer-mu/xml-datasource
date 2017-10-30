package com.work;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 *  编写一个通讯录程序       
 *  功能需求：
        1）增加联系人
        2）修改联系人
        3）删除联系人
        4）查询所有联系人（全部）
        5）退出系统
    要求：
        1）交互使用控制台进行交互
        2）联系人的数据存储到xml文件中(contact.xml)  （dom4j的操作）
        xml文件格式：
        <contact id="001" hobby="eat">
        <name>张三</name>
        <gender>男</gender>
        <age>22</age>
        <phone>17728394033</phone>
        <email>101440122@qq.com</email>
        <address>130号</address>
        </contact>
 * @author LZK
 *
 */
 //运行的主程序
public class ContactSystem {
    public static void main(String[] args) throws Exception {
        //建立一个读取流,获取用户的输入
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        //创建一个联系人操作对象
        OperatContact oper=new OperatContact();
        while(true){
            System.out.println("==========通信录系统=========");
            System.out.println("[1]增加联系人");
            System.out.println("[2]修改联系人");
            System.out.println("[3]删除联系人");
            System.out.println("[4]查询所有联系人");
            System.out.println("[5]退出系统");
            System.out.print("请输入需求数字:");
            String command=bufr.readLine();
            //添加联系人,并封装到Contact对象中。
            if("1".equals(command)){
                Contact con = new Contact();
                System.out.print("请输入联系人的姓名：");
                String name=bufr.readLine();
                con.setName(name);
             
                System.out.print("请输入联系人的电话：");
                String phone=bufr.readLine();
                con.setPhone(phone);
            
                //向XML文件中添加联系人
                oper.addContact(con);
                System.out.println("============添加成功！=============");
            }
            //修改联系人，并封装信息到对象
            else if("2".equals(command)){
                Contact con = new Contact();
                System.out.print("请输入你想要修改的联系人的id:");
                String id=bufr.readLine();
                con.setId(id);
                System.out.print("请修改联系人的姓名：");
                String name=bufr.readLine();
                con.setName(name);
      
                System.out.print("请修改联系人的电话：");
                String phone=bufr.readLine();
                con.setPhone(phone);
             
                //更新XML文件的联系人
                oper.updateContact(con);
                System.out.println("============修改成功！=============");
            }
            //删除联系人
            else if("3".equals(command)){
                System.out.print("请输入你要删除的联系人的id：");
                String id=bufr.readLine();
                oper.deleteContact(id);
                System.out.println("============删除成功！=============");
            }
            //查询联系人
            else if("4".equals(command)){
                List<Contact> conlist=oper.findAll();
                for(Contact con:conlist){
                    System.out.println(con);
                }
            }
            //退出系统
            else if("5".equals(command)){
                System.exit(0);
            }
        }   
    }
}