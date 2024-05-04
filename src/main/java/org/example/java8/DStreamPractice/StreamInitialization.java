package org.example.java8.DStreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamInitialization {

    public static void main(String[] args) {
        //using list
        List<String> list = List.of("one","two","three","four","five");
        Stream<String> stream1 = list.stream();

        //using array
        String str[] = {"one","two","three","four","five"};
        Stream<String> stream2 = Arrays.stream(str);

        //stream method
        Stream<String> stream3 = Stream.of("one","two","three","four","five");

        //Stream generate
        Stream<String> stream4 = Stream.generate(()-> "one");

        //builder pattern for stream
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream5 = builder.add("one").add("two").add("three").build();

        //Empty Stream
        Stream<String> stream6 = Stream.empty();


    }


}
