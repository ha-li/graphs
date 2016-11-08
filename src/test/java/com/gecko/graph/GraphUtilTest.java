package com.gecko.graph;

import com.gecko.graph.exception.VertexNotFoundException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hlieu on 11/4/16.
 */
public class GraphUtilTest {

    @Test
    public void test_transpose1() {
        int[][] g = new int[3][3];

        g[0][0] = 1;
        g[1][0] = 1;
        g[2][0] = 1;

        int[][] transpose = GraphUtil.transpose(g);
        Assert.assertTrue(transpose[0][0] == 1);
        Assert.assertTrue(transpose[0][1] == 1);
        Assert.assertTrue(transpose[0][2] == 1);
    }

    @Test
    public void test_out_degree_unweighted_graph() {
        int[][] g = new int[3][3];

        g[0][0] = 1;
        g[1][0] = 1;
        g[2][0] = 1;
        g[0][2] = 1;
        g[1][1] = 1;

        int degree_0 = GraphUtil.out_degree(g, 0);
        int degree_1 = GraphUtil.out_degree(g, 1);
        int degree_2 = GraphUtil.out_degree(g, 2);

        Assert.assertTrue(degree_0 == 2);
        Assert.assertTrue(degree_1 == 2);
        Assert.assertTrue(degree_2 == 1);
    }

    @Test
    public void test_out_degree_weighted_graph() {
        int[][] g = new int[3][3];

        // a weighted graph,
        g[0][0] = 4;
        g[1][0] = 1;
        g[2][0] = 10;
        g[0][2] = 16;
        g[1][1] = 22;

        int degree_0 = GraphUtil.out_degree(g, 0);
        int degree_1 = GraphUtil.out_degree(g, 1);
        int degree_2 = GraphUtil.out_degree(g, 2);

        Assert.assertTrue(degree_0 == 2);
        Assert.assertTrue(degree_1 == 2);
        Assert.assertTrue(degree_2 == 1);
    }

    @Test(expected = VertexNotFoundException.class)
    public void test_out_degree_vertex_exception() {
        int[][] g = new int[3][3];

        // a weighted graph,
        g[0][0] = 4;
        g[1][0] = 1;
        g[2][0] = 10;
        g[0][2] = 16;
        g[1][1] = 22;

        int degree_0 = GraphUtil.out_degree(g, 8);

        Assert.assertTrue(degree_0 == 2);
    }

    @Test
    public void test_in_degree() {
        int[][] g = new int[3][3];

        // a weighted graph,
        g[0][0] = 4;
        g[1][0] = 1;
        g[2][0] = 10;
        g[0][2] = 16;
        g[1][1] = 22;

        int in_degree = GraphUtil.in_degree(g, 0);
        Assert.assertTrue(in_degree == 3);
    }
}