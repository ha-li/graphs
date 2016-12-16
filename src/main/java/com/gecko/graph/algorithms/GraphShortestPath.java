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
public class GraphShortestPath implements GraphPath {
   private Graph g;
   private boolean[] visited;
   private int start;
   private int end;

   // the shortest path to any vertex v is path[v]
   private int[] path;
   public GraphShortestPath (Graph g) {
      this.g = g;
      this.path = new int[g.V()];
      visited = new boolean [g.V()];
   }

   public boolean search (int v, int w) {
      reset ();
      return bfs(v, w);
   }

   private void reset () {
      for(int i = 0; i < g.V(); i++) {
         path[i] = -1;
         visited[i] = false;
      }
   }

   private boolean bfs (int v, int w) {
      Queue<Integer> queue = new LinkedList<Integer> ();
      queue.add(v);
      visited[v] = true;
      start = v;
      end = w;

      while ( !queue.isEmpty() ) {
         // one side of the edge
         Integer t = queue.remove();
         AdjacencyList a = g.getAdjList (t);
         for (int s = a.beg(); !a.end(); s = a.next() ){
            if( !visited[s] ) {
               queue.add (s);
               visited[s] = true;
               path[s] = t;
            }
         }
      }
      return true;
   }

   public boolean exists () {
      throw new NotRelevantException ("not relevent to shortest path algorithm");
   }

   public Path path () {
      return new ShortestPathBackwards();
   }

   private class ShortestPathBackwards implements Path {
      private int i;

      public ShortestPathBackwards () {
         i = -1;
      }

      // work backwards from the destination
      public int start () {
         return i = end;
      }

      public int end () {
         return start;
      }

      public boolean isEnd () {
         return path[i] == - 1;
      }

      public int next () {
         return i = path[i];
      }
   }
}
