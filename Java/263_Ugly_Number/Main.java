/*
 * Copyright 2016 Yuanjie
 */
package pkg263_ugly_number;

/**
 *
 * @author Pomme
 */
public class Main {

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5; 
        }
        if (n == 1) return true;
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isUgly(21));
        System.out.println(isUgly(6));
        System.out.println(isUgly(123));
        System.out.println(isUgly(234));
        System.out.println(isUgly(23));
        System.out.println(isUgly(45));
      
        
        
    }
    
}
