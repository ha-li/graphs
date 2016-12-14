package com.gecko.graph;

/**
 * Created by hlieu on 12/13/16.
 */
public interface Graph {

   int V();
   int E();
   //boolean isDirected();
   void insert (Edge edge);
   void remove (Edge edge);
   boolean isEdge (int v1, int v2);
   AdjacencyList getAdjList(int v);
}
