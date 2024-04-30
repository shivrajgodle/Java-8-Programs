package org.example;

//Array = [3, 5, 4, 8, 11, 1, -1, 6, 2]
//Target Sum = 10
//Result = [-1,11], [8,2]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayAddition {

    List<Integer[]> processArray(Integer[] arr, int targetSum){
        List<Integer[]> newlist = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int temp = 0;
            for(int j=i+1;j<arr.length;j++){
                temp = arr[i] + arr[j];
                if(temp == targetSum){
                    int num1 = arr[i];
                    int num2 = arr[j];

                    newlist.add(new Integer[]{num1, num2});
                }
            }
        }
        return newlist;
    }


    public static void main(String args[]){
        ArrayAddition aa = new ArrayAddition();
        Integer arr [] = {3, 5, 4, 8, 11, -1, 1, 6, 2,9};
        int targetSum = 10;

         List<Integer[]> processedArr = aa.processArray(arr,targetSum);

         for(Integer[] i : processedArr){
             System.out.println(Arrays.stream(i).toList());
         }
    }

}
