package com.atguigu.search.binary;

import org.junit.Test;

/**
 * @author LittleChuan
 * @create 2020-03-26 20:45
 */
/*
二分法查找
 */
public class BinarySearch {
    /**
     * 不使用递归
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;
        while (left < right) {
            if (value < arr[middle]) {
                right = middle;
            } else if (value > arr[middle]) {
                left = middle;
            } else {
                return middle;
            }
            middle = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 使用递归的方式
     *
     * @param arr
     * @param left  左起始下标
     * @param right 右下标
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        //value<arr[0]和value>arr[arr.length-1]条件在插值查找时必须需要，否则middle可能越界
            //value值特别大，会导致middle也特别大，可能越界
            //value值特别小，会导致middle也特别小（甚至为负数），可能越界
        //二分查找时，这两个条件可起到优化的作用
        if(left>right||value<arr[0]||value>arr[arr.length-1]){
            return -1;
        }
//        int middle = (left + right) / 2;//这是二分查找
        int middle=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);//这是插值查找
        if (value < arr[middle]) {
            return binarySearch(arr, left, middle-1, value);
        } else if (value > arr[middle]) {
            return binarySearch(arr, middle+1, right, value);
        } else {
            return middle;
        }


    }


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 6, 6, 7, 8, 9};
        int i = binarySearch(arr, 0, arr.length - 1, 7);
        System.out.println("i = " + i);
    }

}
