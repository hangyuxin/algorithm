package com.hyx.backtrack;

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
    
    private int[] rows;
    
    private int size;
    
    public int get() {
        this.backTrack(0, this.rows.length);
        return this.size;
    }
    
    /**
     * 获取最大有多少种摆法
     * @param size 皇后的数量
     * @return 最大的摆法
     */
    private void backTrack(int index, int size) {
        // 如果所有行都排了皇后说明成功执行一次了
        if (index == size) {
            this.size ++;
        } else {
            for (int i = 0; i < size; i++) {
                this.rows[index] = i;
                if (this.place(index)) {
                    this.backTrack(index + 1, size);
                }
            }
        }
    }
    
    private  boolean place(int size) {
        for (int i = 0; i < size; i++) {
            if (this.rows[i] == this.rows[size] || Math.abs(i - size) == Math.abs(this.rows[i] - this.rows[size])) {
                return false;
            }
        }
        return true;
    }

    public NQueen(int size) {
        super();
        this.rows = new int[size];
        this.size = 0;
    }
    
    public static void main(String[] args) {
        final NQueen nQueen = new NQueen(9);
        System.out.println(nQueen.get());
    }
    
}
