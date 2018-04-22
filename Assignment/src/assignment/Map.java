
package assignment;

public class Map {

    protected int[][]adjacencyMatrix;

    public Map(int size) {
      adjacencyMatrix = new int[size][size];
    }

    public void Source(int x, int y, int label) {
      adjacencyMatrix[x][y] = label;
    }

    public void Destination(int x, int y, int label) {
      adjacencyMatrix[x][y] = label;
    }
}
