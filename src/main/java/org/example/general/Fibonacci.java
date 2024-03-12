package org.example.general;

public class Fibonacci {

    int n = 10 , firstTerm = 0 , secondTerm = 1;


    void fiboForLoop(){
       System.out.println("Creating fibonacci with "+ n +"terms");
       for(int i = 0; i < n; i++) {
           System.out.print(" " + firstTerm);
           int nextTerm = firstTerm + secondTerm;
           firstTerm = secondTerm;
           secondTerm = nextTerm;
       }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.fiboForLoop();
    }
}
