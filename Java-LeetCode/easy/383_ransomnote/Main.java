/*
 * Copyright 2016 Yuanjie
 */
package pkg383_ransomnote;

import java.util.ArrayList;
import java.util.List;

/*
 
 383. Ransom Note
 
 https://leetcode.com/problems/ransom-note/
 
 
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 
 Each letter in the magazine string can only be used once in your ransom note.
 
 Note:
 You may assume that both strings contain only lowercase letters.
 
 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 
 */
public class Main {

    
    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] abc = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char curr = magazine.charAt(i);
            abc[curr - 'a']++;
            System.out.println(abc[curr - 'a']);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ransomCurr = ransomNote.charAt(i);
            abc[ransomCurr - 'a']--;
            System.out.println(abc[ransomCurr - 'a']);
            if (abc[ransomCurr - 'a'] < 0) {
                return false; 
            }
        }
        return true;
    }
    
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        
        List<Character> list = new ArrayList<>();
        for (Character ch : magazine.toCharArray()) {
            list.add(ch);
        }
        for (Character ch : ransomNote.toCharArray()) {
            if (list.contains(ch)) {
                list.remove(ch);
            } else {
                return false;
            }
            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(canConstruct1("aa","abaaaaaaaaaa"));
        System.out.println(canConstruct2("aa","abaaaaa"));
    }
    
}
