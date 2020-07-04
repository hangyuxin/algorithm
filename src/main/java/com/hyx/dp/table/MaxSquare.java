package com.hyx.dp.table;

/**
 * 最大正方形 
 * 问：给定一个二维数组n，数组汇总只有0,1两种数字，求有1组成的正方形最大面积为多大？
 * 
 * @author sq
 * @date 2020/07/04
 */
public class MaxSquare {

    /**
     * 获取最大正方形的大小
     * 
     * @param arrays
     *            要从那个数组获取
     * @return 最大为多少
     */
    public int get(final int[][] arrays) {
        int max = 0;
        if (arrays == null || arrays.length == 0 || arrays[0] == null || arrays[0].length == 0) {
            return max;
        }
        int iSize = arrays.length, jSize = arrays[0].length;
        final int[][] dps = new int[iSize][jSize];
        dps[0][0] = arrays[0][0];
        for (int i = 1; i < jSize; i++) {
            if (arrays[0][i] == 1) {
                dps[0][i] = 1;
            } else {
                dps[0][i] = dps[0][i - 1];
            }
        }
        for (int i = 1; i < iSize; i++) {
            if (arrays[i][0] == 1) {
                dps[i][0] = 1;
            } else {
                dps[i][0] = dps[i - 1][0];
            }
        }
        for (int i = 1; i < iSize; i++) {
            for (int j = 1; j < jSize; j++) {
                if (arrays[i][j] == 1) {
                    dps[i][j] = Math.min(Math.min(dps[i - 1][j], dps[i][j - 1]), dps[i - 1][j - 1]) + 1;
                    max = Math.max(max, dps[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        final MaxSquare maxSquare = new MaxSquare();
        System.out.println(maxSquare.get(new int[][] {
            {1, 0, 1, 1, 0}, 
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1}
        }));
    }

}
