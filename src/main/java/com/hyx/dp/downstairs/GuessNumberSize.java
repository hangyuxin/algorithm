package com.hyx.dp.downstairs;

/**
 * 猜数字大小
 * 问：给定一个数字大小n，每次随机猜一个数，然后考诉所猜数字的大小，如果不对就需要扣掉所猜数字的金钱，求最少需要多少钱才可以猜到这个数字
 * 
 * @author sq
 * @date 2020/07/18
 */
public class GuessNumberSize {
    
    /**
     * 获取最少需要多少钱
     * 
     * @param num
     *            所要猜的数字
     * @return 最少需要多少钱
     */
    public int get(int num) {
       if (num < 2) {
           return 0;
       }
       final int[][] dps = new int[num + 1][num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = i - 1; j > 0; j--) {
                int min = Integer.MAX_VALUE, left = 0, right = 0;
                for (int k = i; k > j - 1; k--) {
                    left = (k == j || j == k - 1) ? -1 : dps[k - 1][j];
                    right = (k == i || i == k + 1) ? -1 : dps[i][k + 1];
                    min = (left == -1 && right == -1) ? k : Math.min(Math.max(left, right) + k, min);
                }
                dps[i][j] = min;
            }
        }
       return dps[num][1];
    }
    
    public static void main(String[] args) {
        System.out.println(new GuessNumberSize().get(10));
    }
    
}
