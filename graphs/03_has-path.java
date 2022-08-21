
//Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
import java.util.ArrayList;

class Program {

  static class Edge {
    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

    if (src == dest) {
      return true;
    }

    visited[src] = true;

    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr] && hasPath(graph, edge.nbr, dest, visited)) {
        return true;
      }
    }

    return false;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    int n = 6;
    int src = 0;
    int dest = 2;
    int[][] input = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 4, 5 }, { 2, 3 } };

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] array : input) {
      int s = array[0];
      int d = array[1];

      graph[s].add(new Edge(s, d));
      graph[d].add(new Edge(d, s));
    }
    boolean[] visited = new boolean[n];
    boolean ans = hasPath(graph, 2, 4, visited);
    System.out.println(ans);
  }
}
