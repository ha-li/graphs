package com.gecko.graph;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphDegree {
   private Graph g;
   private int[] degree;

   public GraphDegree (Graph g) {
      this.g = g;
      degree = new int[g.V()];
      for (int v = 0; v < g.V (); v++) {
         degree[v] = 0;
         AdjacencyList a = g.getAdjList (v);
         for (int w = a.beg(); !a.end(); w = a.next()){
            degree[v]++;
         }
      }
   }

   public int degree(int v) {
      return degree[v];
   }
}
