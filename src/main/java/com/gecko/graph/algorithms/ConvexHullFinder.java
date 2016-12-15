package com.gecko.graph.algorithms;

import com.gecko.graph.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlieu on 11/10/16.
 */
public class ConvexHullFinder {

    private Point[] graphPoints;

    public ConvexHullFinder(Point[] points) {
        graphPoints = points;
    }

    public Point[] getConvexHull() {

        List<Point> hull = new ArrayList<Point>();

        // find the lowest point -- thats the starting point
        Point low = lowest(graphPoints);
        hull.add(low);

        return (Point[])hull.toArray();
    }

    private Point lowest(Point[] points) {
        Point lowest = points[0];

        for(int i = 1; i < points.length; i++) {
            if(points[i].y < lowest.x) {
                lowest = points[i];
            } else if (points[i].y == lowest.y && points[i].x < lowest.x) {
                // the y are the same, so we take the left most
                lowest = points[i];
            }
        }
        return lowest;
    }


}
