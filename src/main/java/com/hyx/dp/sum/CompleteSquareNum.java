package com.hyx.dp.sum;

/**
 * 完全平方数
 * 问： 给定一个数字n，n大于0，求n由最少需要几个完全平方数相加得到
 * 
 * @author sq
 * @date 2020/07/07
 */
public class CompleteSquareNum {
    
    /**
     * 获取传入的数字最少需要几个完全平方数才可以组成
     * 
     * @param num
     *            要获取的数字
     * @return 最少需要几个
     */
    public int get(final int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        final int[] dps = new int[num + 1];
        dps[0] = 0;
        int max = (int)Math.sqrt(num) + 1;
        final int[] squares = new int[max];
        for (int i = 1; i < max; i++) {
            squares[i] = i * i;
        }
        for (int i = 1, iSize = num + 1; i < iSize; i++) {
            dps[i] = i;
            for (int j = 1; j < max && squares[j] <= i; j++) {
                dps[i] = Math.min(dps[i], dps[i - squares[j]] + 1);
            }
        }
        return dps[num];
    }

    public static void main(String[] args) {
        final CompleteSquareNum completeSquareNum = new CompleteSquareNum();
        System.out.println(completeSquareNum.get(4));
        System.out.println(completeSquareNum.get(12));
        System.out.println(completeSquareNum.get(13));
    }
    
}
