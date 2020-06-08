package com.atguigu.datastructure.tree.binarytree;

import org.junit.Test;

/**
 * @author LittleChuan
 * @create 2020-04-09 20:58
 */
/*
二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        User root = new User(1, "宋江");
        User node2 = new User(2, "吴用");
        User node3 = new User(3, "卢俊义");
        User node4 = new User(4, "林冲");
        User node5 = new User(5, "花荣");
        //构建树
        BinaryTree binaryTree = new BinaryTree();
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //前序查找
        User user = binaryTree.preSearch(5);
        System.out.println("user = " + user);

        //前序遍历 1 2 3 5 4
        System.out.println("前序遍历---------");
        binaryTree.preOrder();

        //中序遍历2 1 5 3 4
        System.out.println("中序遍历--------------");
        binaryTree.indexOrder();

        //后序遍历 2 5 4 3 1
        System.out.println("后序遍历--------------");
        binaryTree.postOrder();


        System.out.println("前序查找");
        User user1 = binaryTree.preSearch(3);
        System.out.println("user1 = " + user1);

        System.out.println("中序查找");
        User user2 = binaryTree.indexSearch(4);
        System.out.println("user2 = " + user2);


        System.out.println("中序查找");
        User user3 = binaryTree.indexSearch(6);
        System.out.println("user3 = " + user3);

    }

    private User root;//定义根节点

    public void setRoot(User root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void indexOrder() {
        if (root != null) {
            root.indexOrder();
        } else {
            System.out.println("树为空，无法遍历");
        }
    }

    @Test
    public void test(){
         int x=5;
        System.out.println(x*=5);

        System.out.println('1');
    }


    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("树为空，无法遍历");
        }
    }

    /**
     * 根据id前序查找
     *
     * @param id
     * @return
     */
    public User preSearch(Integer id) {
        if (root != null) {
            return root.preSearch(id);
        } else {
            throw new RuntimeException("树没有节点，无法查找");
        }
    }

    //中序查找
    public User indexSearch(Integer id) {
        if (root != null) {
            return root.indexSearch(id);
        } else {
            throw new RuntimeException("树没有节点，无法查找");
        }
    }

    //后序查找
    public User postSearch(Integer id) {
        if (root != null) {
            return root.postSearch(id);
        } else {
            throw new RuntimeException("树没有节点，无法查找");
        }
    }
}
