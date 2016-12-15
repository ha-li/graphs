package com.gecko.graph.utils;

import com.gecko.graph.Point;

/**
 * Created by hlieu on 11/10/16.
 */
public class GraphUtils {

    // the cross product of 3 points is used to determine the convex hull of
    // a set S of points {P0, P1, P2, .... Pn}, where n is 3 or more.

    // computes the cross product of 2 consecutive vectors p0p1, and p1p2
    // negative cross product means p0p2 is counterclose wise wrt p0p1 (turns left at p1)
    // positive cross product means p0p2 is clockwise wrt p0p1 (turns right at p1)
    // 0 means p0, p1, p2 are colinear
    public static int cross_product(Point p0, Point p1, Point p2) {
        return (p2.x - p0.x)*(p1.y - p0.y) - (p1.x - p0.x) * (p2.y - p0.y);
    }


}
