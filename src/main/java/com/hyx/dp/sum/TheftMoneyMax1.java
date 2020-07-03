package com.hyx.dp.sum;

/**
 * 最大偷窃数额
 * 问：给定一个数组n，数组中全部为大于0的数，取数时不可以连续取，必须接隔一位，求最大能取多大的数, 首尾只能可以偷窃一个
 * 
 * @author sq
 * @date 2020/07/02
 */
public class TheftMoneyMax1 {
    
    /**
     * 求最大能偷多少钱
     * 
     * @param arrays
     *            每家存放的钱
     * @return 最大能偷窃的钱
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        if (arrays.length == 1) {
            return arrays[0];
        }
        final int[][] dps = new int[arrays.length][2];
        dps[0][0] = 0;
        dps[0][1] = arrays[0];
        dps[1][0] = arrays[1];
        dps[1][1] = arrays[0];
        for (int i = 2, size = arrays.length; i < size; i++) {
            if (i == size - 1) {
                dps[i][0] = Math.max(dps[i - 1][0] , dps[i - 2][0] + arrays[i]);
                dps[i][1] = dps[i - 1][1];
            } else {
                dps[i][0] = Math.max(dps[i - 1][0] , dps[i - 2][0] + arrays[i]);
                dps[i][1] = Math.max(dps[i - 1][1] , dps[i - 2][1] + arrays[i]);
            }
        }
        return Math.max(dps[arrays.length - 1][0], dps[arrays.length - 1][1]);
    }
    
    public static void main(String[] args) {
        final TheftMoneyMax1 theftMoneyMax = new TheftMoneyMax1();
        System.out.println(theftMoneyMax.get(new int[] {1, 2, 2}));
        System.out.println(theftMoneyMax.get(new int[] {2, 6, 8, 1, 3}));
    }

}
