class Graph {
  private boolean[][] matrix;
  private int vertexCount;

  public Graph(int vertexCount) {
    this.vertexCount = vertexCount;
    this.matrix = new boolean[vertexCount][vertexCount];
  }

  public void addEdge(int src, int dest) {
    if (src >= 0 && src < vertexCount && dest >= 0 && dest < vertexCount) {

      this.matrix[src][dest] = true;
      // assuming the graph is not directed
      this.matrix[dest][src] = true;
    } else {
    }
  }

  public void removeEdge(int src, int dest) {
    if (src >= 0 && src < vertexCount - 1 && dest >= 0 && dest < vertexCount) {

      this.matrix[src][dest] = false;
      // assuming the graph is not directed
      this.matrix[dest][src] = false;
    } else {
    }
  }

  public boolean isEdge(int src, int dest) {
    if (src >= 0 && src < vertexCount - 1 && dest >= 0 && dest < vertexCount) {
      return this.matrix[src][dest];
    } else {
      return false;
    }
  }

  public void printGraph() {
    for (int i = 0; i < this.vertexCount; i++) {
      System.out.print(i + "-> ");
      for (int j = 0; j < this.vertexCount; j++) {
        if (this.matrix[i][j] == true) {
          System.out.print(j + ", ");
        }
      }
      System.out.println();
    }
  }
}

class Program {
  public static void main(String[] args) {
    Graph graph = new Graph(4);

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);
    graph.addEdge(0, 2);

    graph.printGraph();
  }
}