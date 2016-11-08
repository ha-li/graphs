package com.gecko.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hlieu on 11/5/16.
 */
public class GraphTest {

    //@Test
    public void test_graph() {
        Graph g = new Graph(4);
        //g.addEdge(0, 1);
        //g.addEdge(0, 2);
        //g.addEdge(0, 3);
    }

    @Test
    public void test_graph_bfs() {
        Graph g = new Graph(4);
        //g.addEdge(0, 1);
        //g.addEdge(0, 2);
        //g.addEdge(0, 3);
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);

        g.connect(0, 1);
        g.connect(0, 2);
        //g.connect(0, 3);
        g.bfs(2);
        g.print_bfs(3, 1);
    }
}