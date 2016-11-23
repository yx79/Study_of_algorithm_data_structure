/*
 * Copyright 2016 Yuanjie
 */
package pkg038_countandsay;

/*
38. Count and Say


The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.



 */
public class Main {

    public static String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        String[] str = new String[n];
        str[0] = "1";
        str[1] = "11";
        for (int i = 2; i < n; i++) {
            str[i] = countSay(str[i - 1]);
            //System.out.println(str[i]);
        }
        return str[n - 1];
    }
    
    public static String countSay(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            int count = 1;
            while (i < (s.length() - 1) && c == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(c);
            if (i == s.length() - 1) {
                return sb.toString();
            }
        }
        // last one != last second
        sb.append(1);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(countAndSay(5)); // 111221
        System.out.println(countAndSay(4)); // 1211
        System.out.println(countAndSay(6)); // 312211
        
    }
    
}
