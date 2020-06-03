package com.hyx.sort.fast;

import java.util.Arrays;

import com.hyx.sort.SortFunction;

/**
 * 快速排序 选中一个数作为基准数，然后扫描数组，判断小于基数的放在基数的右侧，大于基数的放在左侧，然后将这两组数看为两个数组看为两位数组重复上述动作
 * 
 * @author sq
 * @date 2020/06/02
 */
public class FastSort {

    /**
     * 排序
     * 
     * @param <T>要排序的类型
     * @param arrays
     *            要排序的数组
     * @param sortFunction
     *            对该类型排序的方法
     */
    public <T> void sort(final T[] arrays, final SortFunction<T> sortFunction) {
        if (arrays == null || arrays.length < 2 || sortFunction == null) {
            return;
        }
        this.fastSort(arrays, sortFunction, 0, arrays.length - 1);
    }

    /**
     * 快速排序的核心逻辑代码
     * 
     * @param <T>
     *            要排序的类型
     * @param arrays
     *            要排序的数组
     * @param sortFunction
     *            对该类型排序的方法
     * @param start
     *            排序基数时扫描该数组的起始点
     * @param end
     *            排序基数时扫描该数组的终止点
     */
    private <T> void fastSort(final T[] arrays, final SortFunction<T> sortFunction, final int start, int end) {
        if (start > end) {
            return;
        }
        T tmp = arrays[start];
        int i = start,j = end;
        T tmp1;
        while (i < j) {
            // 找到小于等于基准对象的对象，且位于右侧扫描点前面
            while (sortFunction.sort(tmp, arrays[j]) <= 0 && i < j) {
                j--;
            }
            // 找到大于等于基准对象的对象，且位于左侧侧扫描点后面
            while (sortFunction.sort(tmp, arrays[i]) >= 0 && i < j) {
                i++;
            }
            // 如果将两个对象交换位置
            if (i < j) {
                tmp1 = arrays[j];
                arrays[j] = arrays[i];
                arrays[i] = tmp1;
            }
        }
        arrays[start] = arrays[i];
        arrays[i] = tmp;
        // 将基准点左侧作为数组再次排序
        this.fastSort(arrays, sortFunction, start, j - 1);
        // 将基准点右侧侧作为数组再次排序
        this.fastSort(arrays, sortFunction, j + 1, end);
    }
    
    public static void main(String[] args) {
        final Integer[] arrays = new Integer[] {2, 5, 7, 6, 1, 4, 3, 8, 9, 0};
        final FastSort fastSort = new FastSort();
        fastSort.sort(arrays, new SortFunction<Integer>() {

            @Override
            public int sort(final Integer t1, final Integer t2) {
                return t1 - t2;
            }
        });
        System.out.println(Arrays.toString(arrays));
    }

}