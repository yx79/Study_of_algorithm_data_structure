/*
 * Copyright 2016 Yuanjie
 */
package pkg190_reverse_bits;

/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 
00000010100101000001111010011100), return 964176192 (represented in binary as 
00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

Credits:
Special thanks to @ts for adding this problem and creating all test cases.


 */
public class Main {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        // 1010 --> 0101
         
        int result = 0;
        for (int i = 1; i < 32; i++) {
            result = result | (n & 1);
            n = n >> 1;
            result = result << 1;
        }
        // last 32 digit so no result << 1
        result = result | (n & 1);
        n = n >> 1;
            
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(reverseBits(43261596)); //964176192
    }
    
}
