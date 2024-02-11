package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindStringOccurance {

    void print(){
        String input = "iloveindia";
        String results[] = input.split("");
        //System.out.println("hello moto"+ Arrays.toString(results));

        Map<String, Long> collect = Arrays.stream(results).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);
    }

    void eachCharCount(){
        String str;
        int i, len, counter[] = new int[256];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string : ");
        str = scanner.nextLine();

        //String length
        len = str.length();

        // loop through the string
        // and count frequency of every character
        // and store it in counter array
        for (i = 0; i < len; i++) {
            counter[(int) str.charAt(i)]++;
        }

        // Print Frequency of characters
        for (i = 0; i < 256; i++) {
            if (counter[i] != 0) {
                System.out.println((char) i + " --> " + counter[i]);
            }
        }
    }

    public static void main(String[] args){
        FindStringOccurance fo = new FindStringOccurance();
        fo.print();
       // fo.eachCharCount();
    }
}
