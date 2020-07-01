package com.hyx.dp.sum;

/**
 * 乘积最大子数组
 * 问： 给定一个整数数组s，求s中子数组乘积最大为多少
 * 
 * @author sq
 * @date 2020/07/01
 */
public class MaxSonArrayMultiplication {
    
    /**
     * 获取子数组最大乘积
     * 
     * @param arrays
     *            要获取的数组
     * @return 最大乘积
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        if (arrays.length == 1) {
            return arrays[0];
        }
        int max = arrays[0], min = arrays[0], num = arrays[0], max1;
        for (int i = 1, size = arrays.length; i < size; i++) {
            max1 = Math.max(max * arrays[i], Math.max(arrays[i], min * arrays[i]));
            min = Math.min(min * arrays[i], Math.min(arrays[i], max * arrays[i]));
            max = max1;
            num = Math.max(max, num);
        }
        return num;
    }
    
    public static void main(String[] args) {
        final MaxSonArrayMultiplication maxSonArrayMultiplication = new MaxSonArrayMultiplication();
        System.out.println(maxSonArrayMultiplication.get(new int[] {2, 3, -2, 5}));
        System.out.println(maxSonArrayMultiplication.get(new int[] {-2, 0, -1}));
        System.out.println(maxSonArrayMultiplication.get(new int[] {2, -3, -2, 0, 5}));
        System.out.println(maxSonArrayMultiplication.get(new int[] {-2}));
        System.out.println(maxSonArrayMultiplication.get(new int[] {-2, 0, -1}));
        System.out.println(maxSonArrayMultiplication.get(new int[] {3, -1, 4}));
    }

}
