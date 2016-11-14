/*
 * Copyright 2016 Yuanjie
 */
package Valid_Parentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Pomme
 */
public class Valid_Parentheses {

    public static boolean isValid(String s) {
       if (s.length() % 2 == 1) return false;
       HashMap map = new HashMap();
       map.put('(', ')');
       map.put('[',']');
       map.put('{', '}');
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (map.containsKey(c)) {
               stack.add(c);
           } else {
               if (stack.isEmpty()) {
                   return false;
               } 
               
               Character last = stack.pop();
               //System.out.print(last);
               if (!map.get(last).equals(c)) {
                   // ']' should be same as '[' value ']'
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isValid("({)}"));
        
        System.out.println(isValid("({})()[][]"));
        
    }
    
}
