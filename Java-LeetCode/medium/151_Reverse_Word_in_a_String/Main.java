 
package pkg151_reverse_word_in_a_string;
/*

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class Main {

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) continue;
            System.out.println("*" + str[i] + "*");
            sb.append(str[i]);
            if (i != 0 && str[i] != null) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "the sky is blue";
        
                
        System.out.println(reverseWords(str));
        
        String str1 = " 1";
        System.out.println(reverseWords(str1));
        
        String str2 = "a   b";
        System.out.println(reverseWords(str2));
    }
    
}
