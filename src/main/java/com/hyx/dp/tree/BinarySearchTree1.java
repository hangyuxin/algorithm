package com.hyx.dp.tree;

/**
 * 不同二差搜索树
 * 问：给定一个整数，将该数恢复成二叉搜索树，求最多可以恢复出多少种
 * 
 * @author sq
 * @date 2020/06/28
 */
public class BinarySearchTree1 {
    
    /**
     * 将数恢复为二叉搜索树的不同情况
     * 
     * @param num
     *            要恢复的数
     * @return 共有多少种
     */
    public int get(final int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        final int[] dps = new int[num + 1];
        dps[0] = 1;
        dps[1] = 1;
        dps[2] = 2;
        int currentSize;
        boolean flag;
        for (int i = 3, size = num + 1; i < size; i++) {
            flag = (i & 1) == 1;
            for (int j = 1, jSize = (int)Math.ceil(i / 2.0); j <= jSize; j++) {
                currentSize = dps[i - j] * dps[j - 1];
                if (j == jSize && flag) {
                    dps[i] += currentSize;
                    break;
                }
                dps[i] += currentSize * 2;
            }
        }
        return dps[num];
    }
    
    public static void main(String[] args) {
        final BinarySearchTree1 binarySearchTree1 = new BinarySearchTree1();
        System.out.println(binarySearchTree1.get(1));
        System.out.println(binarySearchTree1.get(5));
    }

}
