package main;

public class Map {

    private int[][] map;

    private static int updown;
    private static int leftright;
    private static int holdrow = 0;
    private static int holdcol = 0;
    private int counter = 0;
    private int min=0;
    private int customer;
    private int temp;

    public Map(int size) {
        map = new int[size][size];
    }

    public void Source(int x, int y, int label) {
        map[x][y] = label;
    }

    public void Destination(int x, int y, int label) {
        map[x][y] = label;
    }

    public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void calculateshortest() {

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {
                leftright = 0;
                updown = 0;

                counter = 0;
                if (map[i][j] - map[holdrow][holdcol] == 1 || map[i][j] % 2 == 1) {

                    leftright = Math.abs(holdrow - i);
                    updown = Math.abs(holdcol - j);

                    counter = leftright + updown;

                    temp = map[i][j];

                    System.out.println(temp);
                    System.out.println(counter);
                }

//             }
            }

        }

    }
}
