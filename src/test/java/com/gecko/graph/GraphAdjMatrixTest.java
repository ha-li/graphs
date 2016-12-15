package com.gecko.graph;

import com.gecko.graph.algorithms.GraphDegree;
import com.gecko.graph.algorithms.GraphPath;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hlieu on 12/13/16.
 */
public class GraphAdjMatrixTest {

   private Graph createGraph () {
      Graph g = new GraphAdjMatrix (5);
      g.insert(new Edge(0,1));
      g.insert(new Edge(0,2));
      g.insert(new Edge(0,3));
      g.insert(new Edge(0,4));
      g.insert(new Edge(2,3));
      return g;
   }

   @Test
   public void testGraph () {
      Graph g = createGraph();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);
   }

   @Test
   public void testDegree () {
      Graph g = createGraph();
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
      Graph g = createGraph();
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
      Graph g = createGraph();
      Assert.assertTrue(g.isEdge(2,3) == true);
      Assert.assertTrue(g.isEdge(0,1) == true);
      Assert.assertTrue(g.isEdge(0,2) == true);
      Assert.assertTrue(g.isEdge(0,3) == true);
      Assert.assertTrue(g.isEdge(0,4) == true);

      GraphPath path = new GraphPath (g, 2, 3);
      Assert.assertTrue ( path.exists() );
   }

}