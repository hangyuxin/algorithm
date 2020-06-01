package com.hyx.find.kmp;

/**
 * kmp算法，在一个字符串中查找是否存在另一个字符串
 * 从开始依次匹配
 * 1. 如果成功，源字符串下标和目标字符串下标皆+1
 * 2. 如果失败，源字符串下标保持不动，将目标字符串下标+(当前目标字符串下标-next[当前目标字符串下标])
 * 3. next[0] = -1;next[n] = (从自己之前开始逆推)与(字符串开始作为结束逆推)相等的最大长度
 * 
 * @author sq
 * @date 2020/06/01
 */
public class KmpFind {

    /**
     * 在给定的字符串中查找是否存在另一个字符串，存在返回字符串的起始位置，不存在返回-1
     * 
     * @param source
     *            从哪里查找
     * @param target
     *            具体查找的字符串
     * @return 是否存在
     */
    public int indexOf(final String source, final String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.isEmpty()) {
            if (target.isEmpty()) {
                return 0;
            } else {
                return -1;
            }
        }
        if (target.isEmpty()) {
            return -1;
        }
        final char[] sourceChars = source.toCharArray();
        final char[] targetChars = target.toCharArray();
        final int[] nexts = this.getNexts(targetChars);
        int i = 0, j = 0, iSize = sourceChars.length, jSize = targetChars.length;
        while (i < iSize && j < jSize) {
            if (j == -1 || sourceChars[i] == targetChars[j]) {
                i++;
                j++;
            } else {
                j = nexts[j];
            }
        }
        if (j == jSize) {
            return i - j;
        }
        return -1;
    }

    /**
     * 求出给定字符串的回文串长度
     * 
     * @param targetChars
     *            要求的字符串的char数组
     * @return 每个位置的回文长度
     */
    private int[] getNexts(final char[] targetChars) {
        int length = targetChars.length;
        final int[] nexts = new int[length];
        int k = -1;
        nexts[0] = k;
        for (int i = 0, size = length - 1; i < size;) {
            if (k == -1 || targetChars[i] == targetChars[k]) {
                k++;
                i++;
                nexts[i] = k;
            } else {
                k = nexts[k];
            }
        }
        return nexts;
    }
    
    public static void main(String[] args) {
        KmpFind kmpFind = new KmpFind();
        System.out.println(kmpFind.indexOf("1234567891234156", "12341"));
    }

}
