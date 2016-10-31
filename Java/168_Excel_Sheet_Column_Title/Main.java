/*
 * Copyright 2016 Yuanjie
 */
package pkg168_excel_sheet_column_title;

/*
 Given a positive integer, return its corresponding column title as appear 
in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    1378  ->   AZZ
 */
public class Main {

    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();        
        while (n != 0) {
            int digit = n % 26;
            sb.insert(0, toTitle(digit));
            
            if (n % 26 == 0){
                n = (n - 26) / 26;
            } else {
                n = n / 26;
            }
        }
        return sb.toString();
    }
    
    public static String toTitle(int n) {
        String[] map = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", 
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
            "T", "U", "V", "W", "X", "Y"};
        return map[n];
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(convertToTitle(26)); // Z
        System.out.println(convertToTitle(27)); // AA
        System.out.println(convertToTitle(28)); // AB       
        System.out.println(convertToTitle(52)); // AZ
        System.out.println(convertToTitle(1378));  // AZZ
        System.out.println(convertToTitle(701));  // AZZ + 1 = BAA
    }
    
}
