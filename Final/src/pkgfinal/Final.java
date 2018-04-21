package pkgfinal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Final {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);

        int sPntX = 0;
        int sPntY = 0;
        int dPntX = 0;
        int dPntY = 0;
        int label = 2;
        System.out.print("Enter map size : ");
        int size = s.nextInt();
        System.out.print("Enter number of passenger : ");
        int b = s.nextInt();
 
        Map taxi = new Map(size, size, b);
        for (int i = 0; i < b; i++) {
            s.nextLine();
            System.out.print("Enter passenger #" + (i + 1) + " label:");
            String x = s.next();
            System.out.print("Enter passenger #" + (i + 1) + " source location:");
            sPntX = s.nextInt();
            sPntY = s.nextInt();
            if (i != 0) {
                taxi.wait(dPntX, dPntY, sPntX, sPntY);
            }
            taxi.saveLabelSource(sPntX, sPntY, x);
            taxi.Source(sPntX, sPntY, label++);
            System.out.print("Enter passenger #" + (i + 1) + " destination location:");
            dPntX = s.nextInt();
            dPntY = s.nextInt();

            taxi.saveLabelDest(dPntX, dPntY, x);
            taxi.Destination(dPntX, dPntY, label++);
            taxi.ride(sPntX, sPntY, dPntX, dPntY);

        }
        taxi.printMap();
        for (int i = 0; i < b; i++) {
            System.out.println("Passenger " + taxi.getName(i) + " wait for " + taxi.getWait(i) + "  minutes, ride for " + taxi.getRide(i));
        }
        taxi.printToFile(b);
    }
}
