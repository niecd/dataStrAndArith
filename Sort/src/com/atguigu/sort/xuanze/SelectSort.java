package com.atguigu.sort.xuanze;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-19 20:19
 */
/*
选择排序（默认从小到大）
    思路：从数组的第一个元素到最后一个元素中找最小的与第一个交换，
           再从第二个到最后一个中找最小的与第二个交换，以此类推
 */
public class SelectSort {

    public static void sort(int[] arr){
        for (int j = 0; j <arr.length-1 ; j++) {
            int min=arr[j];//定义最小值
            int minIndex=j;//定义最小值的坐标
            //找最小值
            for (int i = j+1; i < arr.length; i++) {
                if(min>arr[i]){
                    min=arr[i];
                    minIndex=i;
                }
            }
            //交换
            arr[minIndex]=arr[j];
            arr[j]=min;
        }
    }
    //测试选择排序
    @Test
    public void test(){
         int[] arr={12,56,41,2,6,8,4,5,3};
         sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
