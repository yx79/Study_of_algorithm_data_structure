/*
 * Copyright 2016 Yuanjie
 */
package pkg171_excelsheet_column_number;

/*
 
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 */
public class Main {

    public static int titleToNumber(String s) {
        int size = s.length();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += charToNum(s.charAt(i)) * Math.pow(26, size - i - 1);
        }
        return sum;
        
    }
    
    public static int charToNum(char c) {
        return c - 'A' + 1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AZZ"));
       
        
        
    }
    
    
}
