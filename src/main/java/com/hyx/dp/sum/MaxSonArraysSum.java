package com.hyx.dp.sum;

/**
 * 问：
 * 给定一个整型数组arrays，数组中一个或连续的多个整数组成一个子数组，求所有子数组的和的最大值
 * 解：
 * 每个连续数组的最大值s=max(arrays[i]+s,arrays[i])
 * 那么所有的连续数组的最大值的最大值maxS=max(s,maxS);
 * @author sq
 * @date 2020/06/08
 */
public class MaxSonArraysSum {
    
    /**
     * 获取连续数组的最大值
     * 
     * @param arrays
     *            传入的连续数组
     * @return 最大值
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        if (arrays.length < 2) {
            return arrays[0];
        }
        int maxSum = arrays[0];
        int maxSum1 = maxSum;
        for (int i = 1, size = arrays.length; i < size; i++) {
            maxSum1 = Math.max(maxSum1 + arrays[i], arrays[i]);
            maxSum = Math.max(maxSum1, maxSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        final MaxSonArraysSum maxSonArraysSum = new MaxSonArraysSum();
        System.out.println(maxSonArraysSum.get(new int[] {2, 3, 5, 6, -30, 4, 6, 2, -2, 5, -9}));
    }

}
