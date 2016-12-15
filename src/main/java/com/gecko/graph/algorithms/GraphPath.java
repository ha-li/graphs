package com.gecko.graph.algorithms;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;

/**
 * Created by hlieu on 12/14/16.
 */
public class GraphPath {
   private Graph g;
   private boolean found;
   private boolean[] visited;

   public GraphPath (Graph g, int v, int w) {
      this.g = g;
      found = false;
      visited = new boolean[g.V()];
      found = search (v, w);
   }

      private boolean search (int v, int w) {
         if (v == w) {
            return found = true;
         }
         visited[v] = true;

         AdjacencyList a = g.getAdjList (v);
         for ( int t = a.beg(); !a.end(); t = a.next() ) {
            if ( !visited [t] ) {
               if ( search(t,w) ) {
                  return true;
               }
            }
         }
         return false;
      }

      public boolean exists() {
         return found;
      }
}
