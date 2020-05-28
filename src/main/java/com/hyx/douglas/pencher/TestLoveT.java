package com.hyx.douglas.pencher;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 道格拉斯抽稀算法实现类，文件中提供的坐标格式必须为：id,经度,维度
 * @author sq
 * @date 2020/05/26
 */
public class TestLoveT {

	public static void main(String[] args) {
		TestLoveT testLoveT = new TestLoveT();
		InputFile inputFile = new InputFile(new File(""), Charset.forName("GBK"));
        try {
            final List<LngLats> lngLats = new LinkedList<>();
            inputFile.readFileCSV().forEach(s -> {
                final String[] arr = s.split(",");
                final LngLats lngLats2 = new LngLats();
                lngLats2.setStartingDistance(Double.valueOf(arr[0]));
                lngLats2.setLat(Double.valueOf(arr[2]));
                lngLats2.setLng(Double.valueOf(arr[1]));
                lngLats.add(lngLats2);
            });
            System.out.println(testLoveT.douglasPeukcer(lngLats, 0.00005).toString());
        } catch (IOException e) {
             e.printStackTrace();
        }
	}

    /**
     * 抽稀算法，对传入的坐标点进行抽稀，抽稀的标准为给定的公差
     * 
     * @param lngLats
     *            要抽稀的坐标点
     * @param dmax
     *            最小公差
     * @return 抽稀后的坐标点
     */
	private List<LngLats> douglasPeukcer(List<LngLats> lngLats, Double dmax) {
		final Map<Character, Double> map = this.minVerticalDistance(lngLats);
		if (map.get('B') != null) {
			if (map.get('B') < dmax) {
				for (int i = 1; i < lngLats.size()-1;) {
				    // 此处因为传入的是初始集合的镜像分割，所以必须调用remove，不可以用clear
					lngLats.remove(i);
				}
			} else {
			    this.douglasPeukcer(lngLats.subList(map.get('A').intValue(), lngLats.size()), dmax);
			    this.douglasPeukcer(lngLats.subList(0, map.get('A').intValue()), dmax);
			}
		}
		return lngLats;
	}

    /**
     * 计算点到线的最小垂距
     * 
     * @param lngLats
     *            经纬点集合
     * @return A-最大垂距的坐标点处于集合中的位置.B-最大垂距的长度
     */
	public Map<Character, Double> minVerticalDistance(List<LngLats> lngLats) {
		final int size = lngLats.size();
		// lng--经度*******lat--纬度
		// 最大的垂距的位置
		final Map<Character, Double> map = new HashMap<Character, Double>(2);
		if (size > 2) {
			// 起点A到O点的X
			double aOX = lngLats.get(0).getLng() - lngLats.get(size - 1).getLng();
			// 终点B到O点的Y
			double bOY = lngLats.get(size - 1).getLat() - lngLats.get(0).getLat();
			// 起点与终点的距离
			double beginEndDistance = Math.sqrt(Math.pow(aOX, 2) + Math.pow(bOY, 2));
			// 起点与终点的直线的夹角(∠ABO)
			double beginEndRadius = Math.asin(aOX / beginEndDistance);
			// 最大垂距的位置
			map.put('A', 0.0);
			// 最大垂距的长度
			map.put('B', 0.0);
			for (int i = 1; i < size - 1; i++) {
				// 当前点D到O的X
				double dOX = lngLats.get(i).getLng() - lngLats.get(size - 1).getLng();
				// 当前点D到终点B的Y
				double dBY = lngLats.get(i).getLat() - lngLats.get(size - 1).getLat();
				// 终点到当前点的距离
				double beginCurrentDistance = Math.sqrt(Math.pow(dOX, 2) + Math.pow(dBY, 2));
				// ∠DAB
				double dABRadius = Math.abs(Math.asin(dOX / beginCurrentDistance) - beginEndRadius);
				// 当前点的垂距
				double d = Math.sin(dABRadius) * beginCurrentDistance;
				if (d > map.get('B')) {
					map.put('B', d);
					map.put('A', Double.valueOf(i));
				}
			}
		}
		return map;
	}

}
