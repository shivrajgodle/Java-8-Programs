package org.example.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicateElement {

    /**find duplicate elements from the string**/
    void duplicateElements(){
        String input = "iloveindiaandjava";

        List<String> duplicateElements = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("duplicates are:-"+duplicateElements);
    }

    /**find unique elements from the string**/
    void uniqueElements(){
        String input = "iloveindiaandjava";

        List<String> uniqueElements = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("duplicates are:-"+uniqueElements);
    }

    /**find first non repeat elements from the string**/
    void firstNonRepeatElements(){
        String input = "iloveindiaandjava";

        String ffElement = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1).findFirst().get().getKey();
        System.out.println("first non repeat element is:-"+ffElement);
    }

    /**find second highest element **/
    void findSecondHighestElements(){
        int[] numbers = {5,8,1,12,4,77,11};

       Integer i = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("i is-"+i);
    }


    /**find longest string from array **/
    void findLongestStringInArray(){
        String[] input = {"java","javascript","Angular", "SpringBoot","Microservices"};

        String s = Arrays.stream(input).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();

        System.out.println("Longest String is:-"+s);

    }


    /** find number from array which starts from 1 **/
    void findNumStartsWithOne(){
        int[] numbers = {5,8,1,12,4,77,11,22,21};

       List<String> str =   Arrays.stream(numbers).boxed()
                 .map(i -> i + "")
                 .filter(i -> i.startsWith("2"))
                 .collect(Collectors.toList());


        System.out.println("str is-"+str);
    }

    /** string join method **/
    void stringJoinMethod(){
        List<String> nums =   Arrays.asList("5","8","1","12","4");
        String result = String.join("|",nums);
        System.out.println("result is-"+result);
    }

    /** skip and limit example **/

    void skipAndLimitEx(){
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);

    }


    public static void main(String[] args){
        FindDuplicateElement fdo = new FindDuplicateElement();
        fdo.duplicateElements();
        fdo.uniqueElements();
        fdo.firstNonRepeatElements();
        fdo.findSecondHighestElements();
        fdo.findLongestStringInArray();
        fdo.findNumStartsWithOne();
        fdo.stringJoinMethod();
        fdo.skipAndLimitEx();
    }

}
