/*
 * Copyright 2016 Yuanjie
 */
package pkg125_valid_palindrome;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.




*/
public class Main {

    // Time O(n^2) Space O(n)
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1 || s == null) return true;
        
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < s.length(); i++) {
            Character checked = toLower(s.charAt(i));
            if (checked != null) {
                sb.append(toLower(checked));
            }
        }
        String str = sb.toString();
        
        StringBuffer sb1 = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb1.append(str.charAt(i));
        }
        String reverse = sb1.toString();
        
        //System.out.println("Original: " + str);
        //System.out.println("Reverse: " + reverse);

        return str.equals(reverse);
    }
       
    
    
    public static Character toLower(char input) {
        int n = input - 0;
        // a 97 z 122, A 65, Z 90; '0'=48, '9'=57
        if (n >= 97 && n <= 122) {
            return input;
        } else if(n >= 65 && n <= 90) {
            char output = (char) (n + 32);
            return output;
        } else if (n >= 48 && n <= 57) {
            return input;
        }
        else {
            return null;
        }
    }
    
    
    // two pointer method
    // Time O(n), space O(1)
    public static boolean isPalindrome2(String s) {
        if (s.length() <= 1 || s == null) return true;
        int size = s.length();
        
        int i = 0, j = size - 1;
        
        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            while (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
                
            if (i <= j && (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))) {
                    
                return false;
            } 
                
            i++;
            j--;
         
        }        
        
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isPalindrome("11abccba11"));
        System.out.println(isPalindrome("XzAAMMMMMAA"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        
        
        System.out.println(isPalindrome2("11abccba11"));
        System.out.println(isPalindrome2("XzAAMMMMMAA"));
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }
    
}
