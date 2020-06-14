package com.hyx.dp.table;

/**
 * 骑士拯救公主
 * 问： 某一个公主被魔王困于地下城中，一个骑士要去拯救公主，给定一个矩阵，每个元素代表一个房间，公主在最后一排最后一列的房间中，
 * 骑士从第一排第一列出发，每个房间中的数字代表骑士进入该房间会增加的血量，当骑士血量=0时骑士会死亡，求骑士救出公主最低所需初始血量
 * 
 * @author sq
 * @date 2020/06/14
 */
public class KnightSavesThePrincess {
    
    /**
     * 获取最小血量
     * 
     * @param arrays
     *            要穿越的地下城
     * @return 最小的血量
     */
    public int get(final int[][] arrays) {
        {
            if (arrays == null || arrays.length == 0 || arrays[0] == null  || arrays[0].length == 0) {
                return 0;
            }
            int size = arrays[0].length;
            for (final int[] array : arrays) {
                if (array == null || size != array.length) {
                    return 0;
                }
            }
        }
        final int[][] results = new int[arrays.length][arrays[0].length];
        results[0][0] = arrays[0][0] > 0 ? 1 : Math.abs(arrays[0][0]) + 1;
        for (int i = 1, size = arrays[0].length; i < size; i++) {
            if (arrays[0][i] >= 0) {
                results[0][i] = results[0][i - 1];
            } else {
                if (results[0][i - 1] + arrays[0][i] > 0) {
                    results[0][i] = results[0][i - 1];
                } else {
                    results[0][i] = results[0][i - 1] - arrays[0][i];
                }
            }
        }
        for (int i = 1, size = arrays.length; i < size; i++) {
            if (arrays[i][0] >= 0) {
                results[i][0] = results[i - 1][0];
            } else {
                if (results[i - 1][0] + arrays[i][0] > 0) {
                    results[i][0] = results[i - 1][0];
                } else {
                    results[i][0] = results[i - 1][0] - arrays[i][0];
                }
            }
        }
        int min;
        int max;
        for (int i = 1, size = arrays[0].length; i < size; i++) {
            for (int j = 1, sizeJ = arrays[i].length; j < sizeJ; j++) {
                min = Math.min(results[i - 1][j], results[i][j - 1]);
                if (arrays[i][j] >= 0) {
                    results[i][j] = min;
                } else {
                    if (min + arrays[i][j] > 0) {
                        results[i][j] = min;
                    } else {
                        max = Math.max(results[i - 1][j], results[i][j - 1]);
                        if (max + arrays[i][j] > 0) {
                            if (max > (min - arrays[i][j])) {
                                results[i][j] = min - arrays[i][j];
                            } else {
                                results[i][j] = max;
                            }
                        } else {
                            results[i][j] = min - arrays[i][j];
                        }
                    }
                }
            }
        }
        return results[arrays.length - 1][arrays[0].length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new KnightSavesThePrincess().get(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }

}
