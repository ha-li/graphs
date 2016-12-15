package com.gecko.graph;

import com.gecko.graph.algorithms.GraphDegree;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphAdjMatrix implements Graph {
   private int v_count;
   private int e_count;

   // private boolean digraph;
   private boolean adj[][];

   private int[] degree;

   public GraphAdjMatrix (int v) {
      v_count = v;
      e_count = 0;
      adj = new boolean[v][v];
   }

   public int V() { return v_count; }
   public int E() { return e_count; }

   public void insert (Edge edge) {
      int v = edge.v;
      int w = edge.w;
      if ( adj[v][w] == false ) {
         e_count++;
      }
      adj[v][w] = true;
      adj[w][v] = true;
   }

   public void remove (Edge edge) {
      int v = edge.v;
      int w = edge.w;

      if ( adj[v][w] == true ) { e_count--; }
      adj[v][w] = false;
      adj[w][v] = false;
   }

   public boolean isEdge (int v, int w) {
      return adj[v][w];
   }

   public AdjacencyList getAdjList (int v) {
      return new AdjArray (v);
   }

   public int degree (int v) {

      if (degree == null) {
         degree = new int[this.V()];
         GraphDegree gDegree = new GraphDegree(this);
         for (int i = 0; i < V(); i++) {
            degree[i] = gDegree.degree(i);
         }
      }

      return degree[v];
   }

   // not that getting a list of vertices is a useless feature,
   // because list of vertices is simply 0 ... V()-1, so if
   // a graph has 5 vertices, then the vertices is 0...4,
   // the list of vertices will not tell us anything,
   // it is the adjaceny list that is most useful, since
   // it will tell for a given vertex v, all the other vertices
   // v is adjacent to

   private class AdjArray implements AdjacencyList{
      private int i;
      private int v;

      public AdjArray (int v) {
         this.v = v;
         i = -1;
      }

      public int beg () {
         i = -1;
         return next();
      }

      public int next () {

         for (i++; i < V(); i++) {
            if ( isEdge (v, i) ) {
               return i;
            }
         }
         return -1;
      }

      public boolean end () {
         return i >= V();
      }
   }
}

