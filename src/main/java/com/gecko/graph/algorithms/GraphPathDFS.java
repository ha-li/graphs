package com.gecko.graph.algorithms;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;

/**
 * Created by hlieu on 12/14/16.
 */
public class GraphPathDFS implements GraphPath {
   private Graph g;
   private boolean found;
   private boolean[] visited;

   public GraphPathDFS (Graph g) {
      this.g = g;
      //found = false;
      //visited = new boolean[g.V()];
      // found = search (v, w);
   }

   public boolean search (int v, int w) {
      found = false;
      visited = new boolean[g.V()];
      return dfs (v, w);
   }

   private boolean dfs (int v, int w) {
      if (v == w) {
         return found = true;
      }
      visited[v] = true;

      AdjacencyList a = g.getAdjList (v);
      for ( int t = a.beg(); !a.end(); t = a.next() ) {
         if ( !visited [t] ) {
            if ( dfs(t,w) ) {
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
