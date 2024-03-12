package org.example.general;

public class FiboRecursion {

    public static int fibo(int i){
        if(i == 0){
            return 0;
        }

        if(i == 1 || i == 2){
            return 1;
        }

        return fibo(i - 1) + fibo(i - 2);
    }

    public static void main(String[] args) {
        int fiboLength = 9;
        for(int i=0; i< fiboLength;i++) {
            System.out.print(" "+fibo(i));
        }
    }
}
