/*
 * Copyright 2016 Yuanjie
 */
package pkg441_arrange_coins;

/**
 *
 * @author Pomme
 */
public class Main {

    public static int arrangeCoins(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long times = (long) n * 2;
        
        long row = (int) Math.sqrt(times);
        System.out.println("row : " + row);
        
        long right = row * (row + 1) / 2;
        System.out.println("right edge : " + right);
        if (n >= right) {
            return (int) row;
        } 
            
        else{
            return (int) row - 1;
        } 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(arrangeCoins(2147483647)); // 65535
        System.out.println(arrangeCoins(1804289383)); // 60070
        
    }
    
}
