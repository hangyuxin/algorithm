package com.hyx.dp.find;

/**
 * 计算各个位数不同的数字个数
 * 问：给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10的n次方 。
 * 
 * @author sq
 * @date 2020/07/17
 */
public class CountNumbersWithUniqueDigits {

    /**
     * 获取有多少种不同的数字
     * 
     * @param num
     *            给定的数字
     * @return 到底有多少
     */
    public int get(int num) {
        if (num == 0) {
            return 1;
        }
        int first = 10, second = 9 * 9;
        int size = Math.min(num, 10);
        for (int i = 2; i <= size; i++) {
            first += second;
            second *= 10 - i;
        }
        return first;
    }
}
