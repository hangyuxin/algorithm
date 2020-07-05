package com.hyx.dp.find;

/**
 * 丑数
 * 问： 给定一个数字n，求第n个丑数为多少？(丑数为质因数只有2,3,5的数)
 * 
 * @author sq
 * @date 2020/07/05
 */
public class UglyNumber {

    /**
     * 获取第n个丑数
     * 
     * @param num
     *            要获取第几个
     * @return 丑数为多少
     */
    public int get(int num) {
        if (num < 7) {
            return num;
        }
        final int dps[] = new int[num];
        dps[0] = 1;
        int min = 0, i1 = 0, i2 = 0, i3 = 0;
        for (int i = 1; i < num; i++) {
            min = Math.min(Math.min(dps[i1] * 2, dps[i2] * 3), dps[i3] * 5);
            dps[i] = min;
            if (min == dps[i1] * 2) {
                i1++;
            }
            if (min == dps[i2] * 3) {
                i2++;
            }
            if (min == dps[i3] * 5) {
                i3++;
            }
        }
        return dps[num - 1];
    }
    
    public static void main(String[] args) {
        final UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.get(10));
    }
    
}
