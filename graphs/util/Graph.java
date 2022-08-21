package util;

import java.util.*;

public class Graph {
  public int V;
  public ArrayList<Edge> graph[];

  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      this.graph[i] = new ArrayList<>();
    }
  }

  public static class Edge {
    public int src;
    public int dest;
    public int wt;

    public Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }

    // @Override
    // public String toString() {
    // return
    // }
  }

  public boolean addEdge(int src, int dest, int wt) {
    if (src >= 0 && dest < this.V) {
      this.graph[src].add(new Edge(src, dest, wt));
      this.graph[dest].add(new Edge(dest, src, wt));
      return true;
    } else {
      return false;
    }
  }

  public void printGraph() {
    for (int i = 0; i < V; i++) {
      System.out.print(i + ": ");
      for (Edge edge : this.graph[i]) {
        // System.out.println(edge.src + " -> " + edge.dest + " @ " + edge.wt);
        System.out.print(edge.dest + " ");
      }
      System.out.println();
    }
  }
}
