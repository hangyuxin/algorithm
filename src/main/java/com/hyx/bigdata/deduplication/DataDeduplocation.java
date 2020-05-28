package com.hyx.bigdata.deduplication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * 数据去重，要去重的数据，多次读取不可以改变顺序
 * 
 * @author sq
 * @date 2020/05/26
 */
public class DataDeduplocation {

    /**
     * 储存数据信息的数组，第二维数组中第一个元素存储当前数组的数据数量
     */
    private long[][] values;

    /**
     * 数组的最大值
     */
    private int arraySize;

    /**
     * 当前数组存储的数据
     */
    private int currentSize = 0;

    /**
     * 储存数据信息的文件集合
     */
    private final List<Path> paths;

    private static final Gson GSON = new Gson();

    private static String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        final DataDeduplocation deduplocation = new DataDeduplocation(2000000);
        for (int i = 1, arraySize = 2000000001; i < arraySize; i++) {
            deduplocation.push(String.valueOf(i).hashCode(), i);
        }
    }

    /**
     * 加载数据的hashCode， 和数据所处位置
     * 
     * @param hashCode
     *            数据的hashCode
     * @param size
     *            数据所处位置
     * @throws IOException
     *             创建存储数据的信息的文件失败
     */
    private void push(final int hashCode, final long size) throws IOException {
        this.currentSize++;
        final int num = hashCode & this.arraySize;
        long[] arrays = this.values[num];
        if (arrays == null) {
            arrays = new long[16];
            arrays[0] = 1;
            this.values[num] = arrays;
        }
        if (arrays[0] == arrays.length) {
            long[] newArrays = new long[arrays.length * 2];
            System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
            arrays = newArrays;
            this.values[num] = arrays;
        }
        arrays[(int)arrays[0]] = size;
        arrays[0] = arrays[0] + 1;
        if (this.currentSize > this.arraySize) {
            final Path path = Files.createFile(Paths.get("D:\\works\\test", UUID.randomUUID().toString() + ".txt"));
            this.paths.add(path);
            try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
                final StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0, arraySize = this.values.length; i < arraySize; i++) {
                    arrays = this.values[i];
                    if (arrays != null) {
                        stringBuilder.append('{');
                        stringBuilder.append(i);
                        stringBuilder.append(':');
                        stringBuilder.append('\'');
                        stringBuilder.append(DataDeduplocation.GSON.toJson(arrays));
                        stringBuilder.append('\'');
                        stringBuilder.append('}');
                        bufferedWriter.write(stringBuilder.toString());
                        stringBuilder.setLength(0);
                        stringBuilder.append(DataDeduplocation.NEW_LINE);
                    }
                }
                bufferedWriter.flush();
            }
            this.currentSize = 0;
            this.values = new long[this.arraySize + 1][];
        }
    }

    /**
     * 如果存在存储数据信息文件,将存储数据信息的文件合并为一个文件
     * 
     * @throws IOException
     *             合并文件失败
     */
    private void fileMerge() throws IOException {
        if (this.paths.isEmpty()) {
            return;
        }
    }

    public DataDeduplocation(int arraySize) {
        if (arraySize < 0 || arraySize > (Integer.MAX_VALUE - 2)) {
            throw new RuntimeException(arraySize + "too big");
        }
        this.arraySize = arraySize - 1;
        this.values = new long[arraySize][];
        this.paths = new LinkedList<>();
    }

}
