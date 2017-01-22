/*
 * Copyright 2016 Yuanjie
 */

package pkg170_two_sum_iii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pomme
 */

public class TwoSum {
    List<Integer> list = new LinkedList();
    HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    list.add(number);
	    if (map.containsKey(number)) {
	        map.put(number, 1 + (int) map.get(number));
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Integer curr : list) {	        
	        int num = value - curr;
	        if (map.containsKey(num)) {
                    map.put(curr, (int) map.get(curr) - 1);
                    if ((int) map.get(num) > 0) {
                        map.put(curr, (int) map.get(curr) - 1);
                        return true;
                    }
	            
	        } 
                map.put(curr, (int) map.get(curr) - 1);
	    }
	    return false;
	}
}
