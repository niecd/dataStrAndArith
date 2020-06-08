package com.atguigu.datastructure.hashtable;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author LittleChuan
 * @create 2020-04-09 14:01
 */
public class Test1 {
    public static void main(String[] args) {
        HashTable hashTable=new HashTable(7);
        Scanner scan = new Scanner(System.in);
        String key ="";
        l:while(true){

            System.out.println("add:添加员工");
            System.out.println("list:显示所有员工");
            System.out.println("exit:退出系统");
            System.out.println("del:删除");
            System.out.print("请输入");
            key=scan.next();
            switch (key){
                case "add" :
                    System.out.print("请输入id");
                    int id=scan.nextInt();
                    System.out.print("请输入姓名");
                    String name=scan.next();
                    Employee emp = new Employee(id, name);
                    hashTable.addEmp(emp);
                    break;
                case "list" :
                    hashTable.listHash();
                    break;
                case "exit":
                    scan.close();
                    break l;
                case "del" :
                    System.out.print("请输入id");
                    id=scan.nextInt();
                    hashTable.deleteEmp(id);
                    break ;
            }
        }
    }

}
