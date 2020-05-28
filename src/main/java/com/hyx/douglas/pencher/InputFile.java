package com.hyx.douglas.pencher;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

/**
 * 加载文件类
 * @author sq
 * @date 2020/05/26
 */
public class InputFile {

	private File file;
	
	private Charset charset;

    /**
     * 读取csv文件，按行读取
     * 
     * @return csv文件的内容
     * @throws IOException
     *             文件读取错误
     */
	public List<String> readFileCSV() throws IOException {
		final List<String> list = new LinkedList<>();
		//以缓存输入流读取数据，以GBK的编码阅读
		try (final BufferedReader bufferedReader = Files.newBufferedReader(this.file.toPath(), this.charset)) {
			//逐行读取
			while (bufferedReader.ready()) {
				list.add(bufferedReader.readLine());
			}
		}
		return list;
	}

    public InputFile(File file, Charset charset) {
        super();
        this.file = file;
        this.charset = charset;
    }

}
