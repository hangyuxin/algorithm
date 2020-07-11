package com.hyx.dp.find;

import java.util.Arrays;

/**
 * 最大拼接数
 * 问：给定两个数组a1，a2，数组中只存在0-9的数，求按n个数字排列组合而成的最大数为什么，排列时不可以打乱原数组的顺序
 * 
 * @author sq
 * @date 2020/07/11
 */
public class MaxStitchingNumber {
    
    /**
     * 获取两个数组拼接出来的最大数字
     * 
     * @param arrays1
     *            数组1
     * @param arrays2
     *            数组2
     * @param num
     *            要获取多少数字
     * @return 最大数字为多少
     */
    public int[] get(final int[] arrays1, final int[] arrays2, final int num) {
        if (arrays1 == null || arrays2 == null || arrays1.length + arrays2.length < num) {
            return new int[] {};
        }
        int[] results = new int[num];
        int size1 = arrays1.length, size2 = arrays2.length;
        for (int i = Math.max(0, num - size2), size = Math.min(num, size1); i <= size; i++) {
            if (results[0] == 0) {
                results = this.getCombinationMax(this.maxKsequence(arrays1, i), this.maxKsequence(arrays2, num - i));
            } else {
                results = this.getMax(
                    this.getCombinationMax(this.maxKsequence(arrays1, i), this.maxKsequence(arrays2, num - i)),
                    results);
            }
        }
        return results;
    }
    
    /**
     * 获取两个数组中的最大数组
     * 
     * @param arrays1
     *            数组1
     * @param arrays2
     *            数组2
     * @return 最大的数组
     */
    private int[] getMax(final int[] arrays1, int[] arrays2) {
        for (int i = 0, size = arrays1.length; i < size; i++) {
            if (arrays1[i] == arrays2[i]) {
                continue;
            }
            if (arrays1[i] > arrays2[i]) {
                return arrays1;
            } else {
                return arrays2;
            }
        }
        return arrays1;
    }

    /**
     * 获取有两个数组组成的最大数字
     * 
     * @param arrays1
     *            数组1
     * @param arrays2
     *            数组2
     * @return 最大数组
     */
    private int[] getCombinationMax(final int[] arrays1, int[] arrays2) {
        if (arrays1.length == 0) {
            return arrays2;
        }
        if (arrays2.length == 0) {
            return arrays1;
        }
        final int[] results = new int[arrays1.length + arrays2.length];
        int index1 = 0, index2 = 0;
        for (int i = 0, size = results.length; i < size; i++) {
            if (this.compare(Arrays.copyOfRange(arrays1, index1, arrays1.length),
                Arrays.copyOfRange(arrays2, index2, arrays2.length))) {
                results[i] = arrays1[index1++];
            } else {
                results[i] = arrays2[index2++];
            }
        }
        return results;
    }

    /**
     * 获取两个数组谁大
     * 
     * @param arrays1
     *            数组1
     * @param arrays2
     *            数组2
     * @return 数组1是否大于数组2
     */
    private boolean compare(final int[] arrays1, int[] arrays2) {
        int size = Math.min(arrays1.length, arrays2.length);
        for (int i = 0; i < size; i++) {
            if (arrays1[i] > arrays2[i]) {
                return true;
            }
            if (arrays1[i] < arrays2[i]) {
                return false;
            }
        }
        return arrays1.length > arrays2.length;
    }

    /**
     * 获取数组中有num位数组成的最大数为多少，不可以更换顺序
     * 
     * @param arrays1
     *            要获取的数组
     * @param num
     *            要获取多少位数
     * @return 最大数字
     */
    private int[] maxKsequence(int[] arrays1, int num) {
        if (arrays1.length < num) {
            throw new ArrayIndexOutOfBoundsException(num);
        }
        if (num == 0) {
            return new int[] {};
        }
        if (arrays1.length == num) {
            return arrays1;
        }
        final int[] results = new int[num];
        int size = arrays1.length - num,  tmp, tmpSize;
        int size1 =  size;
        for (int i = 0; i < num; i++) {
            tmp = arrays1[i + size1 - size];
            tmpSize = size;
            for (int j = 1; j <= size; j++) {
                if (arrays1[i + size1 - size + j] > tmp) {
                    tmp = arrays1[i + size1 - size + j];
                    tmpSize = size - j;
                }
            }
            results[i] = tmp;
            size = Math.min(size, tmpSize);
        }
        return results;
    }
    
    public static void main(String[] args) {
        final MaxStitchingNumber maxStitchingNumber = new MaxStitchingNumber();
        System.out.println(Arrays.toString(maxStitchingNumber.get(new int[]{3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(maxStitchingNumber.get(new int[]{6, 7}, new int[] {6, 0, 4}, 5)));
        System.out.println(Arrays.toString(maxStitchingNumber.get(new int[]{3, 9}, new int[] {8, 9}, 3)));
    }

}
