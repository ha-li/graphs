package com.gecko.graph.algorithms;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;
import com.gecko.graph.Path;

/**
 * Created by hlieu on 12/14/16.
 */
public class GraphPathDFS implements GraphPath {
   private Graph g;
   private boolean found;
   private boolean[] visited;
   private int[] path;
   private int start;
   private int end;

   public GraphPathDFS (Graph g) {
      this.g = g;
      path = new int[g.V()];
      //resetPath();
      //found = false;
      //visited = new boolean[g.V()];
      // found = search (v, w);
   }

   private void resetPath (int s, int e) {
      start = s;
      end = e;
      for (int i = 0; i < g.V(); i++) {
         path[i] = -1;
      }
   }

   public boolean search (int v, int w) {
      found = false;
      visited = new boolean[g.V()];
      //searchStart = v;
      resetPath(v, w);
      return dfs (v, w);
   }

   private boolean dfs (int v, int w) {
      if (v == w) {
         //path[v] = w;
         return found = true;
      }
      visited[v] = true;

      AdjacencyList a = g.getAdjList (v);

      // go through all the vertices in v's adjacency list
      // and recurse through them
      for ( int t = a.beg(); !a.end(); t = a.next() ) {
         // have we been to t before?, if we have, skip it
         if ( !visited [t] ) {

            // if not, we recurse down t trying to find a
            // path from t to w
            if ( dfs(t,w) ) {
               // if we get here, then we found a path from t to w,
               // which means we can go from v to w via t
               path[v] = t;
               return true;
            }
         }
      }
      // once we are done with the adjacency list,
      // we did not find a path to w via v's adjacency
      // list, so v-w is not connected, return false
      return false;
   }

   public Path path () {
      return new ArrayPath ();
   }

   public boolean exists() {
         return found;
      }


   public class ArrayPath implements Path {
      //private int start;  // the start of the path
      //private int end;
      private int i;      // the index of the current vertex

      public ArrayPath () {
         //start = s;
         i = -1;
      }

      public int end () {
         return end;
      }

      public boolean isEnd () {
         return path[i] == -1;
      }

      public int next () {
         return i = path[i];
      }

      public int start () {
         return i = start;
      }

   }
}
