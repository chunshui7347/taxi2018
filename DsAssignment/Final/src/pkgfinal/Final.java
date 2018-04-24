package pkgfinal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Final {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        Score lol = new Score();
        Passenger customer = new Passenger();
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
            taxi.fees(sPntX, sPntY, dPntX, dPntY);
	    System.out.print("Please pay the fees before the ride : ");
            double pay = s.nextDouble();
            taxi.checkPay(pay);

        }
        taxi.printMap();
        for (int i = 0; i < b; i++) {
            System.out.println("Passenger " + taxi.getName(i) + " wait for " + taxi.getWait(i) + "  minutes, ride for " + taxi.getRide(i));
        }
        System.out.println("");
        taxi.printToFile(b);
        System.out.printf("The rating is %.2f", lol.getAverage());
        System.out.println("");
        System.out.println("The total of customer is "+customer.getCustomer());
        System.out.println("");
        System.out.println("Taxi today earned : "+taxi.getTaxiSalary());
        
        
    }
}