/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

/**
 *
 * @author Tan Chun Shui
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackOfInteger a= new StackOfInteger();
        
        for(int i=0;i<10;i++){
            a.push(i);
        }
        System.out.println(a.getSize());
        
        while(!a.empty()){
            System.out.println(a.pop());
        }
    
}
}
