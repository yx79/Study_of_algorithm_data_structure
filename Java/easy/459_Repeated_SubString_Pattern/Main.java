/*
 * Copyright 2016 Yuanjie
 */
package pkg459_repeated_substring_pattern;

/**
 *
 * @author Pomme
 */
public class Main {

    
    
    public static boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        if (length <= 1) return false;
        boolean match = true;
        // try different length of substring, 1, 2, ... str.length()/2
        for (int sub = 1; sub <= length / 2; sub++) {
            //System.out.println("sub " + sub);
            match = true;
            // if length % sub != 0, then there this sub is not working, move to sub+1
            if (length % sub == 0) {
                // two pointer i, j to check charAt (i, i+j) same or not
                for (int i = sub; i <= length - sub; i += sub) {
                    for (int j = 0; j < sub; j++) {
                        if (str.charAt(j) != str.charAt(i + j)) {
                            //System.out.println("sub:" + sub + ", i=" + i + " :" + str.charAt(j) + ", j=" + j + " :" + str.charAt(i + j));
                            match = false;
                            break;
                        }
                    }
                    // not matching, break to move to next sub+1
                    if (!match) {
                        break;
                    }
                }
                if (match) {
                    // flag is still false, after go through with a sub number than substring length is sub
                    return true;
                }
                
            }
        }
        return false;
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abcdabcdabcdabcd"));
        System.out.println(repeatedSubstringPattern("ababac"));
        System.out.println(repeatedSubstringPattern("aa"));
    }
    
}
