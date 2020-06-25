package com.hyx.graph.breadth;

import java.util.LinkedList;
import java.util.List;

/**
 * 图
 * 
 * @author sq
 * @date 2020/06/25
 */
public class Graph<T> {
    
    private T node;
    
    private List<Graph<T>> side;
    
    private int weights;

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public List<Graph<T>> getSide() {
        return side;
    }

    public void setSide(List<Graph<T>> side) {
        this.side = side;
    }

    public int getWeights() {
        return weights;
    }

    public void setWeights(int weights) {
        this.weights = weights;
    }

    public Graph(T node, List<Graph<T>> side, int weights) {
        super();
        this.node = node;
        this.side = side;
        this.weights = weights;
    }
    
    public Graph(T node, int weights) {
        super();
        this.node = node;
        this.weights = weights;
        this.side = new LinkedList<>();
    }

    public Graph(T node) {
        super();
        this.node = node;
        this.side = new LinkedList<>();
    }

    public Graph() {
        super();
        this.side = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Graph [node=" + node + ", side=" + side + "]";
    }
    
}
