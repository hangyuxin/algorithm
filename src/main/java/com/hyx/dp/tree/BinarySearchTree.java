package com.hyx.dp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.hyx.tree.binary.BinaryTreeNode;

/**
 * 恢复二差搜索树
 * 问：给定一个整数，将该数恢复成二叉搜索树，求最多可以恢复出多少种
 * 
 * @author sq
 * @date 2020/06/28
 */
public class BinarySearchTree {
    
    /**
     * 将数恢复为二叉搜索树
     * 
     * @param num
     *            要恢复的数
     * @return 恢复好的数组
     */
    public List<BinaryTreeNode<Integer>> get(final int num) {
        if (num < 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        final List<BinaryTreeNode<Integer>>[] dps = new List[num + 1];
        dps[0] = new ArrayList<>();
        if (num == 0) {
            return dps[0];
        }
        dps[0].add(null);
        int left, right;
        for (int i = 1; i <= num; i++) {
            dps[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                left = j - 1;
                right = i - j;
                for (final BinaryTreeNode<Integer> leftTreeNode : dps[left]) {
                    for (final BinaryTreeNode<Integer> rightTreeNode : dps[right]) {
                        final BinaryTreeNode<Integer> binaryTreeNode =
                            new BinaryTreeNode<>(new LinkedList<>(), 0, null, null, null);
                        binaryTreeNode.getVals().add(j);
                        binaryTreeNode.setLeftNode(leftTreeNode);
                        binaryTreeNode.setRightNode(this.cloneTree(rightTreeNode, j));
                        dps[i].add(binaryTreeNode);
                    }
                }
                
            }
        }
        return dps[num];
    }
    
    private BinaryTreeNode<Integer> cloneTree(final BinaryTreeNode<Integer> binaryTreeNode, final int j) {
        if (binaryTreeNode == null) {
            return binaryTreeNode;
        }
        final BinaryTreeNode<Integer> binaryTreeNode1 =
            new BinaryTreeNode<>(new LinkedList<>(), 0, null, null, null);
        final Integer poll = binaryTreeNode.getVals().peek();
        binaryTreeNode1.getVals().add(poll ==  null ? 0 : poll + j);
        binaryTreeNode1.setLeftNode(this.cloneTree(binaryTreeNode.getLeftNode(), j));
        binaryTreeNode1.setRightNode(this.cloneTree(binaryTreeNode.getRightNode(), j));
        return binaryTreeNode1;
    }

    public static void main(String[] args) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.get(4).forEach(System.out  :: println);
        System.out.println(binarySearchTree.get(5).size());
    }

}
