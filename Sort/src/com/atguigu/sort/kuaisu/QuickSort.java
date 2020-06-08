package com.atguigu.sort.kuaisu;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-25 20:02
 */
/*
快排
    思路：
        选择一个基准值，从头找比他大的，从尾找比他小的，然后交换，以此类推
 */
public class QuickSort {
    /**
     *
     * @param arr 需要排序的数组
     * @param left 起始的左坐标
     * @param right 起始的右坐标
     */
    public static void sort(int[] arr,int left,int right) {
        int l=left;//定义从左开始的下标
        int r=right;//定义从右向左开始的坐标
        int standard=arr[(l+r)/2];//定义基准值
        int temp=0;//临时变量，交换时使用
        while(l<r){
            while(arr[l]<standard){//找左侧比基准值大于或等于的值
                l++;//没找到，右移向右找
            }
            while(arr[r]>standard){//找右侧比基准值小于等于的值
                r--;//左移，向左找
            }
            if(l>=r){
                break;//说明基准值的左侧都比他小，右侧都比他大
            }//1,1,3,3
            //找到了合适的值，交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if(arr[l]==standard){//交换后，相等。说明在标准值的右侧找到了相等的值，所以右侧左移，不用再比较这个值
                r--;
            }
            if(arr[r]==standard){//与上面类似
                l++;
            }
        }//l=1,r=0
        if(r==l){//错开，基准值已经是排好序的，否则会栈溢出
            l++;
            r--;
        }
        if(l>left)//向左递归，
        sort(arr,left,r);
        if(r<right)//向右递归
        sort(arr,l,right);
    }
    @Test
    public void test(){
         int[] arr={11,2,3,41,9,5,6,7,8,10};
//        int[] arr={3,3,1,1};
         sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//         sort(arr,0,5);
//        System.out.println(Arrays.toString(arr));
//         sort(arr,5,arr.length-1);
//        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test1(){
        int[] arr=new int[40000000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*arr.length);
        }
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
