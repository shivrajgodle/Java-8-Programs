package org.example.general;

import java.util.Scanner;

public class StringReverse {

    char[] StringRev(String s) {

        char[] c = s.toCharArray();

        char[] ch1 = new char[c.length];
        for (int i = c.length - 1; i > 0; i--) {
            ch1 = new char[]{c[i]};
        }
        return ch1;

    }

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();

        System.out.println("Enter any string:-");
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        System.out.println(sr.StringRev(st));

    }
}
