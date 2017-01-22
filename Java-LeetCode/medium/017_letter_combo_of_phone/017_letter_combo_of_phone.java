/*
 * Copyright 2016 Yuanjie
 */
package pkg017_letter_combo_of_phone;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pomme
 */
public class Main {

    public static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();

        if (digits.length() == 0 || digits == null) {
            return list;
        }
        HashMap map = new HashMap();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        char[] nums = digits.toCharArray();
        list.add("");
        
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] - '0'; // ex: 2
            String value = (String) map.get(curr); // ex: "abc"
            list = addComb(value, list);
            //System.out.println(value);
        }
        return list;
    }
    
    public static List<String> addComb(String value, List<String> list) {
        char[] arr = value.toCharArray(); 
        List<String> temp = new LinkedList<>();
        while (!list.isEmpty()) {
            String pre = list.remove(0);
            for(int i = 0; i < arr.length; i++) {
                temp.add(pre + arr[i]);
                //System.out.println(pre + arr[i]);
            }
        }
        return temp;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> ans = letterCombinations("234");
       
        for (String s : ans) {
            System.out.println(s);
        }
        
        
    }
    
}
