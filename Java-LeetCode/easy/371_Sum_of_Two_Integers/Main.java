/*
 * Copyright 2016 Yuanjie
 */
package pkg371_sum_of_two_integers;

/*
 
371 Sum of two integers

Calculate the sum of two integers a and b, but you are not allowed to use 
the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 */
public class Main {

    public static int sum(int a, int b) {
        while ((a&b) != 0x00) {
            int x = (a&b) << 1;
            int y = a^b;
            a = x;
            b = y;
        }

        return a | b;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sum(2,3));
        System.out.println(sum(20,30));
        System.out.println(getSum(20,30));
        
    }
    
    public static int getSum(int a, int b) {
        while ((a & b) != 0x00) {//check carry bit
            final int x = (a & b) << 1;//same bit has carry
            final int y = (a ^ b);     //different bit
            a = x;
            b = y;
        }
        return a | b;
    }
    
    
}
