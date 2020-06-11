package com.hyx.dp.sum;

/**
 * 问：
 * 给定一个整型数组arrays(大于 1)，将每个数n换算为高为n宽为1的柱子，求这些柱子中可以接多少水
 * 解：
 * @author sq
 * @date 2020/06/10
 */
public class CatchRain {
    
    /**
     * 获取可以接多少雨水
     * 
     * @param arrays
     *            雨水的数组
     * @return 可以接多少
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length < 3) {
            return 0;
        }
        int[] left_height = new int[arrays.length];
        int[] right_height = new int[arrays.length];
        for (int i = 1,size = arrays.length; i < size; i++) {
            left_height[i] = Math.max(left_height[i - 1], arrays[i - 1]);
        }
        for (int i = arrays.length - 2; i >= 0; i--) {
            right_height[i] = Math.max(right_height[i + 1], arrays[i + 1]);
        }
        int sum = 0;
        for (int i = 1,  size = arrays.length - 1; i < size; i++) {
            if (arrays[i] < left_height[i] && arrays[i] < right_height[i]) {
                sum += Math.min(left_height[i], right_height[i]) - arrays[i];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        final CatchRain catchRain = new CatchRain();
        System.out.println(catchRain.get(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
