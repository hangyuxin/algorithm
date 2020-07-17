package com.hyx.dp.find;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大套娃
 * 问：给定一组二维数组as，代表一些信封。第二维数组中第一个数字代表信封的宽度，第二个代表长度，如果一个信封的长宽都比另外一组小就可以放进去，求最大可以嵌套几个信封
 * 
 * @author sq
 * @date 2020/07/16
 */
public class MaxMatryoshka {
    
    /**
     * 求最大可以嵌套多少层
     * @param <T>
     * 
     * @param arrays
     *            信封数组
     * @return 最大多少层
     */
    public <T> int get(final int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        Arrays.sort(arrays, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        final int[] dps = new int[arrays.length];
        for (int i = 0, size = dps.length; i < size; i++) {
            dps[i] = arrays[i][1];
        }
        return this.get(dps);
    }

    private int get(int[] nums) {
        final int[] dps = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dps, 0, res, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dps[i] = num;
            if (i == res) {
                res++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        final MaxMatryoshka maxMatryoshka = new MaxMatryoshka();
        System.out.println(maxMatryoshka.get(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

}
