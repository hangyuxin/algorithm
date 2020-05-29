package com.hyx.find.dichotomy;

/**
 * 二分查找算法
 * 
 * @author sq
 * @date 2020/05/29
 */
public class DichotomyFind {
    
    /**
     * 查找某个数在数组中的位置, 数组必须是升序
     * 
     * @param val
     *            要查找的数
     * @param vals
     *            从哪个数组查找
     * @return 在数组中的位置， -1为不存在
     */
    public int findNum(final int val, final int[] vals) {
        if (vals == null || vals.length == 0) {
            return -1;
        }
        int length = vals.length;
        if (vals[length - 1] < val || vals[0] > val) {
            return -1;
        }
        int num = (int)Math.ceil(length / 2.0);
        if (vals[0] == val) {
            return 0;
        }
        do {
            int currentVal = vals[num];
            if (currentVal == val) {
                return num;
            }
            if (currentVal > val) {
                num -= (int)Math.ceil(num / 2.0D);
            } else {
                num += (int)Math.ceil(num / 2.0D);
            }
        } while (num > 0 && num < (length - 1));
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new DichotomyFind().findNum(89, new int[] {0, 3, 56, 89, 456}));
    }

}
