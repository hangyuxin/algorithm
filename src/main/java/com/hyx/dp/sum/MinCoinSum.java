package com.hyx.dp.sum;

import java.util.Arrays;

/**
 * 最少掏硬币
 * 问：给定一个硬币金额数组a，一个物品金额n，求最少需要花多少个硬币才可以买下这个物品
 * 
 * @author sq
 * @date 2020/07/13
 */
public class MinCoinSum {
    
    /**
     * 求最少需要掏多少硬币
     * 
     * @param arrays
     *            硬币数组
     * @param num
     *            总金额
     * @return 最少需要多少，如果无法付款返回-1
     */
    public int get(final int[] arrays, final int num) {
        if (arrays == null || arrays.length == 0 || num < 0) {
            return -1;
        }
        int max = num + 1;
        final int[] dps = new int[max];
        Arrays.fill(dps, max);
        dps[0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0, jSize = arrays.length; j < jSize; j++) {
                if (arrays[j] <= i) {
                    dps[i] = Math.min(dps[i], dps[i - arrays[j]] + 1);
                }
            }
        }
        return dps[num] > num ? -1 : dps[num];
    }
    
    public static void main(String[] args) {
        final MinCoinSum minCoinSum = new MinCoinSum();
        System.out.println(minCoinSum.get(new int[] {1, 2, 5}, 11));
        System.out.println(minCoinSum.get(new int[] {2}, 5));
    }

}
