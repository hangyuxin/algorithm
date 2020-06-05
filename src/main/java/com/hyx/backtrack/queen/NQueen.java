package com.hyx.backtrack.queen;

/**
 * N皇后问题：求在一个N*N的棋盘上，摆放N个皇后旗子，同时使所有皇后彼此之间都无法相互攻击
 * 皇后： （英文：Queen） 是国际象棋棋局中实力最强的一种棋子，可横直斜走，且格数不限，吃子与走法相同。
 * 解： 使用回溯法，在第一层的第一个节点下一个皇后，因为皇后可以横向冲杀，所以一层只可以存在一个节点
 * 此时前往第二层去下皇后，找到第一个不被所有上层皇后吃 的节点将皇后下下，然后前往下一层
 * 如果某一层找不到可以下的节点，将上一层的皇后向右推向下一个可以下的节点，如果父元素已经在最右边的节点，那么将爷爷元素向右推，父元素回归最左，如此反复
 * @author sq
 * @date 2020/06/04
 */
public class NQueen {
    
    /**
     * 获取N个皇后最多几种解法
     * 
     * @param size
     *            皇后的个数
     * @return 解法的个数
     */
    public int get(int size) {
        if (size < 4) {
            return 0;
        }
        return this.backTrack(new int[size]);
    }
    
    /**
     * 回溯判断具体有多少种解法
     * 
     * @param arrays
     *            放皇后的数组
     * @return 具体的解法
     */
    private int backTrack(final int[] arrays) {
        int num = 0;
        int num1 = 0;
        int size = arrays.length;
        // 这里进行剪枝，因为棋盘是对称的，所以只计算一半
        int maxSize = (int)Math.ceil(size / 2.0) - 1;
        // 判断如果是奇数棋盘，那么最中心的那一列不会*2
        boolean isEven = size % 2 != 0;
        for (int i = 0,j = 0; i < size && arrays[0] <= maxSize;) {
            boolean flag = false;
            for (; j < size; j++) {
                arrays[i] = j;
                if (this.isDrop(arrays, i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if (i == size  - 1) {
                    if (isEven && arrays[0] == maxSize) {
                        num1++;
                    } else {
                        num++;
                    }
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            } else {
                i--;
                j = arrays[i] + 1;
            }
        }
        return num * 2 + num1;
    }
    
    /**
     * 判断当前位置是否可以放下皇后
     * 
     * @param arrays
     *            存放皇后位置的数组
     * @param index
     *            当前皇后所在的数组下标
     * @return 是否可以
     */
    private boolean isDrop(final int[] arrays, final int index) {
        for (int i = 0; i < index; i++) {
            // 如果当前皇后的位置和某一排皇后的位置一样或者处于对角线位置就不可以放下
            if (arrays[i] == arrays[index] || Math.abs(index - i) == Math.abs(arrays[i] - arrays[index])) {
                return false;
            }
        }
        return true;
    }

    public NQueen() {
        super();
    }
    
    public static void main(String[] args) {
        final NQueen nQueen = new NQueen();
        int num = 7;
        System.out.println(nQueen.get(num));
    }
    
}
