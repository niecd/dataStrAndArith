package com.atguigu.sort.charu;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-19 20:45
 */
/*
插入排序（默认从小到大）
    思路
        把数组看成一个有序表和一个无序表
        刚开始有序表中只有一个元素，再从无序表中取出第一个元素，插入到有序表中适当的位置，使有序表依然有序
        以此类推，使整个数组有序
 */
public class InsertSort {

    //插入排序 自己写的一
    public static void sort1(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j =i+1,m=j-1; m>0; m--) {
                //值处于有序列表的中间
                if(arr[j]<arr[m]&&arr[j]>arr[m-1]){
                    //记录此时插入的值
                    int temp=arr[j];
                    for(int k=j;k>m;k--){
                        arr[k]=arr[k-1];
                    }
                    arr[m]=temp;
                    break;
                }else if(arr[j]<=arr[0]){//小于有序列的最小值
                    int temp=arr[j];
                    for (int k = i; k >=0; k--) {
                        arr[k+1]=arr[k];
                    }
                    arr[0]=temp;
                    break;
                }else if(arr[j]>arr[j-1]){//大于此时有序列表的最大值
                   break;
                }
            }
        }

    }
    //思路
//        从有序列表的最大值往前找，找到所插入值第一次大于等于有序列表中的某个值，那么这个值的后一位即该插入值的位置
    public static void sort2(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int indexValue=arr[i+1];//需要插入的值
            int index=i;//需要插入值前一个值的下标
            for (; index >=0; index--) {
                //需要插入的值小于有序列表的最后一个元素
                if(arr[index]>indexValue)
                    arr[index+1]=arr[index];//边查找边后移
                else /*if(arr[index]<=indexValue){*///找到该插入的位置
                    break;

            }
            //index--之后在退出的循环，是要插到元素的后一个位置
            if(index!=i){//index==i,说明需要插入的值大于有序列表的最大值，不需要在赋值
                arr[index+1]=indexValue;
            }



        }

    }
    @Test
    public void test(){
         int[] arr={7,-2,8,6,3,2,5,4,9,-3,-1,1};
//         sort1(arr);
//        int[] arr=new int[80];
//        for (int i = 0; i < 80; i++) {
//            arr[i]=(int)(Math.random()*80);
//        }
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

}
