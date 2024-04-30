package org.example.java8.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamOperations {

    public static Boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i=2;i<= Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)  {

       List<Integer> numbers =  Arrays.asList(1,3,4,5,6,7,8,9,10,11);

       List<Integer> square = numbers.stream().map((x)-> x * x).collect(Collectors.toList());

       System.out.println("squares are:-"+square);


       List<Integer> evenNumbers = numbers.stream().filter((x)-> x%2 == 0).collect(Collectors.toList());

       System.out.println("evenNumbers are:-"+evenNumbers);

       List<Integer> oddNumbers = numbers.stream().filter((x)-> x%2 != 0).collect(Collectors.toList());

       System.out.println("oddNumbers are:-"+oddNumbers);


       List<Integer> primeNumbers = numbers.stream().filter(BasicStreamOperations::isPrime).collect(Collectors.toList());

       System.out.println("primeNumbers are:-"+primeNumbers);

       List<Integer> aseSortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

       System.out.println("sendingSortedNumbers are:-"+aseSortedNumbers);

        List<Integer> dseSortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("sendingSortedNumbers are:-"+dseSortedNumbers);






    }


}
