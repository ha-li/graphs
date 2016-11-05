package com.gecko.graph;

/**
 * Created by hlieu on 11/4/16.
 */
public class GraphUtil {

    // returns the transpose of a graph
    public static int[][] transpose(int[][] g) {

        // initialize the transpose graph
        int[][] transpose = new int[g.length][g[0].length];

        for(int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                transpose[j][i] = g[i][j];
            }
        }

        return transpose;
    }
}
