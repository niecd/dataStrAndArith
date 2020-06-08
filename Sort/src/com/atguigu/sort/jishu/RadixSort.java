package com.atguigu.sort.jishu;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-26 16:53
 */
/*
基数排序（桶排序的改进）
    原理：有10个桶，遍历数组，根据个位不同，放在对应的桶中（0~9），再依次从10个桶中取出数据，放在原来的数组
                   再遍历新数组，根据十位的不同，放在对应的桶中（0~9），再依次从10个桶中取出数据，放在原来的数组
                   依次类推,一共排几次取决于数组最大数的位数
          通过定义一个二维数组来模拟十个桶
 */
public class RadixSort {
    public static void sort(int[] arr) {
        //找数组的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //获取最大数的位数
        int digit = (max + "").length();
        int[][] bucket = new int[10][arr.length];//10:代表十个桶，arr.length代表该桶存放的最大的元素个数（极限：例如：个位数都相同）；
        int[] bucketCount = new int[10];//记录每个桶中有效的元素个数
        for (int i = 0, n = 1; i < digit; i++, n *= 10) {
            //n 代表当前是按照哪个位上的数进行放桶（个位/十位/百位...）
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j] / n % 10;
//                System.out.println(temp);
                //将数放入对应的桶中
                bucket[temp][bucketCount[temp]++] = arr[j];
            }

            //取出10个桶中的数据
            int t = 0;//给原数组赋值的起始下标
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] != 0) {
                    for (int j = 0; j < bucketCount[m]; j++) {
                        arr[t] = bucket[m][j];
                        t++;
                    }
                    bucketCount[m] = 0;//将该桶个数置0，避免下次记录该桶个数从此累加
                }
            }
        }
    }
    @Test
    public void test(){
//         int[] arr={1,8,9,5,3,6,4,7,10,2,0};
        int[] arr=new int[40000000];//2888
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*arr.length);
        }
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        System.out.println(Arrays.toString(arr));
    }

}
