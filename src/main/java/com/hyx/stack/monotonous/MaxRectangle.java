package com.hyx.stack.monotonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大矩形 问：
 * 给定一个数组a，a中全部为非负整数，求a中存在的最大矩形面积为多少？
 * 
 * @author sq
 * @date 2020/06/21
 */
public class MaxRectangle {
    
    /**
     * 获取最大矩形面积
     * 
     * @param arrays 给定的数组
     * @return 矩形面积
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        if (arrays.length == 1) {
            return arrays[0];
        }
        int num = 0;
        final int[] heights = new int[arrays.length + 2];
        System.arraycopy(arrays, 0, heights, 1, arrays.length);
        final Deque<Integer> stack = new ArrayDeque<>(arrays.length);
        stack.add(0);
        for (int i = 1, size = heights.length; i < size; i++) {
            if (heights[i] < 0) {
                return -1;
            }
            while (heights[i] < heights[stack.peekLast()]) {
                int currentHeight = heights[stack.pollLast()];
                int currentWidth = i - stack.peekLast() - 1;
                num = Math.max(num, currentHeight * currentWidth);
            }
            stack.add(i);
        }
        return num;
    }
    
    public static void main(String[] args) {
        final MaxRectangle maxRectangle = new MaxRectangle();
        System.out.println(maxRectangle.get(new int[] {2, 1, 5, 6, 2, 4}));
        System.out.println(maxRectangle.get(new int[] {2, 2}));
    }

}
