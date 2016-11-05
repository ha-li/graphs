package com.gecko.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hlieu on 11/4/16.
 */
public class TransposeGraphTest {

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

}