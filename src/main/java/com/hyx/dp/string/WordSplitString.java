package com.hyx.dp.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 单词拆分
 * 问：给定一个字符串s，一个字符串数组ss，求s是否可以拆分为ss中的单词，ss中的单词可以重复使用，s中的字符不可以重复使用
 * 
 * @author sq
 * @date 2020/06/30
 */
public class WordSplitString {
    
    /**
     * 获取字符串是否为字符串数组的组合
     * 
     * @param string要检查的字符串
     * @param strings
     *            给定的字符串数组
     * @return 是否有数组中的字符串组合而成
     */
    public boolean get(final String string, final String[] strings) {
        if (string == null || strings == null || strings.length == 0) {
            return false;
        }
        if (string.isEmpty()) {
            for (int i = 0, size = strings.length; i < size; i++) {
                if (strings[i] != null && strings[i].isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        final boolean[] dps = new boolean[string.length() + 1];
        final Set<String> set = new HashSet<>(strings.length);
        for (final String string2 : strings) {
            if (string2 != null && !string2.isEmpty()) {
                set.add(string2);
            }
        }
        dps[0] = true;
        for (int i = 1, size = string.length() + 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (dps[j] && set.contains(string.substring(j, i))) {
                    dps[i] = true;
                    break;
                }
            }
        }
        return dps[string.length()];
    }
    
    public static void main(String[] args) {
        final WordSplitString wordSplitString = new WordSplitString();
        System.out.println(wordSplitString.get("leetcode", new String[] {"leet", "code"}));
        System.out.println(wordSplitString.get("leetcodeleet", new String[] {"leet", "code"}));
        System.out.println(wordSplitString.get("leetscodeleet", new String[] {"leet", "scodel"}));
    }

}
