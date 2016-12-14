package com.gecko.graph;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphAdjMatrix implements Graph {
   private int v_count;
   private int e_count;

   // private boolean digraph;
   private boolean adj[][];

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

