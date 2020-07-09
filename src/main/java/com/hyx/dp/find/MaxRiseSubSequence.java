package com.hyx.dp.find;

import java.util.Arrays;

/**
 * 最长上升子序列 
 * 问： 给定一个数组a， 求a中最长的上升子序列长度
 * 
 * @author sq
 * @date 2020/07/08
 */
public class MaxRiseSubSequence {
    
    /**
     * 获取数组的最长子序列的长度
     * 
     * @param arrays 要获取的数组
     * @return 子序列的长度
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        if (arrays .length == 1) {
            return 1;
        }
        final int[] dps = new int[arrays.length];
        int max = 0;
        Arrays.fill(dps, 1);
        for (int i = 0, size = dps.length; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] < arrays[i]) {
                    dps[i] = Math.max(dps[i], dps[j] + 1);
                }
            }
            max = Math.max(max, dps[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        final MaxRiseSubSequence maxRiseSubSequence = new MaxRiseSubSequence();
        System.out.println(maxRiseSubSequence.get(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
