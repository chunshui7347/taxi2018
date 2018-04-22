
package recursionpractice;

public class RecursionPractice {

    public static void main(String[] args) {
        printNumbers(8);
        System.out.println(catEyes(8));
        System.out.println(power(7,2));
        System.out.println(factorial(5));
        System.out.println(mobileSpeaker(5));
        System.out.println(sum(123456));
        System.out.println(count5(155522432));
        int[] number= {1,2,3,6,7,8,5,8};
        System.out.println(binarysearch(number,3,0,number.length- 1));
        
       
    }
    public static void printNumbers(int num){
        if(num==0){
            return;
        }
        else{
            System.out.println(num);
            printNumbers(num-1);
        }
    }
    
    
    public static int catEyes(int cats){
        if(cats==0){
            return 0;
        }
        else{
            return 2+catEyes(cats-1);
        }
    }
    
    public static int power(int base,int num){
        if(num==1){
            return base;
        }
        else{
            return base*power(base,num-1);
        }
    }
    
    public static int factorial(int num){
        if(num<=1){
            return 1;
        }
        else{
            return num*factorial(num-1);
        }
    }
    
    public static long fibonacci(int n){
        if(n<=1){
            return n;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
    
    public static int mobileSpeaker(int mobile){
        if(mobile==0){
            return 0;
        }
        else{
            if(mobile%2==0){
                return 2+mobileSpeaker(mobile-1);
            }
            else{
                return 1+mobileSpeaker(mobile-1);
            }
        }
    }
    
    public static int sum(int num){
        if(num==0){
            return 0;
        }
        else{
            return num%10+sum(num/10);
        }
    }
    
    public static int count5(int num){
        if(num==0){
           return 0;
        }
        else {
            if(num%10==5){
                return 1+count5(num/10);
            }
            else{
                return 0+count5(num/10);
            }
        }
    }
    
    public static int binarysearch(int[] array, int key, int start, int end){
        if(start<=end){
            int middle=(start+end)/2;
            if(array[middle]>key){
                return binarysearch(array,key,start,middle-1);
            }
            else if(array[middle]<key){
                return binarysearch(array,key,middle+1,end);
            }
            else{
                return middle;
            }
        }
        else{
            return -1;
        }
    }
    
}
