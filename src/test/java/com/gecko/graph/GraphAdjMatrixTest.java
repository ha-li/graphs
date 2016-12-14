package com.gecko.graph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
}