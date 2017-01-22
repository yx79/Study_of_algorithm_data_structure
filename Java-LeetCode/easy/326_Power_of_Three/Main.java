/*
 * Copyright 2016 Yuanjie
 */
package pkg326_power_of_three;

import java.util.HashSet;

/*
326. Power of Three
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

3    9      27  
11   1001   11011 

5    7
101  111


*/
public class Main {

    // hashset calculate the list
    public static boolean isPowerThree1(int n) {
        int powerThree = 0;
        int i = 0;
        HashSet<Integer> set = new HashSet();
        while (powerThree < Integer.MAX_VALUE) {
            powerThree = (int) Math.pow(3, i);
            set.add(powerThree);
            i++;
        }        
        return set.contains(n);
       
    }
    
    // math method
    public static boolean isPowerThree2(int n) {
        //System.out.println(Math.log10(n) / Math.log10(3));
        //System.out.println(Math.log10(n) / Math.log10(3) % 1);
        return (Math.log10(n) / Math.log10(3) % 1 == 0);
    }
    
    public static void main(String[] args) {
        System.out.println(isPowerThree1(27));
        System.out.println(isPowerThree1(243));
        System.out.println(isPowerThree2(243));
        System.out.println(isPowerThree2(81));

    }
    
}
