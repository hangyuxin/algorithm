package com.hyx.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的节点
 * 
 * @author sq
 * @date 2020/05/30
 */
public class BinaryTreeNode<T> {

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
    private BinaryTreeNode<T> leftNode;

    /**
     * 节点的右子节点
     */
    private BinaryTreeNode<T> rightNode;

    /**
     * 节点的父节点
     */
    private BinaryTreeNode<T> parentNode;

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

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public BinaryTreeNode(Queue<T> vals, int code, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode, BinaryTreeNode<T> parentNode) {
        super();
        this.vals = new LinkedList<T>();
        this.code = code;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "{vals=" + vals.toString() + (leftNode == null ? "" : (", leftNode=" + leftNode.toString()))
            + (rightNode == null ? "" : (", rightNode=" + rightNode.toString())) + "}";
    }

}
