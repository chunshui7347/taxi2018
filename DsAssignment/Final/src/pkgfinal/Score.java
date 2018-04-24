
package pkgfinal;

import java.util.Scanner;

public class Score {
  Scanner input = new Scanner(System.in);
  private double mark;
  private double average;
  private static double total; 
  private static int counter=0;
  
  public double getAverage(){
      average = total/counter;
      return average;
  }
  
  public void GiveMark(){
      System.out.print("Please rate our taxi service 1 - 5 :");
      mark = input.nextInt();
      total= total+mark;
      counter++;

      
  }
  
  
  
  
  
}
