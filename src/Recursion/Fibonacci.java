package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int fib = fibo(n);
        System.out.println("result : "+fib);

    }

    static int fibo(int n){
        if(n==1 || n == 0) {
         return n;
        }
        
        return fibo(n-1) + fibo(n-2);
    }


}
