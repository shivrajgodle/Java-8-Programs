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


    public static void countDuplicateString(String str){
        HashMap<String , Integer> hm = new HashMap<>();

        for(String s : str.split("")){
            if(hm.containsKey(s)){
                hm.put(s,hm.get(s) +  1);
            }else{
                hm.put(s,1);
            }
        }
        System.out.println(hm);
    }

    public static void main(String[] args) {
        String str = "helloshivrajhowareyou";
        //countDuplicateCharectors(str);
        countDuplicateString(str);
    }
}
