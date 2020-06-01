package com.hyx.tree.binary;

import java.util.LinkedList;

/**
 * 二叉树
 * 
 * @author sq
 * @date 2020/05/30
 */
public class BinaryTree<T> {

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
    private BinaryTreeNode<T> treeNode;

    /**
     * 插入值到树之中
     * 
     * @param val
     *            要插入的值
     */
    public void push(T val) {
        if (this.length == this.size) {
            final BinaryTree<T> tree = new BinaryTree<>(this.size * 2);
            tree.push(this.treeNode);
            this.size = tree.size;
            this.treeNode = tree.treeNode;
        }
        BinaryTreeNode<T> treeNode;
        if (this.length == 0) {
            if (val != null) {
                treeNode = new BinaryTreeNode<>(new LinkedList<>(), val.hashCode() & (this.size - 1), null, null, null);
            } else {
                treeNode = new BinaryTreeNode<>(new LinkedList<T>(), BinaryTree.NULL_CODE, null, null, null);
            }
            treeNode.getVals().add(val);
            this.treeNode = treeNode;
            this.length++;
            return;
        }
        int code;
        if (val == null) {
            code = BinaryTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
        }
        if (this.treeNode.getCode() == code) {
            if (val != null) {
                for (final Object object : this.treeNode.getVals()) {
                    if (object.equals(val)) {
                        return;
                    }
                }
                this.treeNode.getVals().add(val);
            }
        } else {
            treeNode = this.treeNode;
            BinaryTreeNode<T> treeNode1 = null;
            boolean flag = false;
            while (treeNode != null) {
                if (treeNode.getCode() == code) {
                    for (final Object object : treeNode.getVals()) {
                        if (object.equals(val)) {
                            return;
                        }
                    }
                    treeNode.getVals().add(val);
                    return;
                }
                treeNode1 = treeNode;
                if (treeNode.getCode() > code) {
                    treeNode = treeNode.getLeftNode();
                    flag = true;
                } else {
                    treeNode = treeNode.getRightNode();
                    flag = false;
                }
            }
            treeNode = new BinaryTreeNode<>(new LinkedList<>(), code, null, null, treeNode1);
            if (flag) {
                treeNode1.setLeftNode(treeNode);
            } else {
                treeNode1.setRightNode(treeNode);
            }
            treeNode.getVals().add(val);
        }
        this.length++;
    }

    /**
     * 插入一个节点到树之中
     * 
     * @param treeNode
     *            要插入的节点
     */
    private void push(final BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        treeNode.getVals().forEach(t -> this.push(t));
        this.push(treeNode.getLeftNode());
        this.push(treeNode.getRightNode());
    }

    /**
     * 判断一个值是否存在于红黑树之中
     * 
     * @param val
     *            要判断的值
     * @return 存在为true，不存在为false
     */
    public boolean isExist(T val) {
        int code;
        if (val == null) {
            code = BinaryTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
        }
        if (this.treeNode.getCode() == code) {
            for (final Object object : this.treeNode.getVals()) {
                if (object == val || (object != null && object.equals(val))) {
                    return true;
                }
            }
            return false;
        } else {
            BinaryTreeNode<T> treeNode = this.treeNode;
            while (treeNode != null) {
                if (treeNode.getCode() == code) {
                    for (final Object object : treeNode.getVals()) {
                        if (object == val || (object != null && object.equals(val))) {
                            return true;
                        }
                    }
                    return false;
                }
                if (treeNode.getCode() > code) {
                    treeNode = treeNode.getLeftNode();
                } else {
                    treeNode = treeNode.getRightNode();
                }
            }
        }
        return false;
    }

    /**
     * 删除树中的val
     * 
     * @param val
     *            要删除的值
     */
    public void remove(final T val) {
        int code;
        if (val == null) {
            code = BinaryTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
        }
        if (this.treeNode.getCode() == code) {
            for (final Object object : this.treeNode.getVals()) {
                if (object == val || (object != null && object.equals(val))) {
                    this.length--;
                    if (this.treeNode.getVals().size() > 2) {
                        this.treeNode.getVals().remove(val);
                        return;
                    } else {
                        this.remove(this.treeNode);
                    }
                }
            }
            return;
        } else {
            BinaryTreeNode<T> treeNode = this.treeNode;
            while (treeNode != null) {
                if (treeNode.getCode() == code) {
                    for (final Object object : treeNode.getVals()) {
                        if (object == val || (object != null && object.equals(val))) {
                            this.length--;
                            if (treeNode.getVals().size() > 2) {
                                treeNode.getVals().remove(val);
                                return;
                            } else {
                                this.remove(treeNode);
                            }
                        }
                    }
                    return;
                }
                if (treeNode.getCode() > code) {
                    treeNode = treeNode.getLeftNode();
                } else {
                    treeNode = treeNode.getRightNode();
                }
            }
        }
    }
    
    /**
     * 移除指定节点
     * 
     * @param binaryTreeNode
     *            要移除的节点
     */
    private void remove(final BinaryTreeNode<T> binaryTreeNode) {
        if (binaryTreeNode.getRightNode() == null) {
            if (binaryTreeNode.getParentNode() == null) {
                this.treeNode = binaryTreeNode.getLeftNode();
                if (binaryTreeNode.getLeftNode() != null) {
                    binaryTreeNode.getLeftNode().setParentNode(null);
                }
            } else {
                if (binaryTreeNode.getLeftNode() != null) {
                    binaryTreeNode.getLeftNode().setParentNode(binaryTreeNode.getParentNode());
                }
                if (binaryTreeNode.getParentNode().getLeftNode() == binaryTreeNode) {
                    binaryTreeNode.getParentNode().setLeftNode(binaryTreeNode.getLeftNode());
                } else {
                    binaryTreeNode.getParentNode().setRightNode(binaryTreeNode.getLeftNode());
                }
            }
            return;
        }
        BinaryTreeNode<T> rightNode = binaryTreeNode.getRightNode();
        while (true) {
            if (rightNode.getLeftNode() != null) {
                rightNode = rightNode.getLeftNode();
            } else {
                if (rightNode.getRightNode() != null) {
                    rightNode = rightNode.getRightNode();
                } else {
                    break;
                }
            }
        }
        if (rightNode.getParentNode().getLeftNode() == rightNode) {
            rightNode.getParentNode().setLeftNode(null);
        } else {
            rightNode.getParentNode().setRightNode(null);
        }
        rightNode.setLeftNode(binaryTreeNode.getLeftNode());
        rightNode.setRightNode(binaryTreeNode.getRightNode());
        if (binaryTreeNode.getParentNode() == null) {
            this.treeNode = rightNode;
            rightNode.setParentNode(null);
        } else {
            rightNode.setParentNode(binaryTreeNode.getParentNode());
        }
    }

    public BinaryTree() {
        this(BinaryTree.INIT_SIZE);
    }

    public BinaryTree(int size) {
        super();
        if (size < 0) {
            size = BinaryTree.INIT_SIZE;
        }
        double num = Math.log(size) / Math.log(2);
        if (num % 1 == 0) {
            size = (int)Math.pow(2, num);
        } else {
            size = (int)Math.pow(2, (int)num + 1);
        }
        this.size = size;
    }

    public BinaryTree(T[] vals) {
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
        return "BinaryTree [length=" + length + ", treeNode=[" + treeNode + "]]";
    }

    public static void main(String[] args) {
        final BinaryTree<Integer> tree = new BinaryTree<Integer>(new Integer[] {5, 1, 6, 2, 7, 5, 3});
        tree.remove(3);
        System.out.println(tree.toString());
    }

}
