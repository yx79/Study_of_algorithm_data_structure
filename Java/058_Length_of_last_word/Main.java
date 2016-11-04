/*
 * Copyright 2016 Yuanjie
 */
package pkg58_length_of_last_word;

/*
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.


 */
public class Main {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) { return 0; }
        int size = s.length();
        int sum = 0;
        boolean isChar = false;
        for (int i = size - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                sum++;
                isChar = true;
            } else if (c == ' ' && isChar == false) {
                continue;
            } else {
                return sum;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(lengthOfLastWord("Hello ws orld "));
    }
    
}
