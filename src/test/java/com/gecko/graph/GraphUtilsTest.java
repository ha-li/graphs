package com.gecko.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hlieu on 11/10/16.
 */
public class GraphUtilsTest {
    @Test
    public void test_1() {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(4, 3);
        Point p2 = new Point(6, 7);

        int cp = GraphUtils.cross_product(p0, p1, p2);

        System.out.println(cp);

    }
}