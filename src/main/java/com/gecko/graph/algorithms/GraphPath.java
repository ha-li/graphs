package com.gecko.graph.algorithms;

import com.gecko.graph.Path;

/**
 * Created by hlieu on 12/14/16.
 */
public interface GraphPath {
   public boolean search (int v, int w);
   public boolean exists ();
   public Path path();
}
