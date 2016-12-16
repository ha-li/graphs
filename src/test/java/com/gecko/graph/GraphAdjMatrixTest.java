package com.gecko.graph;

import com.gecko.graph.algorithms.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphAdjMatrixTest {

   private Graph createConnectedGraph () {
      Graph g = new GraphAdjMatrix (5);
      g.insert(new Edge(0,1));
      g.insert(new Edge(0,2));
      g.insert(new Edge(0,3));
      g.insert(new Edge(0,4));
      g.insert(new Edge(2,3));

      return g;
   }

   private Graph createDisconnectedGraph () {
      Graph g = new GraphAdjMatrix (7);
      g.insert(new Edge(0,1));
      g.insert(new Edge(0,2));
      g.insert(new Edge(0,3));
      g.insert(new Edge(0,4));
      g.insert(new Edge(2,3));

      g.insert(new Edge(5, 6));

      return g;
   }


   @Test
   public void testGraph () {
      Graph g = createConnectedGraph ();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);
   }

   @Test
   public void testDegree () {
      Graph g = createConnectedGraph ();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);

      GraphDegree degree = new GraphDegree (g);
      Assert.assertTrue(degree.degree(2) == 2);
   }

   @Test
   public void testDegree2 () {
      Graph g = createConnectedGraph ();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);

      // GraphDegree degree = new GraphDegree (g);
      Assert.assertTrue(g.degree(0) == 4);
      Assert.assertTrue(g.degree(1) == 1);
      Assert.assertTrue(g.degree(2) == 2);
      Assert.assertTrue(g.degree(3) == 2);
      Assert.assertTrue(g.degree(4) == 1);

   }


   @Test
   public void testGraphPath () {
      Graph g = createConnectedGraph ();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);


      GraphPath path = new GraphPathDFS (g);
      Assert.assertTrue ( path.search(2, 3) );
      Assert.assertTrue ( path.exists() );

      Assert.assertTrue ( path.search(1, 3) );
      Assert.assertTrue ( path.exists() );

      Assert.assertTrue ( path.search(1, 3) );
      Assert.assertTrue ( path.exists() );
   }


   @Test
   public void testGraphPathDisconnected () {
      Graph g = createDisconnectedGraph ();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);
      Assert.assertTrue(g.isEdge(5,6) == true);
      Assert.assertTrue(g.isEdge(5,4) == false);

      GraphPath gPath = new GraphPathDFS (g);
      Assert.assertTrue ( !gPath.search(1, 6) );
      Assert.assertTrue ( !gPath.exists() );

      Assert.assertTrue ( gPath.search(3, 4) );
      Assert.assertTrue ( gPath.exists() );
      Path path = gPath.path();
      System.out.println ("path from 3 .. 4");
      int i = 0;
      for( i = path.start (); !path.isEnd(); i = path.next() ) {
         System.out.print (i + ",");
      }
      System.out.println ( path.end() );
      System.out.println ("end");
   }

   @Test
   public void testBFSGraphPath () {
      Graph g = createConnectedGraph();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);

      GraphPath gPath = new GraphBFS (g);
      gPath.search (1, 0);

      Path ordinance = gPath.path();
      System.out.println ("bfs ordinance");
      for( int t = ordinance.start (); ! ordinance.isEnd(); t = ordinance.next()) {
         System.out.print (t + ",");
      }
      System.out.println (ordinance.end());
      System.out.println ("end");

      OrdinanceSearch searchPath = (OrdinanceSearch) ordinance;
      int i = 3;
      System.out.println ("vertex " + i + " was searched " + searchPath.order(i) );
   }

   @Test
   public void testShortestGraphPath () {
      Graph g = createConnectedGraph();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);

      GraphPath gPath = new GraphShortestPath (g);
      gPath.search (1, 3);

      Path shortest = gPath.path();
      System.out.println ("shortest path backwards");
      for( int t = shortest.start (); ! shortest.isEnd(); t = shortest.next()) {
         System.out.print (t + ",");
      }
      System.out.println (shortest.end());
      System.out.println ("end");
   }
}