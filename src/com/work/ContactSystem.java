package com.work;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 *  ��дһ��ͨѶ¼����       
 *  ��������
        1��������ϵ��
        2���޸���ϵ��
        3��ɾ����ϵ��
        4����ѯ������ϵ�ˣ�ȫ����
        5���˳�ϵͳ
    Ҫ��
        1������ʹ�ÿ���̨���н���
        2����ϵ�˵����ݴ洢��xml�ļ���(contact.xml)  ��dom4j�Ĳ�����
        xml�ļ���ʽ��
        <contact id="001" hobby="eat">
        <name>����</name>
        <gender>��</gender>
        <age>22</age>
        <phone>17728394033</phone>
        <email>101440122@qq.com</email>
        <address>130��</address>
        </contact>
 * @author LZK
 *
 */
 //���е�������
public class ContactSystem {
    public static void main(String[] args) throws Exception {
        //����һ����ȡ��,��ȡ�û�������
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        //����һ����ϵ�˲�������
        OperatContact oper=new OperatContact();
        while(true){
            System.out.println("==========ͨ��¼ϵͳ=========");
            System.out.println("[1]������ϵ��");
            System.out.println("[2]�޸���ϵ��");
            System.out.println("[3]ɾ����ϵ��");
            System.out.println("[4]��ѯ������ϵ��");
            System.out.println("[5]�˳�ϵͳ");
            System.out.print("��������������:");
            String command=bufr.readLine();
            //�����ϵ��,����װ��Contact�����С�
            if("1".equals(command)){
                Contact con = new Contact();
                System.out.print("��������ϵ�˵�������");
                String name=bufr.readLine();
                con.setName(name);
             
                System.out.print("��������ϵ�˵ĵ绰��");
                String phone=bufr.readLine();
                con.setPhone(phone);
            
                //��XML�ļ��������ϵ��
                oper.addContact(con);
                System.out.println("============��ӳɹ���=============");
            }
            //�޸���ϵ�ˣ�����װ��Ϣ������
            else if("2".equals(command)){
                Contact con = new Contact();
                System.out.print("����������Ҫ�޸ĵ���ϵ�˵�id:");
                String id=bufr.readLine();
                con.setId(id);
                System.out.print("���޸���ϵ�˵�������");
                String name=bufr.readLine();
                con.setName(name);
      
                System.out.print("���޸���ϵ�˵ĵ绰��");
                String phone=bufr.readLine();
                con.setPhone(phone);
             
                //����XML�ļ�����ϵ��
                oper.updateContact(con);
                System.out.println("============�޸ĳɹ���=============");
            }
            //ɾ����ϵ��
            else if("3".equals(command)){
                System.out.print("��������Ҫɾ������ϵ�˵�id��");
                String id=bufr.readLine();
                oper.deleteContact(id);
                System.out.println("============ɾ���ɹ���=============");
            }
            //��ѯ��ϵ��
            else if("4".equals(command)){
                List<Contact> conlist=oper.findAll();
                for(Contact con:conlist){
                    System.out.println(con);
                }
            }
            //�˳�ϵͳ
            else if("5".equals(command)){
                System.exit(0);
            }
        }   
    }
}