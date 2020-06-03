package com.hyx.tree.binary;

import java.util.ArrayList;
import java.util.List;

import com.hyx.sort.SortFunction;

/**
 * 最大顶二叉树 树的最高节点最大,树的子节点小于或等于父节点
 * 
 * @author sq
 * @date 2020/06/03
 */
public class MaxTopBinaryTree<T> {

    private List<T> arrays;

    private final SortFunction<T> sortFunction;

    /**
     * 将元素添加到树中，可以添加相同元素
     * 
     * @param val
     *            要添加的元素
     */
    public void push(final T val) {
        if (this.arrays == null) {
            this.arrays = new ArrayList<>(16);
        }
        this.arrays.add(val);
        this.fireUpTree(this.arrays.size() - 1);
    }

    /**
     * 获取树的最高节点，且删除这个节点
     * 
     * @return 最高节点的元素
     */
    public T pool() {
        if (this.arrays == null) {
            return null;
        }
        T t = this.arrays.get(0);
        this.swap(0, this.arrays.size() - 1);
        this.arrays.remove(this.arrays.size() - 1);
        if (this.arrays.size() < 2) {
            if (this.arrays.isEmpty()) {
                this.arrays = null;
            }
            return t;
        }
        this.fireDownTree(0);
        return t;
    }

    /**
     * 获取树的最高节点
     * 
     * @return 最高节点的元素
     */
    public T peek() {
        if (this.arrays != null) {
            return this.arrays.get(0);
        }
        return null;
    }

    /**
     * 从传入位置开始修正树，向上修正
     * 
     * @param index
     *            从哪个节点开始修复
     */
    private void fireUpTree(int index) {
        int parentIndex = this.parentIndex(index);
        while (index > 0 && this.sortFunction.sort(this.arrays.get(parentIndex), this.arrays.get(index)) < 0) {
            this.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = this.parentIndex(index);
        }
    }
    
    /**
     * 从传入位置开始修正树，向下修正
     * 
     * @param index
     *            从哪个节点开始修复
     */
    private void fireDownTree(int index) {
        int leftChildIndex = this.leftChildIndex(index);
        while (leftChildIndex < this.arrays.size()) {
            if (leftChildIndex + 1 < this.arrays.size() && this.sortFunction.sort(this.arrays.get(leftChildIndex + 1), this.arrays.get(leftChildIndex)) > 0) {
                leftChildIndex++;
            }
            if (this.sortFunction.sort(this.arrays.get(index), this.arrays.get(leftChildIndex)) >= 0) {
                break;
            }
            this.swap(index, leftChildIndex);
            index = leftChildIndex;
            leftChildIndex = this.leftChildIndex(index);
        }
    }

    /**
     * 获取该下标元素的父元素下标
     * 
     * @param index
     *            要获取元素的下标
     * @return 父元素的下标
     */
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
    
    /**
     * 获取该下标元素的左子节点元素下标
     * 
     * @param index
     *            要获取元素的下标
     * @return 父元素的下标
     */
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }
    
    /**
     * 获取该下标元素的右子节点元素下标
     * 
     * @param index
     *            要获取元素的下标
     * @return 父元素的下标
     */
    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    /**
     * 将两位位置的元素交换位置
     * 
     * @param i
     *            i
     * @param j
     *            j
     */
    private void swap(int i, int j) {
        T t = this.arrays.get(i);
        this.arrays.set(i, this.arrays.get(j));
        this.arrays.set(j, t);
    }

    public MaxTopBinaryTree(SortFunction<T> sortFunction) {
        this.sortFunction = sortFunction;
    }

    public MaxTopBinaryTree(final T[] vals, SortFunction<T> sortFunction) {
        this(sortFunction);
        for (final T val : vals) {
            this.push(val);
        }
    }
    
    public static void main(String[] args) {
        MaxTopBinaryTree<Integer> maxTopBinaryTree = new MaxTopBinaryTree<>(new Integer[] {2, 5, 7, 6, 1, 4, 3, 8, 9, 0},  new SortFunction<Integer>() {

            @Override
            public int sort(final Integer t1, final Integer t2) {
                return t1 - t2;
            }
        });
        System.out.println(maxTopBinaryTree.toString());
        maxTopBinaryTree.pool();
        System.out.println(maxTopBinaryTree.toString());
    }

    @Override
    public String toString() {
        return "MaxTopBinaryTree {arrays=" + this.arrays + "}";
    }

}
