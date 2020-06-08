package com.atguigu.sort.guibing;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-26 15:57
 */
/*
归并排序
    思路：采用分治策略，先把数组分为单个的，再两两排序，结果再两两排序，直到整个数组都是有序的，类似完全二叉树
 */
public class MergeSort {
    /**
     * 分+治
     * @param arr 需要排序的数组
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mind=(left+right)/2;
            //向左分
            mergeSort(arr,left,mind,temp);
            //向右分
            mergeSort(arr,mind+1,right,temp);
            merge(arr,left,mind,right,temp);
        }
    }

    //分治的治
    public static void merge(int[] arr,int left,int mind,int right,int[] temp){
        int i=left;//定义左边有序列表的起始下标
        int j=mind+1;//定义右边有序列表的起始下标
        int t=0;//临时数组的起始下标
        while(i<=mind&&j<=right){//合并两个有序列表
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];//将两个有序列表的最小值放到临时的数组的开头
                t++;//后移，放第二个元素
                i++;
            }else{
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        //将两个有序列表其中一个剩下的元素也填充到temp中
        while(i<=mind){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while(j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        t=0;//把索引位置移到起始位置
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
        }
    @Test
    public void test(){
         int[] arr={1,8,5,9,2,4,6,3,7,10,0};
         int[] temp=new int[arr.length];
         mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

}
