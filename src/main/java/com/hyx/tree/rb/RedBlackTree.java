package com.hyx.tree.rb;

import java.util.LinkedList;

/**
 * 红黑树
 * 
 * @author sq
 * @date 2020/05/30
 */
public class RedBlackTree<T> {

    /**
     * 定义红色节点的颜色为true
     */
    private static final boolean RED = true;

    /**
     * 定义黑色节点的颜色为false
     */
    private static final boolean BLACK = false;

    /**
     * 初始化数的容量
     */
    private static final int INIT_SIZE = 16;

    /**
     * null的code值
     */
    private static final int NULL_CODE = -1;

    /**
     * 该数中所有节点的数量
     */
    private int length;

    /**
     * 该树中最大的容量
     */
    private int size;

    /**
     * 树的第一个节点
     */
    private RedBlackTreeNode<T> redBlackTreeNode;

    /**
     * 插入值到红黑树之中
     * 
     * @param val
     *            要插入的值
     */
    public void push(T val) {
        if (this.length == this.size) {
            // TODO 此处需要扩容
        }
        RedBlackTreeNode<T> redBlackTreeNode;
        if (this.length == 0) {
            if (val != null) {
                redBlackTreeNode = new RedBlackTreeNode<>(new LinkedList<>(), val.hashCode() & this.size, null, null,
                    null, RedBlackTree.BLACK);
            } else {
                redBlackTreeNode = new RedBlackTreeNode<>(new LinkedList<T>(), RedBlackTree.NULL_CODE, null, null, null,
                    RedBlackTree.BLACK);
            }
            this.redBlackTreeNode = redBlackTreeNode;
            this.length++;
            return;
        }
        int code;
        if (val == null) {
            code = RedBlackTree.NULL_CODE;
        } else {
            code = val.hashCode() & this.size;
        }
        if (this.redBlackTreeNode.getCode() == code) {
            if (val != null) {
                for (final Object object : this.redBlackTreeNode.getVals()) {
                    if (object.equals(val)) {
                        return;
                    }
                }
                this.redBlackTreeNode.getVals().add(val);
            }
        } else {
            redBlackTreeNode = this.redBlackTreeNode;
            RedBlackTreeNode<T> redBlackTreeNode1;
            boolean flag;
            while (redBlackTreeNode != null) {
                if (redBlackTreeNode.getCode() == code) {
                    for (final Object object : redBlackTreeNode.getVals()) {
                        if (object.equals(val)) {
                            return;
                        }
                    }
                    redBlackTreeNode.getVals().add(val);
                    return;
                }
                redBlackTreeNode1 = redBlackTreeNode;
                if (redBlackTreeNode.getCode() > code) {
                    redBlackTreeNode = redBlackTreeNode.getLeftNode();
                    flag = true;
                } else {
                    redBlackTreeNode = redBlackTreeNode.getRightNode();
                    flag = false;
                }
                redBlackTreeNode =
                    new RedBlackTreeNode<>(new LinkedList<>(), code, null, null, redBlackTreeNode1, RedBlackTree.BLACK);
                if (flag) {
                    redBlackTreeNode1.setLeftNode(redBlackTreeNode);
                } else {
                    redBlackTreeNode1.setRightNode(redBlackTreeNode);
                }
                redBlackTreeNode.getVals().add(val);
            }
        }
        this.length++;
    }

    /**
     * 判断一个值是否存在于红黑树之中
     * 
     * @param val
     *            要判断的值
     * @return 存在为true，不存在为false
     */
    public boolean isExist(T val) {
        return false;
    }

    public RedBlackTree() {
        this(RedBlackTree.INIT_SIZE);
    }

    public RedBlackTree(int size) {
        super();
        if (size < 0) {
            size = RedBlackTree.INIT_SIZE;
        }
        double num = Math.log(size) / Math.log(2);
        if (num % 1 == 0) {
            size = (int)Math.pow(2, num);
        } else {
            size = (int)Math.pow(2, (int)num + 1);
        }
    }

    public RedBlackTree(T[] vals) {
        this(vals.length);
        if (vals != null && vals.length != 0) {
            for (final T val : vals) {
                this.push(val);
            }
            return;
        }
    }

    @Override
    public String toString() {
        return "RedBlackTree [length=" + length + ", redBlackTreeNode=" + redBlackTreeNode + "]";
    }

}
