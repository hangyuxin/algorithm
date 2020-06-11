package com.hyx.ai.lassify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 朴素贝叶斯分类算法
 * 算法核心：P(B|A)=(P(A|B)*P(B))/P(A)
 * P(类别|特征)=(P(特征|类别)*P(类别))/P(特征)
 * 
 * @author sq
 * @date 2020/06/11
 */
public class NaiveBayesianAlgorithmLassify {
    
    /**
     * 获取这些特征的类别
     * 
     * @param datas
     *            参考数据
     * @param strings
     *            特征
     * @return 具体的类别
     */
    public String get(final Collection<Data> datas, final Collection<String> strings) {
        if (datas == null || datas.size() < 2 || strings == null || strings.isEmpty()) {
            return null;
        }
        final Map<String, Data> map = new HashMap<>();
        Data data2 = null;
        for (final Data data : datas) {
            if (map.containsKey(data.getCategory())) {
                map.get(data.getCategory()).setProbability(map.get(data.getCategory()).getProbability() + 1);
            } else {
                final Data data1 = new Data(data.getCategory(), strings);
                data1.setProbability(1);
                map.put(data.getCategory(), data1);
            }
            if (data2 == null) {
                data2 = data;
                if (data2.getFeature().size() != strings.size()) {
                    return null;
                }
            } else {
                if (data.getFeature().size() != data2.getFeature().size()) {
                    return null;
                }
            }
        }
        final int size = map.size();
        if (size < 2) {
            return null;
        }
        map.forEach((k,v) -> {
            int i = 0;
            double probability = this.getF(datas, i, null, k);
            for (final String feature : v.getFeature()) {
                probability = probability * this.getF(datas, i++, feature, k);
            }
            i = 0;
            double probability1 = 1;
            for (final String feature : v.getFeature()) {
                probability1 = probability1 * this.getF(datas, i++, feature, null);
            }
            v.setProbability(probability/probability1);
        });
        Data data = null;
        String category = null;
        for (final Entry<String, Data> entry : map.entrySet()) {
            if (data == null) {
                data = entry.getValue();
                category = entry.getKey();
            } else {
                if (entry.getValue().getProbability() > data.getProbability()) {
                    data = entry.getValue();
                    category = entry.getKey();
                }
            }
        }
        return category;
    }
    
    /**
     * 如果两个参数都不为null求P(feature | category)，如果category为null求p(feature),如果feature为null就p(category)
     * 
     * @param features
     *            参考数据
     * @param 特征的下标
     * @param feature
     *            特征
     * @param category
     *            类别
     * @return p
     */
    private double getF(final Collection<Data> datas, final int index, final String feature, final String category) {
        double num = 0;
        if (feature == null) {
            double size = 0;
            for (final Data data : datas) {
                if (category.equals(data.getCategory())) {
                    size++;
                }
            }
            return size / datas.size();
        }
        if (category == null) {
            for (final Data data : datas) {
                num +=  feature.equals(data.getFeature().toArray()[index]) ? 1 : 0;
            }
            return num / datas.size();
        } else {
            double size = 0;
            for (final Data data : datas) {
                if (category.equals(data.getCategory())) {
                    size++;
                    num += feature.equals(data.getFeature().toArray()[index]) ? 1 : 0;
                }
            }
            return num / size;
        }
        
    }
    
    @SuppressWarnings("serial")
    public static void main(String[] args) {
        System.out.println(new NaiveBayesianAlgorithmLassify().get(new ArrayList<Data>() {{
            add(new Data("不嫁", new ArrayList<String>() {{
                add("帅"); add("不好"); add("矮"); add("不上进");
            }}));
            add(new Data("不嫁", new ArrayList<String>() {{
                add("不帅"); add("好"); add("矮"); add("上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("帅"); add("好"); add("高"); add("不上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("帅"); add("好"); add("高"); add("上进");
            }}));
            add(new Data("不嫁", new ArrayList<String>() {{
                add("帅"); add("不好"); add("矮"); add("上进");
            }}));
            add(new Data("不嫁", new ArrayList<String>() {{
                add("不帅"); add("不好"); add("矮"); add("不上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("帅"); add("好"); add("高"); add("不上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("不帅"); add("好"); add("矮"); add("上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("帅"); add("好"); add("高"); add("上进");
            }}));
            add(new Data("嫁", new ArrayList<String>() {{
                add("不帅"); add("不好"); add("高"); add("上进");
            }}));
            add(new Data("不嫁", new ArrayList<String>() {{
                add("帅"); add("好"); add("矮"); add("不上进");
            }}));
            add(new Data("不嫁", new ArrayList<String>() {{
                add("帅"); add("不好"); add("矮"); add("不上进");
            }}));
        }}, new ArrayList<String>() {{
            add("不帅"); add("好"); add("矮"); add("不上进");
        }}));
    }
    
    /**
     * 特征类
     * 
     * @author sq
     * @date 2020/06/11
     */
    static class Data{
        
        private String category;
        
        private Collection<String> feature;
        
        private double probability;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Collection<String> getFeature() {
            return feature;
        }

        public void setFeature(Collection<String> feature) {
            this.feature = feature;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        public Data(String category, Collection<String> feature) {
            super();
            this.category = category;
            this.feature = feature;
        }

        public Data() {
            super();
        }

    }

}
