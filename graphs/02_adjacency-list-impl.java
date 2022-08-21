import java.util.*;

class Graph {
  int V;
  ArrayList<Edge> graph[];

  @SuppressWarnings("unchecked")
  Graph(int V) {
    this.V = V;
    this.graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      this.graph[i] = new ArrayList<>();
    }
  }

  static class Edge {
    int src;
    int dest;
    int wt;

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

class Program {
  public static void main(String[] args) {

    Graph graph = new Graph(4);

    graph.addEdge(0, 1, 0);
    graph.addEdge(0, 2, 0);
    graph.addEdge(0, 3, 0);
    graph.addEdge(1, 2, 0);
    graph.addEdge(2, 3, 0);

    graph.printGraph();
  }

}