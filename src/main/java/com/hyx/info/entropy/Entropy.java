package com.hyx.info.entropy;

/**
 * 信息熵
 * H(X)=-∑{i}P(Xi)㏒bP(Xi)
 * P为X的概率质量函数
 * b为熵的单位(2为bit)
 * 
 * @author sq
 * @date 2020/06/12
 */
public class Entropy {
    
    /**
     * 求出存在size个物体，每个物体statusNum个状态，求出信息熵为多少
     * 
     * @param size
     *            多少个物体，size不可以小于1
     * @param statusNum
     *            每个物体有多少状态
     * @return 信息熵为多少
     */
    public double getHx(int size, int statusNum) {
        size = size < 1 ? 1 : size;
        return -Math.log(1/Math.pow(statusNum, size))/Math.log(2);
    }

}