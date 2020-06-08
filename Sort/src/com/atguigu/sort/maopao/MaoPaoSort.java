package com.atguigu.sort.maopao;



import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-19 19:51
 */
/*
对冒泡排序的优化
 */
public class MaoPaoSort {
    /**
     * 对冒泡排序的优化
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag=true;//定义变量，检测在一轮排序中是否存在没有交换顺序
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;//存在交换顺序
                }
            }
            System.out.println(Arrays.toString(arr));
            if(flag){
                //存在某一轮没有交换顺序，说明已是有序
                return;
            }
        }
    }
    @Test
    public void test(){
         //测试冒泡排序
        int[] arr={10,50,6,7,8,9};
        sort(arr);
        System.out.println("&&&&&&&&&&&&&&&&");
        System.out.println(Arrays.toString(arr));
    }

}
