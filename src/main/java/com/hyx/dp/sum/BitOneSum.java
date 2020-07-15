package com.hyx.dp.sum;

import java.util.Arrays;

/**
 * 比特位计数
 * 问：给定一个正整数n，求0-n之间每个整数的二进制中包含1的个数
 * 
 * @author sq
 * @date 2020/07/14
 */
public class BitOneSum {
    
    /**
     * 获取从0-n中每个数字的二进制包含多少个1
     * 
     * @param num
     *            最大获取到多少
     * @return 每个数字包含多少个1
     */
    public int[] get(int num) {
        if (num < 0) {
            return new int[] {};
        }
        if (num == 0) {
            return new int[] {0};
        }
        if (num == 1) {
            return new int[] {0, 1};
        }
        final int[] results = new int[num + 1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 1;
        for (int i = 3, size = num + 1; i < size; i++) {
            /*if ((i & 1) == 1) {
                results[i] = results[i - 1] + 1;
            } else {
                results[i] =  results[i / 2];
            }*/
            results[i] = results[i >> 1] + (i & 1);
        }
        return results;
    }
    
    public static void main(String[] args) {
        final BitOneSum bitOneSum = new BitOneSum();
        System.out.println(5 >> 1);
        System.out.println(Arrays.toString(bitOneSum.get(2)));
        System.out.println(Arrays.toString(bitOneSum.get(5)));
    }

}
