package com.hyx.list.node;

/**
 * 重复数字
 * 问： 给定一个数组，改数组中存在一个数字是重复的，求这个重复的数字为多少
 * 
 * @author sq
 * @date 2020/07/06
 */
public class RepeatNumber {
    
    /**
     * 获取重复的数字
     * 
     * @param nums 要获取的数组
     * @return 重复的数字
     */
    public int get(final int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int i = 0, j = 0;
        for (;;) {
            i = nums[i];
            j = nums[nums[j]];
            if (i == j) {
                break;
            }
        }
        i = 0;
        while (i != j) {
            i = nums[i];
            j = nums[j];
        }
        return i;
    }
    
    public static void main(String[] args) {
        final RepeatNumber repeatNumber = new RepeatNumber();
        System.out.println(repeatNumber.get(new int[] {1, 3, 4, 2, 2}));
        System.out.println(repeatNumber.get(new int[] {3, 1, 3, 4, 2}));
        System.out.println(repeatNumber.get(new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }

}
