/*
 * Copyright 2016 Yuanjie
 */
package pkg401_binary_watch;

import java.util.ArrayList;
import java.util.List;

/*


A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
11:59
1 2 8, 1 2 8 16 32
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, 
it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, 
for example "10:2" is not valid, it should be "10:02".
 */


public class Main {

    public static List<String> readWatch(int num) {
        List<String> ans = new ArrayList<>();
        if (num == 0) {
            ans.add("0:00");
            return ans;
        }
        if (num > 8) {
            return ans;
        }
         
        for (int h = 0; h < 12; h++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(h) + Integer.bitCount(min) == num) {
                    String time = h + ((min < 10) ? ":0" : ":") + min;
                    
                    
                    ans.add(time);
                }
            }
        }
        
        
        
        return ans;
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(readWatch(1));
    }
    
}
