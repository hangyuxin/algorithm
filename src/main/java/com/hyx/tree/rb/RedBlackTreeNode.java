package com.hyx.tree.rb;

import java.util.Queue;

/**
 * 红黑树节点
 * 
 * @author sq
 * @date 2020/05/30
 */
class RedBlackTreeNode<T> {

    /**
     * 节点的颜色
     */
    private boolean color;

    /**
     * 节点的值
     */
    private Queue<T> vals;

    /**
     * 节点的code,采用hashCode的方式，由code值来确定每个值的存储位置
     */
    private int code;

    /**
     * 节点的左子节点
     */
    private RedBlackTreeNode<T> leftNode;

    /**
     * 节点的右子节点
     */
    private RedBlackTreeNode<T> rightNode;

    /**
     * 节点的父节点
     */
    private RedBlackTreeNode<T> parentNode;

    public Queue<T> getVals() {
        return vals;
    }

    public void setVals(Queue<T> vals) {
        this.vals = vals;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RedBlackTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RedBlackTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public RedBlackTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(RedBlackTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public RedBlackTreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(RedBlackTreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RedBlackTreeNode(Queue<T> vals, int code, RedBlackTreeNode<T> leftNode, RedBlackTreeNode<T> rightNode,
        RedBlackTreeNode<T> parentNode, boolean color) {
        super();
        this.color = color;
        this.vals = vals;
        this.code = code;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "{color=" + color + ", vals=" + vals.toString()
            + (leftNode == null ? "" : (", leftNode=" + leftNode.toString()))
            + (rightNode == null ? "" : (", rightNode=" + rightNode.toString()))+ "}";
    }

}