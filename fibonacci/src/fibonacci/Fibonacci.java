
package fibonacci;

public class Fibonacci {

  
    
    public static long fibonacci(int n){
        if(n<=1){
            return n;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
    
    public static void convert(int n){
        if(n==0) return;
        convert(n/2);
        System.out.println(n%2);
    }
    
    public static void main(String[] args){
//        int n=  8;
//        for(int i=1;i<=n;i++){
//            System.out.println(fibonacci(i));
           int n=10;
           convert(n);
           System.out.println("");
        }
     
    
}
