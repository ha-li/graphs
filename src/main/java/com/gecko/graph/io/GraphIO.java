package com.gecko.graph.io;

import com.gecko.graph.AdjacencyList;
import com.gecko.graph.Graph;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphIO {
   public static void show (Graph g) {
      for (int s = 0; s < g.V(); s++) {
         System.out.print (s + ": ");
         AdjacencyList a = g.getAdjList (s);
         for (int t = a.beg(); !a.end(); t = a.next() ) {
            System.out.print (t + " ");
         }
         System.out.println ();
      }
   }
}
