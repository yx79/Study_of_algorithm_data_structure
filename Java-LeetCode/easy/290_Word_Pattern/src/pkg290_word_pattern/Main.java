/*
 * Copyright 2016 Yuanjie
 */
package pkg290_word_pattern;

import java.util.HashMap;

/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a 
letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains 
lowercase letters separated by a single space.




 */
public class Main {

    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) { return false; }
        String[] list = str.split(" ");
        if (pattern.length() != list.length) { return false; }

        HashMap mapP = new HashMap();
        HashMap mapS = new HashMap();
        
        for (Integer i = 0; i < pattern.length(); i++) {
            char charP = pattern.charAt(i);
            String word = list[i];
            // if map.put(c, i) will return null if map doesn't conatin c, or last value of key c if exists.
            // the return value should be same if the pattern is the same;
            if (mapP.put(charP, i) != mapS.put(word, i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("aabb", "dog cat dog dog"));
        System.out.println(wordPattern("aabb", "cat cat dog dog"));
        
    }
    
}
