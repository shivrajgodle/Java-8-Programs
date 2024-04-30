package org.example.general.anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:-");
        String s1 = sc.next();

        System.out.println("Enter second string:-");
        String s2 = sc.next();

        if(s1.length() == s2.length()) {

            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            boolean result = Arrays.equals(ch1,ch2);

            if(result) {
                System.out.println("Both strings are Anagram");
            }else {
                System.out.println("Both strings are not Anagram");
            }
        }
        else {
            System.out.println("Both strings are not Anagram");
        }


        System.out.println("first string:- " + s1 +" Second string:- "+ s2);

    }
}
