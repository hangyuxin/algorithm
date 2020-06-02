package com.hyx.tree.rb;

import java.util.LinkedList;

/**
 * @description 红黑树 
 * 红黑树是每个节点都带有颜色属性的二叉查找树，颜色或红色或黑色,在二叉查找树强制一般要求以外，对于任何有效的红黑树我们增加了如下的额外要求: 
 * 1. 节点是红色或黑色 
 * 2. 根节点是黑色 
 * 3. 所有叶子都是黑色(叶子是NUIL节点) 
 * 4. 每个红色节点的两个子节点都是黑色(从每个叶子到根的所有路径上不能有两个连续的红色节点) 
 * 5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点
 * 
 * @author sq
 * @date 2020/05/30
 * @editDate 2020/05/31
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
            final RedBlackTree<T> redBlackTree = new RedBlackTree<>(this.size * 2);
            redBlackTree.push(this.redBlackTreeNode);
            this.size = redBlackTree.size;
            this.redBlackTreeNode = redBlackTree.redBlackTreeNode;
        }
        RedBlackTreeNode<T> redBlackTreeNode;
        if (this.length == 0) {
            if (val != null) {
                redBlackTreeNode = new RedBlackTreeNode<>(new LinkedList<>(), val.hashCode() & (this.size - 1), null,
                    null, null, RedBlackTree.BLACK);
            } else {
                redBlackTreeNode = new RedBlackTreeNode<>(new LinkedList<T>(), RedBlackTree.NULL_CODE, null, null, null,
                    RedBlackTree.BLACK);
            }
            redBlackTreeNode.getVals().add(val);
            this.redBlackTreeNode = redBlackTreeNode;
            this.length++;
            return;
        }
        int code;
        if (val == null) {
            code = RedBlackTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
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
            RedBlackTreeNode<T> redBlackTreeNode1 = null;
            boolean flag = false;
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
            }
            redBlackTreeNode =
                new RedBlackTreeNode<>(new LinkedList<>(), code, null, null, redBlackTreeNode1, RedBlackTree.RED);
            if (flag) {
                redBlackTreeNode1.setLeftNode(redBlackTreeNode);
            } else {
                redBlackTreeNode1.setRightNode(redBlackTreeNode);
            }
            redBlackTreeNode.getVals().add(val);
            this.fixTree(redBlackTreeNode);
        }
        this.length++;
    }
    
    /**
     * 将一个值从红黑树中移除
     * 
     * @param val
     *            要移除的值
     */
    public void remove(final T val) {
        int code;
        if (val == null) {
            code = RedBlackTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
        }
        RedBlackTreeNode<T> redBlackTreeNode = this.redBlackTreeNode;
        while (redBlackTreeNode != null) {
            if (redBlackTreeNode.getCode() == code) {
                for (final Object object : redBlackTreeNode.getVals()) {
                    if (object == val || (object != null && object.equals(val))) {
                        this.length--;
                        if (redBlackTreeNode.getVals().size() > 2) {
                            redBlackTreeNode.getVals().remove(val);
                            return;
                        } else {
                            this.remove(redBlackTreeNode);
                        }
                    }
                }
                return;
            }
            if (redBlackTreeNode.getCode() > code) {
                redBlackTreeNode = redBlackTreeNode.getLeftNode();
            } else {
                redBlackTreeNode = redBlackTreeNode.getRightNode();
            }
        }
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
            code = RedBlackTree.NULL_CODE;
        } else {
            code = val.hashCode() & (this.size - 1);
        }
        if (this.redBlackTreeNode.getCode() == code) {
            for (final Object object : this.redBlackTreeNode.getVals()) {
                if (object == val || (object != null && object.equals(val))) {
                    return true;
                }
            }
            return false;
        } else {
            RedBlackTreeNode<T> redBlackTreeNode = this.redBlackTreeNode;
            while (redBlackTreeNode != null) {
                if (redBlackTreeNode.getCode() == code) {
                    for (final Object object : redBlackTreeNode.getVals()) {
                        if (object == val || (object != null && object.equals(val))) {
                            return true;
                        }
                    }
                    return false;
                }
                if (redBlackTreeNode.getCode() > code) {
                    redBlackTreeNode = redBlackTreeNode.getLeftNode();
                } else {
                    redBlackTreeNode = redBlackTreeNode.getRightNode();
                }
            }
        }
        return false;
    }

    /**
     * 修正红黑树
     * 
     * @param redBlackTreeNode
     *            从哪个节点开始修复
     */
    private void fixTree(final RedBlackTreeNode<T> redBlackTreeNode) {
        // 如果父节点为黑色，则不用做什么操作
        if (!redBlackTreeNode.getParentNode().getColor()) {
            return;
        }
        RedBlackTreeNode<T> grandFatherNode = redBlackTreeNode.getParentNode().getParentNode();
        RedBlackTreeNode<T> uncleNode;
        if (grandFatherNode.getLeftNode() == redBlackTreeNode.getParentNode()) {
            uncleNode = grandFatherNode.getRightNode();
        } else {
            uncleNode = grandFatherNode.getLeftNode();
        }
        // 如果叔节点和父节点都为红色，则将父节点和叔节点置为黑色，爷爷节点置为红色。如果爷爷节点为最高节点则不置颜色直接退出，如果不为最高节点一直逆推到最高节点
        if (uncleNode != null && uncleNode.getColor()) {
            grandFatherNode.getLeftNode().setColor(RedBlackTree.BLACK);
            grandFatherNode.getRightNode().setColor(RedBlackTree.BLACK);
            if (grandFatherNode.getParentNode() != null) {
                grandFatherNode.setColor(RedBlackTree.RED);
                if (grandFatherNode.getParentNode().getParentNode() != null) {
                    this.fixTree(grandFatherNode);
                }
            }
            return;
        }
        // 判断父节点是否为爷爷节点的左节点
        RedBlackTreeNode<T> sonNode;
        RedBlackTreeNode<T> redBlackTreeNode1 = redBlackTreeNode;
        if (grandFatherNode.getLeftNode() == redBlackTreeNode1.getParentNode()) {
            // 如果插入节点是左节点的话进行右旋
            while (true) {
                if (redBlackTreeNode1.getParentNode().getLeftNode() == redBlackTreeNode1) {
                    redBlackTreeNode1.getParentNode().setColor(RedBlackTree.BLACK);
                    grandFatherNode.setColor(RedBlackTree.RED);
                    sonNode = redBlackTreeNode1.getParentNode().getRightNode();
                    redBlackTreeNode1.getParentNode().setRightNode(grandFatherNode);
                    break;
                }
                grandFatherNode.setLeftNode(redBlackTreeNode1);
                redBlackTreeNode1.getParentNode().setRightNode(redBlackTreeNode1.getLeftNode());
                redBlackTreeNode1.setLeftNode(redBlackTreeNode1.getParentNode());
                redBlackTreeNode1.getParentNode().setParentNode(redBlackTreeNode1);
                redBlackTreeNode1.setParentNode(grandFatherNode);
                redBlackTreeNode1 = redBlackTreeNode1.getLeftNode();
            }
        } else {
            // 如果插入节点为右节点进行左旋
            while (true) {
                if (redBlackTreeNode1.getParentNode().getRightNode() == redBlackTreeNode1) {
                    redBlackTreeNode1.getParentNode().setColor(RedBlackTree.BLACK);
                    grandFatherNode.setColor(RedBlackTree.RED);
                    sonNode = redBlackTreeNode1.getParentNode().getLeftNode();
                    redBlackTreeNode1.getParentNode().setLeftNode(grandFatherNode);
                    break;
                } else {
                    grandFatherNode.setRightNode(redBlackTreeNode1);
                    redBlackTreeNode1.getParentNode().setLeftNode(redBlackTreeNode1.getRightNode());
                    redBlackTreeNode1.setRightNode(redBlackTreeNode1.getParentNode());
                    redBlackTreeNode1.getParentNode().setParentNode(redBlackTreeNode1);
                    redBlackTreeNode1.setParentNode(grandFatherNode);
                    redBlackTreeNode1 = redBlackTreeNode1.getRightNode();
                }
            }
        }
        if (grandFatherNode.getParentNode() == null) {
            this.redBlackTreeNode = redBlackTreeNode1.getParentNode();
        } else {
            if (grandFatherNode.getParentNode().getLeftNode() == grandFatherNode) {
                grandFatherNode.getParentNode().setLeftNode(redBlackTreeNode1.getParentNode());
            } else {
                grandFatherNode.getParentNode().setRightNode(redBlackTreeNode1.getParentNode());
            }
        }
        redBlackTreeNode1.getParentNode().setParentNode(grandFatherNode.getParentNode());
        grandFatherNode.setParentNode(redBlackTreeNode1.getParentNode());
        if (grandFatherNode.getLeftNode() == redBlackTreeNode1.getParentNode()) {
            grandFatherNode.setLeftNode(sonNode);
        } else {
            grandFatherNode.setRightNode(sonNode);
        }
        if (sonNode != null) {
            sonNode.setParentNode(grandFatherNode);
        }
    }

    /**
     * 插入一个节点到树之中
     * 
     * @param treeNode
     *            要插入的节点
     */
    private void push(final RedBlackTreeNode<T> redBlackTreeNode) {
        if (redBlackTreeNode == null) {
            return;
        }
        redBlackTreeNode.getVals().forEach(t -> this.push(t));
        this.push(redBlackTreeNode.getLeftNode());
        this.push(redBlackTreeNode.getRightNode());
    }
    
    /**
     * 从红黑树中移除一个节点
     * 
     * @param redBlackTreeNode
     *            要移除的节点
     */
    private void remove(final RedBlackTreeNode<T> redBlackTreeNode) {
        RedBlackTreeNode<T> removeNode = redBlackTreeNode;
        // 寻找替换节点，也就是真正要删除的节点
        while (removeNode.getLeftNode() != null || removeNode.getRightNode() != null) {
            if (removeNode.getLeftNode() != null) {
                removeNode = removeNode.getLeftNode();
            } else {
                removeNode = removeNode.getRightNode();
            }
        }
        if (removeNode.getParentNode() == null) {
            this.redBlackTreeNode = null;
            return;
        }
        // 如果替换节点的颜色是红色，删除不会影响树，则直接将替换节点拉倒删除节点位置，然后将替换节点颜色变为删除节点的颜色
        if (removeNode.getColor()) {
            // 如果替换节点就是自己，那么直接删除就好
            if (redBlackTreeNode == removeNode) {
                if (removeNode.getParentNode().getLeftNode() == removeNode) {
                    removeNode.getParentNode().setLeftNode(null);
                } else {
                    removeNode.getParentNode().setRightNode(null);
                }
            } else {
                if (removeNode.getParentNode().getLeftNode() == removeNode) {
                    removeNode.getParentNode().setLeftNode(null);
                } else {
                    removeNode.getParentNode().setRightNode(null);
                }
                if (redBlackTreeNode.getParentNode() == null) {
                    this.redBlackTreeNode = removeNode;
                } else {
                    if (redBlackTreeNode.getParentNode().getLeftNode() == redBlackTreeNode) {
                        redBlackTreeNode.getParentNode().setLeftNode(removeNode);
                    } else {
                        redBlackTreeNode.getParentNode().setRightNode(removeNode);
                    }
                }
            }
            removeNode.setLeftNode(redBlackTreeNode.getLeftNode());
            removeNode.setRightNode(redBlackTreeNode.getRightNode());
            removeNode.setParentNode(redBlackTreeNode.getParentNode());
            removeNode.setColor(redBlackTreeNode.getColor());
            return;
        }
        RedBlackTreeNode<T> sibNode;
        // 判断替换节点是否为其父节点的左节点
        if (removeNode.getParentNode().getLeftNode() == removeNode) {
            sibNode = removeNode.getParentNode().getRightNode();
            // 如果兄弟节点是红色，那么将兄弟节点染黑，父节点变红，然后以兄弟节点为中心左旋
            if (sibNode != null && sibNode.getColor()) {
                // TODO
            }
            
        } else {
            sibNode = removeNode.getParentNode().getLeftNode();
            
        }
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
        this.size = size;
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

    public static void main(String[] args) {
        final RedBlackTree<Integer> redBlackTree =
            new RedBlackTree<Integer>(new Integer[] {5, 1, 6, 2, 7, 5, 3, 10, 11, 12, 13, 8, 9, 14, 15, 16, 17, 18});
        final RedBlackTree<Integer> redBlackTree1 =
            new RedBlackTree<Integer>(new Integer[] {5, 6, 7});
        System.out.println(redBlackTree.toString());
    }

    @Override
    public String toString() {
        return "{length=" + length + ", redBlackTreeNode=" + redBlackTreeNode + "}";
    }

}
