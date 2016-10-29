/*
 * Copyright 2016 Yuanjie
 */
package pkg405_convert_number_to_hex;

/*
 405. Convert a Number to Hexadecimal
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.


Input:
26

Output:
"1a"


Input:
-1

Output:
"ffffffff"

*/
public class Main {
    
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        
        String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
            "a", "b", "c", "d", "e", "f"};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, map[num & 15]);
            num = num >>> 4;
        }
        return sb.toString();
    }
            
            
            

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("26 ---> " + toHex(26));
        
        
        System.out.println("-1 ---> " + toHex(-1));
        
        
    }
    
    
    
}
