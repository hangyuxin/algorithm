package com.hyx.dp.downstairs;

/**
 * 问：
 * 现有一只青蛙frog，frog每次可以跳上 1层台阶或者2层台阶，问当有 n层台阶时frog共有多少种方式跳上去
 * 解：
 * frog跳到第2层台阶时，frog只有两种跳法：
 * 1. 从第1层调过来
 * 2. 从第0层跳过来
 * 同理可得frog跳到第i层台阶时也只有两种：
 * 1. 从第i-1层调过来
 * 2. 从第i-2层跳过来
 * 由上可证，frog调到第n=层的方法F(n)=F(n-1)+(n-2)
 * @author sq
 * @date 2020/06/06
 */
public class FrogUpstairs {
    
    /**
     * 获取青蛙跳到指定层数的跳法，如果传入 层数小于0返回-1中跳法
     * 
     * @param numLayers
     *            具体指定的层数，不可以小于 0
     * @return 共有多少种跳法
     */
    public long getFunctionSize(final int numLayers) {
        if (numLayers < 0) {
            return -1;
        }
        if (numLayers == 0) {
            return 0;
        }
        final long[] arrays = new long[numLayers + 1];
        for (int i = 1; i < 3 && i <= numLayers; i++) {
            arrays[i] = i;
        }
        for (int i = 3; i <= numLayers; i++) {
            arrays[i] = arrays[i - 1] + arrays[i - 2];
        }
        return arrays[numLayers];
    }
    
    public static void main(String[] args) {
        final FrogUpstairs frogUpstairs = new FrogUpstairs();
        System.out.println(frogUpstairs.getFunctionSize(0));
        System.out.println(frogUpstairs.getFunctionSize(1));
        System.out.println(frogUpstairs.getFunctionSize(2));
        System.out.println(frogUpstairs.getFunctionSize(3));
        System.out.println(frogUpstairs.getFunctionSize(5));
        System.out.println(frogUpstairs.getFunctionSize(18));
        System.out.println(frogUpstairs.getFunctionSize(19));
        System.out.println(frogUpstairs.getFunctionSize(20));
        System.out.println(frogUpstairs.getFunctionSize(100));
    }

}
