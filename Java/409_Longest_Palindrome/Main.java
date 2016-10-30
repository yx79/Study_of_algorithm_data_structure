/*
 * Copyright 2016 Yuanjie
 */
package pkg409_longest_palindrome;

/*
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

 
 */
public class Main {
    
    public static int longestPalindrome(String s) {
        char[] lower = new char[26];
        char[] upper = new char[26];
        int sum = 0;
        boolean isSingle = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c - 'a') >= 0) {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        
        for (int n : lower) {
            if (n > 0) {
                if (n % 2 == 0) {
                    sum += n;
                }
                else {
                    isSingle = true;
                    sum += n - 1;
                }
            } 
        }
        
        for (int n : upper) {
            if (n > 0) {
                if (n % 2 == 0) {
                    sum += n;
                }
                else {
                    isSingle = true;
                    sum += n - 1;
                }
            } 
        }
        if (isSingle) sum++;
        return sum;
    }

     
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(longestPalindrome("AAAAAAA"));
    }
    
}
