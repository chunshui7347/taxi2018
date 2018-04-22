package pkgfinal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Map {

    private static int M, N;
    private int[][] map;
    private static int holdrow, holdcol;
    private int nextrow, nextcol, time;
    private static int temp = 2;
    private int counter;
    private int min = Integer.MAX_VALUE;
    private String[][] saveLabel;
    private static int numOfPassenger;
    private static final int row[] = {-1, 0, 0, 1};
    private static final int col[] = {0, -1, 1, 0};
    private int[][] array;
    private static int wait = 0, ride = 0;
    private int previousrow = holdrow, previouscol = holdcol;
    private static int stepCounter = 0;
    PrintWriter pw;
    ArrayList<Integer> canSearch = new ArrayList<>();
    ArrayList<String> labelname = new ArrayList<>();
    ArrayList<Integer> WaitingTime = new ArrayList<>();
    ArrayList<Integer> RidingTime = new ArrayList<>();
    
    
    public Map(int M, int N, int numOfPassenger) throws FileNotFoundException {
        this.pw = new PrintWriter(new FileOutputStream("Log.txt"));
        this.M = M;
        this.M = M;
        this.N = N;
        this.map = new int[M][N];
        canSearch.add(3);
        this.saveLabel = new String[M][N];
        WaitingTime.add(0);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                }
            }
        }
    }

    public void Source(int x, int y, int label) {
        map[x][y] = label;
        canSearch.add(label);
    }

    public void Destination(int x, int y, int label) {
        map[x][y] = label;
    }

    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                && mat[row][col] >= 1 && !visited[row][col];
    }

    public static int BFS(int mat[][], int i, int j, int x, int y) {

        boolean[][] visited = new boolean[M][N];

        Queue<Node> q = new ArrayDeque<>();

        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            Node node = q.poll();

            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {

                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        } else {
            return -1;
        }
    }

    public void finalmap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
    public int getCounter() {
        return counter;
    }

    public void saveLabelSource(int x, int y, String label) {
        saveLabel[x][y] = label + "_s";
        labelname.add(label);
    }

    public void saveLabelDest(int x, int y, String label) {
        saveLabel[x][y] = label + "_d";
    }

    public void printMap() {
        System.out.println("#######################################");
        System.out.println("            Map Output: ");
        System.out.println("#######################################");
        System.out.print("   ");
        for (int i = 0; i < saveLabel.length; i++) {
            System.out.print(i + "    ");
        }
        System.out.println();
        for (int j = 0; j < saveLabel.length; j++) {
            System.out.print("------");
        }
        System.out.println();
        for (int k = 0; k < saveLabel.length; k++) {
            System.out.print(k + "| ");
            for (int l = 0; l < saveLabel.length; l++) {
                if (saveLabel[k][l] == null) {
                    saveLabel[k][l] = "0  ";
                }
                System.out.print(saveLabel[k][l] + "  ");
            }
            System.out.println();
        }
        System.out.println("#######################################");

        for (int i = 0; i < labelname.size(); i++) {
            if (i == labelname.size() - 1) {
                System.out.print(labelname.get(i) + " = passenger labels\n");
                System.out.println("_s = source");
                System.out.println("_d = destination");
                System.out.println("0 = empty square");
            } else {
                System.out.print(labelname.get(i) + ",");
            }
        }
        System.out.println("");
        System.out.println("#######################################");
        System.out.println("            Result: ");
        System.out.println("#######################################");
    }

    public void choose() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            int crntTemp = map[holdrow][holdcol];
            for (int j = 0; j < map[i].length; j++) {
                if (canSearch.contains(map[i][j])) {
                    int dest = BFS(map, holdrow, holdcol, i, j);
                    if (numOfPassenger < 4) {
                        if (dest < min) {
                            min = dest;
                            nextrow = i;
                            nextcol = j;
                            crntTemp = map[i][j];
                        } else if (dest == min && crntTemp % 2 == 1 && map[i][j] % 2 == 0) {
                            min = dest;
                            nextrow = i;
                            nextcol = j;
                            crntTemp = map[i][j];
                        }
                    } else {
                        if (dest < min && map[i][j]%2 ==1) {
                            min = dest;
                            nextrow = i;
                            nextcol = j;
                            crntTemp = map[i][j];
                        }
                    }
                }
            }

        }

        temp = map[nextrow][nextcol];
        map[nextrow][nextcol] = 1;
        previousrow = holdrow;
        previouscol = holdcol;
        holdrow = nextrow;
        holdcol = nextcol;
        counter = counter + nextrow + nextcol;
        canSearch.remove(canSearch.indexOf(temp));
        if (temp % 2 == 0) {
            canSearch.add(temp + 1);
            numOfPassenger++;
        } else {
            numOfPassenger--;
        }
    }

    public void direction() {
        int row = holdrow - previousrow;
        int col = holdcol - previouscol;

        if (col >= 0) {
            for (int i = 0; i < col; i++) {
                pw.println("[" + stepCounter + "]" + "Taxi move right");
                stepCounter++;
            }
        } else {
            for (int i = col; i < 0; i++) {
                pw.println("[" + stepCounter + "]" + "Taxi move left");
                stepCounter++;

            }
        }
        if (row >= 0) {
            for (int i = 0; i < row; i++) {
                pw.println("[" + stepCounter + "]" + "Taxi move down");
                stepCounter++;
            }
        } else {
            for (int i = row; i < 0; i++) {
                pw.println("[" + stepCounter + "]" + "Taxi move up");
                stepCounter++;
            }
        }
        if (saveLabel[holdrow][holdcol].contains("_s")) {
            pw.println("[" + stepCounter + "]Taxi fetch passenger " + saveLabel[holdrow][holdcol].substring(0, 1));
        } else if (saveLabel[holdrow][holdcol].contains("_d")) {
            pw.println("[" + stepCounter + "]Taxi dropped passenger " + saveLabel[holdrow][holdcol].substring(0, 1));
            System.out.print("Customer " +saveLabel[holdrow][holdcol].substring(0, 1)+", ");
            Score lol = new Score();
            lol.GiveMark();
        }
    }

    public void printToFile(int passenger) {
        try {
            pw.println("Execution Log :      ");
            if (stepCounter == 0) {
                pw.println("[" + stepCounter + "]" + "Taxi is started");
            }
            for (int i = 0; i < (passenger * 2); i++) {
                
                choose();
                direction();
                

            }

            pw.close();
        } catch (Exception e) {
            System.out.println("File output error");
        }
    }

    public void ride(int a, int b, int c, int d) {
        ride = BFS(map, a, b, c, d);
        RidingTime.add(ride);
    }

    public void wait(int a, int b, int c, int d) {
        wait = wait + BFS(map, a, b, c, d) + ride;
        WaitingTime.add(wait);
    }

    public int getRide(int i) {
        return RidingTime.get(i);
    }

    public int getWait(int i) {
        return WaitingTime.get(i);
    }

    public String getName(int i) {
        return labelname.get(i);
    }

}
