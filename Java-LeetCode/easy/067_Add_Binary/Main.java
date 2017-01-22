/*
 * Copyright 2016 Yuanjie
 */
package pkg067_add_binary;

/*67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class Main {

    public static String addBinary(String a, String b) {
        
        char[] ac = a.toCharArray();
        int aIndex = a.length() - 1;
        
        char[] bc = b.toCharArray();
        int bIndex = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        
        // 100  
        //  10
        // 110
        
        int pre = 0;
        int curr = 0;
        
        // the part a and b overlap
        while (aIndex >= 0 && bIndex >= 0) {
            if (pre == 1) {
                curr = 1;
                pre = 0;
            } else {
                curr = 0;
            }
            
            if (ac[aIndex] == '1' && bc[bIndex] == '1') {
                pre += 1;
            } else if (ac[aIndex] == '1' || bc[bIndex] == '1') {
                curr += 1;
            }
            // curr == 2, the pre++, curr == 0
            if (curr > 1) {
                pre += 1;
                curr = 0;
            }
            sb.insert(0, curr);
            aIndex--;
            bIndex--;
        }
        
        // a is longer
        while (aIndex >= 0) {
            if (pre == 1) {
                curr = 1;
                pre = 0;
            } else {
                curr = 0;
            }
            
            if (ac[aIndex] == '1') {
                curr += 1;
            } 
            
            if (curr > 1) {
                pre += 1;
                curr = 0;
            }
            sb.insert(0, curr);
            aIndex--;
        }
        
        // b is longer
        while (bIndex >= 0) {
            if (pre == 1) {
                curr = 1;
                pre = 0;
            } else {
                curr = 0;
            }
            
            if (bc[bIndex] == '1') {
                curr += 1;
            } 
            
            if (curr > 1) {
                pre += 1;
                curr = 0;
            }
            sb.insert(0, curr);
            bIndex--;
        }
        
        if (pre == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(addBinary("101","1"));
        
        System.out.println(addBinary("1","11"));

        
    }
    
}
