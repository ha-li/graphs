package com.gecko.graph;

import com.gecko.graph.exception.VertexNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hlieu on 11/5/16.
 */
public class Graph {
    private List<Vertex>[] adj;
    private Vertex[] vertex_list;
    //private Vertex[][] adj_matrix;

    // number of vertices
    public Graph(int num) {
        vertex_list = new Vertex[num];
        adj = new LinkedList[num];
        //adj_matrix = new Vertex[num][num];
    }

    public Graph(int[][] g) {

    }

    public void addVertex(int i) {
        // create the new vertex and store it in proper slot
        // in the list of vertices
        Vertex v = new Vertex(i);
        vertex_list[i] = v;

        // initialize its corresponding adjacency list
        adj[i] = new LinkedList<Vertex>();


        //adj_matrix[i][0] = v;
    }

    /* public void addEdge(int v1, int v2) {
        // add another vertex to the graph
        // if the vertex has already been added, it is skipped
        Edge edge = new Edge(v1, v2);
        vertex_list[v1][v2] = edge;
        vertex_list[v2][v1] = edge;
    }*/

    //connects the two vertices together
    public void connect(int u, int v) {
        /* if ( u >= vertex_list.length || v >= vertex_list.length ) {
            throw new VertexNotFoundException();
        } */

        Vertex v_ = vertex_list[v];
        Vertex u_ = vertex_list[u];


        adj[u].add(v_);
        adj[v].add(u_);
    }

    private class Vertex {
        int val;
        int color; //
        int distance;
        Vertex predecessor;

        public Vertex(int v) {
            val = v;
        }
    }

    private class Edge {
        int v_1;    // vertex 1
        int v_2;    // vertex 2

        public Edge(int v1, int v2) {
            v_1 = v1;
            v_2 = v2;
        }
    }

    private void reset(Vertex[] s) {

        for( int i = 0; i < s.length; i++ ) {
            s[i].color = 0;
            s[i].distance = 0;
            s[i].predecessor = null;
        }
    }

    // a breadth-first-search of the graph, returns
    // all the vertices that can be reached from vertex s
    public void bfs(int s) {
        reset(vertex_list);

        Queue<Vertex> q = new LinkedList<Vertex>();
        Vertex root = vertex_list[s];

        root.color = 1;
        root.predecessor = null;

        q.add(root);

        while( q.size () > 0 ) {
            Vertex u = q.remove();
            System.out.println(u.val);

            for (Vertex v : adj[u.val]) {
                if (v.color == 0) {
                    v.color = 1;   // change color to gray
                    v.distance = u.distance + 1;
                    v.predecessor = u;
                    q.add(v);
                }
            }
            // paint u black, so that we don't come back to u, but that
            // means we never marked u's predecessor
            //u.color = 2;
        }

        // now the graph reflects the bfs starting at
        // vertex s
        //print_bfs(0, s);
    }

    public void dfs(int v) {

    }

    // prints the bfs from s to v
    public void print_bfs(int s, int v) {

        Vertex v_ = vertex_list[v];

        if( s == v ) {
            System.out.println(s);
        } else if ( v_.predecessor == null ) {
            System.out.println(" there is no path from " + s + " to " + v);
        } else {
            print_bfs(s, v_.predecessor.val);
            System.out.println(v_.val);
        }

    }
}
