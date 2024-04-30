package org.example.java8.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaTechieStream {

    public static void main(String[] args){

        /**Count Frequent chars in given string**/
        String input = "firekbaarmodisarkar";
        Map<String, Long> str = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(str);


        /**Find Duplicate chars in given string**/

        List<String> duplicateCharectors = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicateCharectors is:-"+duplicateCharectors);

        /**Find unique chars in given string**/

        List<String> uniqueElements = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        System.out.println("uniqueElements is:-"+uniqueElements);


    }


}
