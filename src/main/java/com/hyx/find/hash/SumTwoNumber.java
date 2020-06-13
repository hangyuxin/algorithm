package com.hyx.find.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 问：给定 一组数组arrays和一个数n，求出数组中哪两个元素之和等于n
 * 
 * @author sq
 * @date 2020/06/13
 */
public class SumTwoNumber {
    
    /**
     * 获取等于传入数字之和的两个数字的下标
     * 
     * @param arrays
     *            给定的数组
     * @param target
     *            要求的数字
     * @return
     */
    public int[] get(final int[] arrays, int target) {
        if (arrays == null || arrays.length < 2) {
            return null;
        }
        final Map<Integer, Integer> results = new HashMap<>(arrays.length);
        for (int i = 0, size = arrays.length; i < size; i++) {
            final Integer integer = results.get(target - arrays[i]);
            if(integer != null) {
                return new int[] {integer, i};
            }
            results.put(arrays[i], i);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumTwoNumber().get(new int[] {1, 7, 3, 4, 10, 5, 2, 8, -1},  9)));
    }

}
