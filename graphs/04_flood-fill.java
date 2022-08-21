//Problem: https://leetcode.com/problems/flood-fill/
class Program {

  static void floodFill(int[][] image, int sr, int sc, int color, boolean[][] visited, int scolor) {

    if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || visited[sr][sc] == true
        || image[sr][sc] != scolor) {
      return;
    }

    image[sr][sc] = color;
    visited[sr][sc] = true;

    int[] xcoord = { -1, 0, 1, 0 };
    int[] ycoord = { 0, 1, 0, -1 };

    for (int i = 0; i < 4; i++) {
      int x = xcoord[i];
      int y = ycoord[i];
      floodFill(image, sr + x, sc + y, color, visited, scolor);
    }
  }

  public static void main(String[] args) {

    int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    // int[][] res = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    boolean[][] visited = new boolean[3][3];
    int sr = 1, sc = 1, color = 2;

    floodFill(image, sr, sc, color, visited, image[sr][sc]);

    for (int[] array : image) {
      for (int el : array) {
        System.out.print(el + " ");
      }
      System.out.println();
    }

  }
}