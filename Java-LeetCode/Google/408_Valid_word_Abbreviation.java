/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
*/


public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        //"internationalization"  "i5a11o1" true
        // "a"  "01" false
        char[] s = word.toCharArray();
        char[] abb = abbr.toCharArray();
        
        int i = 0, j = 0;
        while (i < s.length && j < abb.length) {
            if (s[i] == abb[j]) {
                i++;
                j++;
            } else {
                if (abb[j] <= '0' || abb[j] > '9') {
                    return false;
                } else {
                    int num = abb[j++] - '0';
                    while (j < abb.length && abb[j] >= '0' && abb[j] <= '9') {
                        num = num * 10 + (abb[j] - '0');
                        System.out.println(num);
                        j++;
                    }
                    i += num;
                 }
            }
        } 
        
        
        if (i == s.length && j == abb.length) {
            return true;
        } else {
            return false;
        }
    }
}
