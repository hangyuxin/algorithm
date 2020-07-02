package com.hyx.dp.sum;

/**
 * 最大偷窃数额
 * 问：给定一个数组n，数组中全部为大于0的数，取数时不可以连续取，必须接隔一位，求最大能取多大的数
 * 
 * @author sq
 * @date 2020/07/02
 */
public class TheftMoneyMax {
    
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
        int num = arrays[0], max = Math.max(arrays[0], arrays[1]), tmp;
        for (int i = 2, size = arrays.length; i < size; i++) {
            tmp = max;
            max = Math.max(max, num + arrays[i]);
            num = tmp;
        }
        return max;
    }
    
    public static void main(String[] args) {
        final TheftMoneyMax theftMoneyMax = new TheftMoneyMax();
        System.out.println(theftMoneyMax.get(new int[] {1, 2, 3, 1}));
        System.out.println(theftMoneyMax.get(new int[] {2, 6, 8, 1, 3}));
    }

}
