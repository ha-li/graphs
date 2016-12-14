package com.gecko.graph;

import com.gecko.graph.exception.VertexNotFoundException;

/**
 * Created by hlieu on 11/4/16.
 */
public class GraphUtil {

    public static Edge[] edges (Graph g) {
        int E = 0;
        Edge[] edges = new Edge[g.E()];
        for (int v = 0; v < g.V(); v++) {
            AdjacencyList a = g.getAdjList (v);
            for (int w = a.beg(); !a.end(); w = a.next() ) {
                if( v < w ) {
                    edges[E++] = new Edge (v, w);
                }
            }
        }
        return edges;
    }

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

    // returns the out degree of vertex v
    public static int out_degree(int[][] g, int v) {
        // error check
        if(v >= g.length) { throw new VertexNotFoundException(); }


        int degree = 0;
        for(int i = 0; i < g[v].length; i++) {
            if(g[v][i] > 0) { degree++; }
        }
        return degree;
    }

    // returns the in-degree of vertex v
    public static int in_degree(int[][] g, int v) {
        if(v >= g.length) { throw new VertexNotFoundException(); }

        int degree = 0;
        for(int i = 0; i < g[v].length; i++) {
            if(g[i][v] > 0) { degree++; }
        }
        return degree;
    }
}
