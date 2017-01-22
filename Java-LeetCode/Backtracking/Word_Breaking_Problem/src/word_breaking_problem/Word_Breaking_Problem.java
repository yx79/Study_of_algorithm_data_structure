
package word_breaking_problem;

import java.util.HashSet;

/*

Objec­tive : Given an string and a dic­tio­nary of words, find out if the 
input string can be bro­ken into a space-separated sequence of one or 
more dic­tio­nary words.

Exam­ple:

dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]

String = "IamSumit"

Output: "I am Sumit"

String ="thisisadog"

Output : String can't be broken

 */
public class Word_Breaking_Problem {
    private static String result;
    public static void wordBreak(String s, HashSet<String> set) {
        if (word(s, set, "")) {
            System.out.println(result);
        } else {
            System.out.println("String can't be broken.");
        }
    }
    
    public static boolean word(String s, HashSet<String> set, String answer) {
        if (s.length() == 0) { 
            result = answer;
            return true; 
        }
        else {
            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);
                if (set.contains(word)) {
                    if (word(s.substring(index + 1), set, answer + word + " ")) {
                        return true;
                    } else {
                        index++;
                    }
                } else {
                    index++;
                }
            }
            return false;
        }
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "IamSumit";
        HashSet<String> set = new HashSet<>();
        set.add("I");
        set.add("am");
        set.add("Sumit");
        wordBreak(s, set);
    }
    
}
