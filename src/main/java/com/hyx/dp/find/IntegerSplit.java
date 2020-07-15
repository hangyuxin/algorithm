package com.hyx.dp.find;

import java.util.Arrays;

/**
 * 整数拆分
 * 问： 给定一个正整数n，将n拆分为至少两个整数n1，n2,ni要求n=n1+n2+ni，求n1*n2*ni最大为多少
 * 
 * @author sq
 * @date 2020/07/15
 */
public class IntegerSplit {
    
    /**
     * 获取拆分后的最大乘积
     * 
     * @param num要获取的整数
     * @return 最大乘积
     */
    public int get(int num) {
        if (num < 2 || num > 58) {
            return 0;
        }
        final int[] dps = new int[num + 1];
        Arrays.fill(dps, 1);
        for (int i = 3; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                dps[i] = Math.max(dps[i], Math.max(j * (i - j), j * dps[i - j]));
            }
        }
        return dps[num];
    }
    
    public static void main(String[] args) {
        System.out.println(new IntegerSplit().get(2));
        System.out.println(new IntegerSplit().get(10));
    }

}
