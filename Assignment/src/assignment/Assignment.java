
package assignment;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

    public static void main(String[] args)
    {
          
        Scanner s = new Scanner(System.in);
        int sPntX = 0;
        int sPntY = 0;
        int dPntX = 0;
        int dPntY = 0;
        int label;
        
        System.out.print("Enter map size : ");
        int size = s.nextInt();
        Map taxi = new Map(size);
         
        System.out.print("Enter number of passenger : ");
        int b = s.nextInt();
    
        for (int i = 0; i < b; i++) {
            s.nextLine();
            System.out.print("Enter passenger #" + (i + 1) + " label:");
            label =(int) s.nextLine().charAt(0);

            System.out.print("Enter passenger #" + (i + 1) + " source location:");
            sPntX = s.nextInt();
            sPntY = s.nextInt();
            taxi.Source(sPntX, sPntY, label);
            System.out.print("Enter passenger #" + (i + 1) + " destination location:");
            dPntX = s.nextInt();
            dPntY = s.nextInt();
            taxi.Destination(sPntX, sPntY, label+1);
        }     
        
     
        Graph graph = new Graph(5,b);
        graph.setStartingNode(0);
        graph.runDijkstra();


        graph.printOutput();

        x("Hello");
        x(new ArrayList());

    }


    public static void x(Object x) {
        System.out.println("Object");
    }


    public static void x(String x) {
        System.out.println("String");;}
    
    
}