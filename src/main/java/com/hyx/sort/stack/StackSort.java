package com.hyx.sort.stack;

import java.util.Arrays;

import com.hyx.sort.SortFunction;
import com.hyx.tree.binary.MaxTopBinaryTree;

/**
 * 堆排序 将给定的数组排为一个完全二叉树，树的定义如下： 1. 树的顶端为最大值，树的节点大于或等于子节点or树的顶端为最小值，树的节点小于或等于子节点
 * 
 * @author sq
 * @date 2020/06/03
 */
public class StackSort {

    /**
     * 排序
     * 
     * @param <T>要排序的类型
     * @param arrays
     *            要排序的数组
     * @param sortFunction
     *            对该类型排序的方法
     */
    public <T> void sort(final T[] arrays, final SortFunction<T> sortFunction) {
        if (arrays == null || arrays.length < 2 || sortFunction == null) {
            return;
        }
        final MaxTopBinaryTree<T> maxTopBinaryTree = new MaxTopBinaryTree<>(arrays, sortFunction);
        int i = 0;
        while (true) {
            final T t = maxTopBinaryTree.pool();
            if (t == null) {
                return;
            }
            arrays[i++] = t;
        }
    }
    
    public static void main(String[] args) {
        final StackSort stackSort = new StackSort();
        final Integer[] arrays = new Integer[] {2, 5, 7, 6, 1, 4, 3, 8, 9, 0};
        stackSort.sort(arrays,  new SortFunction<Integer>() {

            @Override
            public int sort(final Integer t1, final Integer t2) {
                return t1 - t2;
            }
        });
        System.out.println(Arrays.toString(arrays));
    }

}