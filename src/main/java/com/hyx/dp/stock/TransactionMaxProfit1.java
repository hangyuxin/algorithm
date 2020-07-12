package com.hyx.dp.stock;

/**
 * 最佳买卖股票时机含冷冻期
 * 问： 给定一个数组a，第i个元素代表第i天股票的价格，求如何买卖可以获得最大利益，卖出后有一天的冷冻期，第二天不可以再次买入，必须尽可能多的去买卖
 * 
 * @author sq
 * @date 2020/07/12
 */
public class TransactionMaxProfit1 {
    
    /**
     * 获取最大利润为多少
     * 
     * @param arrays 要获取的股票走势
     * @return 最大利润为多少
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return 0;
        }
        int dp0 = -arrays[0], dp1 = 0, dp2 = 0, tmp1, tmp2, tmp3;
        for (int i = 1; i < arrays.length; i++) {
            tmp1 = Math.max(dp0, dp2 - arrays[i]);
            tmp2 = dp0 + arrays[i];
            tmp3 = Math.max(dp1, dp2);
            dp0 = tmp1;
            dp1 = tmp2;
            dp2 = tmp3;
        }
        int maxProfit = Math.max(dp1, dp2);
        return maxProfit;
    }
    
    public static void main(String[] args) {
        final TransactionMaxProfit1 transactionMaxProfit1 = new TransactionMaxProfit1();
        System.out.println(transactionMaxProfit1.get(new int[] {1, 2, 3, 0, 2}));
        System.out.println(transactionMaxProfit1.get(new int[] {3, 2, 3, 0, 2}));
    }
    

}
