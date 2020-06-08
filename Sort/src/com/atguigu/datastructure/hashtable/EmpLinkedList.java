package com.atguigu.datastructure.hashtable;

/**
 * @author LittleChuan
 * @create 2020-04-09 10:31
 */
/*
默认员工的id是自增的，现实开发也是如此
 */
public class EmpLinkedList {
    private Employee head;//头结点.默认为null

    public Employee getHead() {
        return head;
    }

    //添加员工
    public void addEmp(Employee employee){
        //第一次添加
        if(head==null){
            head=employee;
            return;
        }

        //定义辅助变量
        Employee temp=head.getNext();
        //判断下个是否为null
        while(temp!=null){
            temp=temp.getNext();
        }

        temp=employee;

    }

    //遍历链表信息
    public void listAll(){
        if(head==null){
            System.out.println("empty of linkedList");
            return;
        }

        //定义辅助变量

        Employee temp =head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp+",");
            temp=temp.getNext();
        }
        System.out.print("]");
    }

    //删除某个员工(该链表已然有序)
    public void delete(int id){
        //头结点为空
        if(head==null){
            System.out.println("empty of linkedList,can not delete");
            return;
        }
        //头结点是需要删除的
        if(head.getId()==id){
            head=head.getNext();
            return;
        }
        //定义辅助变量
        Employee temp=head;
        while(temp.getNext().getId()!=id){
            if(temp.getNext()==null){
                //说明找到了最后也没找到
                System.out.println("找不到该员工，删除失败");
                return;
            }
            //往后移，查找
            temp=temp.getNext();
        }
        //退出循环时，找到了需要删除节点的上一个节点
        //需要删除节点的上一个节点的next指向，删除节点的下一个节点
        temp.setNext(temp.getNext().getNext());

    }
    //根据id修改某个员工的信息,id不可修改
    public void updateEmp(Employee employee){
        if(head==null){
            System.out.println("empty of linkedList,can not update");
            return;
        }
        //定义辅助变量
        Employee temp=head;
        while(temp.getId()!=employee.getId()){
            if(temp.getNext()==null){
                //为null,说明找到了最后也没找到
                System.out.println("没有找到该员工，修改失败");
                return;
            }else
              temp=temp.getNext();
        }
        //退出循环时，找到了该员工,修改信息
        temp.setName(employee.getName());
    }


    //根据id查找某个员工
    public Employee findEmp(int id){
        //头结点为null
        if(head==null){
            System.out.println("empty of linkedList,can not find");
            return null;
        }

        //定义辅助变量
        Employee temp=head.getNext();
        while (temp.getId()!=id){
            if(temp.getNext()==null){
                //找到了结尾，未找到
                return null;
            }
            //后移继续找
            temp=temp.getNext();
        }

        //退出循环找到了
        return temp;
    }
}
