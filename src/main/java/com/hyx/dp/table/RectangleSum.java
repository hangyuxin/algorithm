package com.hyx.dp.table;

/**
 * 矩形和
 * 问：给定一个二维数组a，求任意点p(x,y)到p1(x1,y1)中的数字和为多少，其中x<x1,y<y1
 * 
 * @author sq
 * @date 2020/07/09
 */
public class RectangleSum {
    
    /**
     * 获取 矩形内数字之和
     * @param nums 要获取的数组
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param x1 右下角x坐标
     * @param y1 右下角y坐标
     * @return 数字之和
     */
    public int get(final int[][] nums, int x, int y, int x1, int y1) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
            return 0;
        }
        if (x <= 0 || y <= 0 || x > x1 || y > y1 || x1 + 1 > nums[0].length || y1 + 1 > nums.length) {
            return 0;
        }
        int l = nums[0].length;
        final int[][] dps = new int[nums.length][l];
        dps[0][0] = nums[0][0];
        for (int i = 1, size = nums.length; i < size; i++) {
            dps[i][0] = dps[i - 1][0] + nums[i][0];
        }
        for (int i = 1, size = l; i < size; i++) {
            dps[0][i] = dps[0][i - 1] + nums[0][i];
        }
        for (int i = 1, iSize = nums.length; i < iSize; i++) {
            final int[] arrays = nums[i];
            if (arrays == null || arrays.length != l) {
                return 0;
            }
            for (int j = 1; j < l; j++) {
                dps[i][j] = dps[i - 1][j] + dps[i][j - 1] - dps[i - 1][j - 1] + nums[i][j];
            }
        }
        return dps[x1][y1] - dps[x - 1][y1] - dps[x1][y - 1] + dps[x - 1][y - 1]; 
    }
    
    public static void main(String[] args) {
        final RectangleSum rectangleSum = new RectangleSum();
        System.out.println(rectangleSum.get(
            new int[][] {
                {3, 0, 1, 4, 2}, 
                {5, 6, 3, 2, 1}, 
                {1, 2, 0, 1, 5}, 
                {4, 1, 0, 1, 7}, 
                {1, 0, 3, 0, 5}
                }, 2, 1, 4, 3));
        System.out.println(rectangleSum.get(
            new int[][] {
                {3, 0, 1, 4, 2}, 
                {5, 6, 3, 2, 1}, 
                {1, 2, 0, 1, 5}, 
                {4, 1, 0, 1, 7}, 
                {1, 0, 3, 0, 5}
            }, 1, 1, 2, 2));
        System.out.println(rectangleSum.get(
            new int[][] {
                {3, 0, 1, 4, 2}, 
                {5, 6, 3, 2, 1}, 
                {1, 2, 0, 1, 5}, 
                {4, 1, 0, 1, 7}, 
                {1, 0, 3, 0, 5}
            }, 1, 2, 2, 4));
    }

}
