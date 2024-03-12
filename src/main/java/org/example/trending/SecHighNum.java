package org.example.trending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecHighNum {

    //second highest logic by normal array manipulation
    public static int getSecondHighestNumberByArray(int[] arr , int total){
        int temp = 0;

        for(int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[total-2];
    }

    //logic by sort inbuilt function

    public static int getSecondHighestNumberBySort(int[] arr , int total){
        Arrays.sort(arr);
        return arr[total-2];
    }

    //second highest logic by collections
    public static int getSecondHighestNumberByCollections(Integer[] arr , int total){
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);
        int element = list.get(total - 2);
        return element;
    }

    public static void main(String[] args){

        int[] a = {1,5,12,8,3,9};
        int[] b = {41,5,12,28,35,91,7,22};

        System.out.println("Second highest num is:-"+getSecondHighestNumberBySort(a,6));
        System.out.println("Second highest num is:-"+getSecondHighestNumberBySort(b,8));

        Integer[] aa = {1,5,12,8,3,9};
        Integer[] bb = {41,5,12,28,35,91,7,22};

        System.out.println("Second highest num is:-"+getSecondHighestNumberByCollections(aa,6));
        System.out.println("Second highest num is:-"+getSecondHighestNumberByCollections(bb,8));

    }

}
