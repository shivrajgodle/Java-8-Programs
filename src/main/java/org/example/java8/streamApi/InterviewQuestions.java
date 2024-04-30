package org.example.java8.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQuestions {

    public static void main(String[] args) {

        /**isteer question**/
        List<Student> students = Arrays.asList(new Student(1,"shivraj",45),
                new Student(2,"ganesh",85),new Student(3,"manisha",75));

        System.out.println(students);

        List<Student> collect = students.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).collect(Collectors.toList());

        Student student = collect.stream().skip(1).findFirst().get();

        System.out.println("student is:-"+student);

    }
}
