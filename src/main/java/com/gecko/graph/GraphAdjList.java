package com.gecko.graph;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphAdjList implements Graph {
   private int v_count;
   private int e_count;

   private Node[] adj;

   private class Node {
      int v;
      Node next;
      public Node (int x, Node t) {
         v = x;
         next = t;
      }
   }

   public GraphAdjList (int v) {
      v_count = v;
      e_count = 0;
      adj = new Node[v];
   }

   public int V () { return v_count; }
   public int E () { return e_count; }

   public void insert (Edge edge) {
      int v = edge.v;
      int w = edge.w;
      if( adj[v] == null ) {
         e_count++;
      }
      adj[v] = new Node (w, adj[v]);
      adj[w] = new Node (v, adj[w]);
   }

   public boolean isEdge (int v, int w) {
      // Node t = adj[v];
      //AdjacencyList a = getAdjList(v);
      throw new RuntimeException ("not implemented yet");
   }

   public void remove (Edge edge) {
      /* int v = edge.v;
      int w = edge.w;
      if (adj[v] != null) { e_count--; }
      adj[v] = null;
      adj[w] = null;
      */
      throw new RuntimeException ("not implemented yet");
   }

   public int degree (int v) {
      throw new RuntimeException ("not implemented yet");
   }

   public AdjacencyList getAdjList (int v) {
      return new AdjLinkedList(v);
   }

   private class AdjLinkedList implements AdjacencyList {
      private int v;
      private Node t;
      public AdjLinkedList(int v) {
         this.v = v;
         t = null;
      }

      public int beg () {
         t = adj[v];
         return t == null ? -1 : t.v;
      }

      public int next () {
         if (t != null) { t = t.next; }
         return t == null ? -1 : t.v;
      }

      public boolean end () {
         return t == null;
      }
   }
}
