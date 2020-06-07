package com.hyx.dp.stack;

/**
 * 问：
 * 给定一个数组a[]，数组中的数据为一只股票的每日价钱，第i个元素代表股票第i天的价钱，请设计一个策略求出最大买n次所获得的利益
 * 解：
 * 当第一天买入时：
 * 花的钱(buy)=0-a[0];卖出去的钱(sell)=0
 * 第i天时：
 * buy=max(buy(i-1), 0-a[i])
 * sell=max(sell(i), buy(i)+a[i])
 * buy(n) = max(buy(n), sell(i-1)-a[i])
 * sell(n) = max(sell(n), buy(n)+a[i])
 * @author sq
 * @date 2020/06/07
 */
public class TransactionMaxProfit {
    
    /**
     * 获取最大利润
     * 
     * @param num，
     *            可以买入的次数
     * @param arrays
     *            股票的价格
     * @return 最大的利润
     */
    public int get(int num, final int[] arrays) {
        if (arrays == null || arrays.length < 2 || num < 1) {
            return 0;
        }
        final int[][] nums = new int[num][];
        for (int i = 0; i < num; i++) {
            nums[i] = new int[] {-arrays[0], 0};
        }
        for (int i = 1,size = arrays.length; i < size; i++) {
            nums[0][0] = Math.max(nums[0][0], -arrays[i]);
            nums[0][1] = Math.max(nums[0][1], nums[0][0] + arrays[i]);
            for (int j = 1, sizeJ = nums.length; j < sizeJ; j++) {
                nums[j][0] = Math.max(nums[j][0], nums[j][1] - arrays[i]);
                nums[j][1] = Math.max(nums[j][1], nums[j][0] + arrays[i]);
            }
        }
        return nums[num - 1][1];
    }
    
    public static void main(String[] args) {
        final TransactionMaxProfit transactionMaxProfit = new TransactionMaxProfit();
        System.out.println(transactionMaxProfit.get(2, new int[] {3, 3, 5, 0, 0, 1, 3, 5}));
        System.out.println(transactionMaxProfit.get(1, new int[] {3, 3, 5, 0, 0, 1, 3, 5}));
        System.out.println(transactionMaxProfit.get(3, new int[] {3, 3, 5, 0, 0, 1, 3, 5}));
        System.out.println(transactionMaxProfit.get(2, new int[] {5, 4, 3, 2, 1}));
        System.out.println(transactionMaxProfit.get(1, new int[] {5, 4, 3, 2, 1}));
        System.out.println(transactionMaxProfit.get(3, new int[] {5, 4, 3, 2, 1}));
        System.out.println(transactionMaxProfit.get(2, new int[] {1, 2, 3, 4, 5, 6}));
        System.out.println(transactionMaxProfit.get(1, new int[] {1, 2, 3, 4, 5, 6}));
        System.out.println(transactionMaxProfit.get(3, new int[] {1, 2, 3, 4, 5, 6}));
    }

}
