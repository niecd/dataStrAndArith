package com.atguigu.datastructure.hashtable;

import org.junit.Test;

/**
 * @author LittleChuan
 * @create 2020-04-09 10:29
 */
/*
手动实现hashtable
 */
public class HashTable {
   private EmpLinkedList[] empLinkedLists;
   private int size;
   //初始化HashTable
   public HashTable(int size){
       this.size=size;
       empLinkedLists=new EmpLinkedList[size];
       for (int i = 0; i < size; i++) {
           //为数组赋值
           empLinkedLists[i]=new EmpLinkedList();
       }
   }
   @Test
   public void test(){
        HashTable hashTable=new HashTable(7);
       hashTable.listHash();
   }


   //添加员工
    public void addEmp(Employee employee){
       //得到所在的链表下标
        int index = hashFun(employee.getId());
        //添加员工
        empLinkedLists[index].addEmp(employee);
    }

    //散列函数，根据员工id查找某个员工应该分在哪个链表上
    private int hashFun(int id){
       //使用取模法
        return id%size;
    }

    //遍历hash表
    public void listHash(){
       boolean flag=true;//判断该hash表是否为空，初始为空
        for (int i = 0; i < empLinkedLists.length; i++) {
            if(empLinkedLists[i].getHead()!=null) {
                empLinkedLists[i].listAll();
                flag=false;
                System.out.println();
            }
        }
        if(flag){
            System.out.println("empty of hashTable");
        }
    }

    //删除某个员工
    public void deleteEmp(int id){
       //计算该员工所在hash表的下标
        int index = hashFun(id);
        //删除
        empLinkedLists[index].delete(id);
    }
    //修改某个员工
    public void updateEmp(Employee employee){
       //计算所在的链表
        int index = hashFun(employee.getId());
        empLinkedLists[index].updateEmp(employee);
    }

    //查找某个员工
    public Employee findEmp(int id){
       //计算所在的下标
        int index=hashFun(id);
        return empLinkedLists[index].findEmp(id);
    }
}
