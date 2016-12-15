package com.gecko.graph.algorithms;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphDegree {
   private Graph g;
   private int[] degree;

   public GraphDegree (Graph g) {

      // computes the degree for each vertex
      this.g = g;
      degree = new int[g.V()];
      for (int v = 0; v < this.g.V (); v++) {
         degree[v] = 0;
         AdjacencyList a = this.g.getAdjList (v);
         for (int w = a.beg(); !a.end(); w = a.next()){
            degree[v]++;
         }
      }
   }

   public int degree(int v) {
      return degree[v];
   }
}
