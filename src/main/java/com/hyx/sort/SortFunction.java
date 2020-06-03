package com.hyx.sort;

/**
 * 排序方法
 * 
 * @author sq
 * @date 2020/06/02
 */
public interface SortFunction<T> {

    /**
     * 传入两个参数，判断哪一个大
     * 
     * @param t1
     *            第一个数
     * @param t2
     *            第二个数
     * @return 如果t1大返回正数，t2大返回负数，相等返回0
     */
    int sort(T t1, T t2);

}
