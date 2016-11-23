/*
 * Copyright 2016 Yuanjie
 */
package pkg136_singlenumber;

import java.util.HashMap;

/**
 *
 * @author Pomme
 */
public class Main {
 
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.remove(n);
            } else {
                map.put(n, 1);
            }
            System.out.print(n + "  ");
        }
        return (int) map.keySet().toArray()[0];
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 2, 4, 5, 1, 2, 5};
        System.out.println("\n" + singleNumber(nums));
    }
    
}
