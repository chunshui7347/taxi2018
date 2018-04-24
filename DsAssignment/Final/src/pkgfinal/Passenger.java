package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {

    private static ArrayList<String> fetchlol = new ArrayList<>();
    private static ArrayList<String> luggagecheck = new ArrayList<>();
    private int fetch;
    private int drop;
    private int num;
    private static int customer;

    Scanner input = new Scanner(System.in);

    public void Fetching(String label) {
        fetch = 0;
        System.out.print("Enter the number of passengers  :");
        num = input.nextInt();
        for (int i = 0; i < num; i++) {
            fetchlol.add(label);
            fetch++;
            customer++;
        }
    }

    public int getFetch() {
        return fetch;
    }

    public int getDrop(String label) {
        drop = 0;
        while (true) {
            if (fetchlol.contains(label)) {
                fetchlol.remove(label);
                drop++;
            } else {
                break;
            }
        }

        return drop;
    }

    public static int getCustomer() {
        return customer;
    }

    public boolean putluggage(String label) {
        System.out.print("Do you have luggage?");
        String luggage = input.next();
        if (luggage.equals("Y")) {
            luggagecheck.add(label);
            return true;
        }
        return false;
    }
    
    public boolean takeluggage(String label){
       if (luggagecheck.contains(label)) {
           luggagecheck.remove(label);
           return true;
       }  
       else{
           return false;
       }
    }

}
