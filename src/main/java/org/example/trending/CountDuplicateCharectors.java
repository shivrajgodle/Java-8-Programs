package org.example.trending;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateCharectors {

    public static void countDuplicateCharectors(String str){
        Map<Character,Integer> map = new HashMap<Character, Integer>();

        char[] chars = str.toCharArray();

        for(char c : chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + ":"+entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String str = "helloshivrajhowareyou";
        countDuplicateCharectors(str);
    }
}
