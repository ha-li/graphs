package com.gecko.graph.algorithms;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;
import com.gecko.graph.Path;
import com.gecko.graph.exception.NotRelevantException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hlieu on 12/15/16.
 */
public class GraphBFS implements GraphPath {
   private Graph g;
   private boolean[] visited;
   private boolean found;
   private int[] ord;
   private int start;


   public GraphBFS(Graph g) {
      this.g = g;
      ord = new int[g.V()];
   }

   // start with v and do a bfs
   public boolean search (int v, int w) {
      found = false;
      visited = new boolean[g.V()];
      reset ();
      return bfs(v, w);
   }

   public void reset() {
      for (int i = 0; i < g.V(); i++) {
         ord[i] = -1;
      }
      found = false;
   }

   //
   private boolean bfs (int v, int w) {

      visited[v] = true;
      Queue<Integer> queue = new LinkedList<Integer> ();
      queue.add(v);
      int count = 0;   // the order which we are visiting the vertices

      ord[v] = ++count;   // v is the first visit

      // get the adjacency list of v
      while ( !queue.isEmpty() ) {
         Integer f = queue.remove();
         AdjacencyList a = g.getAdjList (f);
         for( int t = a.beg(); !a.end(); t = a.next() ) {
            if ( !visited[t] ) {
               queue.add(t);
               visited[t] = true;
               ord[t] = ++count;
            }
         }
      }
      return false;
   }

   public boolean exists () {
      throw new NotRelevantException ("not inquiring if path exists");
   }

   // retrieves the path of search, in this cause it is an ordinance
   // array that shows for each vertex v, the order that v was
   // searched
   public Path path (){
      return new OrdinancePath ();
   }

   private class OrdinancePath implements Path, OrdinanceSearch {
      private int i;
      public OrdinancePath () {
         i = -1;
      }

      public boolean isEnd () {
         return i == ord.length - 1;
      }

      public int start () { return ord[++i]; }

      public int end () { return ord[ord.length - 1]; }

      public int next () { return ord[++i];}

      //
      public int order(int v) {
         return ord[v];
      }

   }
}
