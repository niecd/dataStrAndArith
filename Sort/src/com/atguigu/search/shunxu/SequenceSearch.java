package com.atguigu.search.shunxu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LittleChuan
 * @create 2020-03-26 20:39
 */
//顺序查找

public class SequenceSearch {
    /**
     * 查找第一个
     * @param arr 数组
     * @param value 需要查找的值
     * @return -1，代表没找到，>=0,位第一个的下标
     */
    public static int search(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value)
                return i;
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param value
     * @return list为null,不存在，，不为null,多个下标构成的集合
     */
    public static List<Integer> searchAll(int[] arr, int value){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value)
                list.add(i);
        }
        return list;
    }
}
