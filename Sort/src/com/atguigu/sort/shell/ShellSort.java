package com.atguigu.sort.shell;

import com.atguigu.sort.charu.InsertSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author LittleChuan
 * @create 2020-03-20 21:20
 */
/*
希尔排序（插入排序）,通过缩小增量
 */
public class ShellSort {
    //自己写的希尔排序（交换法），有瑕疵,少考虑了交换得到次数
    public static void sort1(int[] arr){
        for (int i = arr.length/2; i >1; i/=2) {
            System.out.println("前"+Arrays.toString(arr));
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + i]) {
                    int temp = arr[j];
                    arr[j] = arr[j + i];
                    arr[j + i] = temp;
                }
            }
            System.out.println("后"+Arrays.toString(arr));
        }
        InsertSort.sort2(arr);
        System.out.println("最终"+Arrays.toString(arr));
    }
    //参考老师的代码，希尔排序（交换），比较耗时，比直接插入耗时长
    public static void sort2(int[] arr){
        //定义步长
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            System.out.println("前"+Arrays.toString(arr));
            for (int i = gap; i < arr.length; i++) {//通过步长确定执行需要交换的次数
                for (int j = i-gap; j >=0; j--) {//与该元素对应步长的元素，进行交换(类似于 2和4交换，j--,后0和2在交换)
                        if(arr[j]>arr[j+gap]){
                            int temp = arr[j];
                            arr[j] = arr[j + gap];
                            arr[j + gap] = temp;
                        }
                }
            }
            System.out.println("后"+Arrays.toString(arr));
        }
    }
    //希尔排序（移位法）
    public static void sort3(int[] arr){
        //定义增量（步长）
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int temp=arr[i];//记录当前需要插入的数
                int index=i-gap;//记录要插入位置的下标
                while (index>=0&&temp<arr[index]){
                   arr[index+gap] =arr[index];
                    index-=gap;
                }
                //退出循环说明找到了插入的位置
                arr[index+gap]=temp;
//                System.out.println(Arrays.toString(arr));

            }
//            System.out.println(Arrays.toString(arr));
        }
    }
    public void in(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int temp=arr[i];//记录当前需要插入的数
            int index=i-1;//记录要插入位置的下标
            while (index>=0&&temp<arr[index]){
                arr[i] =arr[index];
                index-=1;
            }
            //退出循环说明找到了插入的位置
            arr[index+1]=temp;

        }
    }


    @Test
    public void test(){
        int[] arr=new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
         sort3(arr);
        System.out.println(Arrays.toString(arr));
    }

}
