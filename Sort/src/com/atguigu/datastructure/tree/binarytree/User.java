package com.atguigu.datastructure.tree.binarytree;

/**
 * @author LittleChuan
 * @create 2020-04-09 20:58
 */
public class User {
    private int id;
    private String name;
    private User left;//左子节点
    private User right;//右子节点

    /**
     * 前序遍历
     */
    public void preOrder(){
        //输出父节点
        System.out.println(this);
        if(this.getLeft()!=null){
            //向左前序遍历
            this.getLeft().preOrder();
        }
        if(this.getRight()!=null){
            //向右前序遍历
            this.getRight().preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void indexOrder(){
        if(this.getLeft()!=null){
            //向左中序遍历
            this.getLeft().indexOrder();
        }
        //输出父节点
        System.out.println(this);
        if(this.getRight()!=null){
            //向右中序遍历
            this.getRight().indexOrder();
        }
    }

    /**
     *后序遍历
     */
    public void postOrder(){
        if(this.getLeft()!=null){
            //向左后序遍历
            this.getLeft().postOrder();
        }
        if(this.getRight()!=null){
            //向右后序遍历
            this.getRight().postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     *
     * @param id 根据id查找
     * @return 找到返回对应节点，没找到返回null
     */
    public User preSearch(Integer id){
        //判断当前节点
        if(this.id==id){
            return this;
        }
        //定义临时变量存放查询结果
        User temp=null;
        //判断左子节点是否为null
        if(this.getLeft()!=null){
            //向左查找
           temp= this.getLeft().preSearch(id);
        }
        //判断查询到的是否符合要求
        if(temp!=null){
            //说明找到了
            return temp;
        }
        //左边也没查询到,向右查询
        if(this.getRight()!=null){
             temp = this.getRight().preSearch(id);
        }
        //不管是否为null，都需要返回
        return temp;
    }

    /**
     *
     * @param id 根据id中序查找
     * @return
     */
    public User indexSearch(Integer id){
        //定义临时变量接受查询结果
        User temp=null;
        //判断左子节点是否为null
        if(this.left!=null){
            temp= this.getLeft().indexSearch(id);
        }
        if(temp!=null){
            return temp;//找到了
        }
        //判断当前节点
        if(this.getId()==id){
            return this;
        }
        //判断右子节点
        if(this.getRight()!=null){
            temp= this.getRight().indexSearch(id);
        }
        return temp;
    }


    /**
     *
     * @param id 根据id后序查找
     * @return
     */
    public User postSearch(Integer id){
        //定义临时变量接受查询结果
        User temp=null;
        //判断左子节点是否为null
        if(this.left!=null){
            temp= this.getLeft().postSearch(id);
        }
        //判断右子节点
        if(this.getRight()!=null){
            temp= this.getRight().postSearch(id);
        }
        if(temp!=null){
            return temp;
        }
        if(this.getId()==id){
            return this;
        }
        return null;
    }



    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getLeft() {
        return left;
    }

    public void setLeft(User left) {
        this.left = left;
    }

    public User getRight() {
        return right;
    }

    public void setRight(User right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
