package com.hyx.dp.string;

import java.util.Arrays;

/**
 * 最短超级串
 * 问： 给定一个字符串数组ss，使用ss中的字符串的子串组成一个字符串s，s中要包含ss中所有的字符串，求s最短为什么
 * 
 * @author sq
 * @date 2020/06/29
 */
public class MinSuperString {
    
    /**
     * 获取超级串
     * 
     * @param strings
     *            要获取的字符串数组
     * @return 超级传
     */
    public String get(final String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }
        if (strings.length == 1) {
            return strings[0];
        }
        final int size = strings.length;
        final int[][] overlaps = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    for (int k = Math.min(strings[i].length(), strings[j].length()); k > -1; k--) {
                        if (strings[i].endsWith(strings[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        final int[][] dp = new int[1 << size][size];
        final int[][] parent = new int[1 << size][size];
        for (int mask = 0; mask < (1 << size); mask++) {
            Arrays.fill(parent[mask], -1);
            for (int bit = 0; bit < size; bit++) {
                if (((mask >> bit) & 1) > 0) {
                    int pmask = mask ^ (1 << bit);
                    if (pmask == 0) {
                        continue;
                    }
                    for (int i = 0; i < size; ++i) {
                        if (((pmask >> i) & 1) > 0) {
                            // For each bit i in pmask, calculate the value
                            // if we ended with word i, then added word 'bit'.
                            int val = dp[pmask][i] + overlaps[i][bit];
                            if (val > dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            }
        }
        int[] perm = new int[size];
        boolean[] seen = new boolean[size];
        int t = 0;
        int mask = (1 << size) - 1;
        // p: the last element of perm (last word written left to right)
        int p = 0;
        for (int j = 0; j < size; j++) {
            if (dp[(1<<size) - 1][j] > dp[(1<<size) - 1][p]) {
                p = j;
            }
        }
        // Follow parents down backwards path that retains maximum overlap
        while (p != -1) {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= 1 << p;
            p = p2;
        }
        // Reverse perm
        for (int i = 0; i < t/2; i++) {
            int v = perm[i];
            perm[i] = perm[t-1-i];
            perm[t-1-i] = v;
        }
        // Fill in remaining words not yet added
        for (int i = 0; i < size; i++) {
            if (!seen[i]) {
                perm[t++] = i;
            }
        }
        final StringBuilder ans = new StringBuilder(strings[perm[0]]);
        for (int i = 1; i < size; i++) {
            int overlap = overlaps[perm[i-1]][perm[i]];
            ans.append(strings[perm[i]].substring(overlap));
        }
        return ans.toString();
    }
    
    public static void main(String[] args) {
        final MinSuperString minSuperString = new MinSuperString();
        System.out.println(minSuperString.get(new String[] {"catg", "ctaagt", "gcta", "ttca", "atgcatc"}));
        System.out.println(minSuperString.get(new String[] {"alex", "loves", "leetcode"}));
    }

}
