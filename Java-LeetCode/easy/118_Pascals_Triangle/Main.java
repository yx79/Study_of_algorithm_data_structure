/*
 * Copyright 2016 Yuanjie
 */
package pkg118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/*
 
 Given numRows, generate the first numRows of Pascal's triangle.
 For example, given numRows = 5,
 return:
 
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 
 */
public class Main {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] args) {
        // TODO code application logic here
                
        System.out.println(generate(5));
    }
    
}
