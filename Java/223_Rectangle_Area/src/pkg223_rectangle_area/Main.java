/*
 * Copyright 2016 Yuanjie
 */
package pkg223_rectangle_area;

/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner 
as shown in the figure.

https://leetcode.com/static/images/problemset/rectangle_area.png

Assume that the total area is never beyond the maximum possible value of int.

Credits:
Special thanks to @mithmatt for adding this problem, creating the above image 
and all test cases.
 
 */
public class Main {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int twoRect =  (C - A) * (D - B) + (G - E) * (H - F);
        int overlap = 0;
        
        // consider   A, C, E, G in one dimension, is there overlap?
        // A------C 
        //     E-------G
        int left = Math.min(Math.max(A, E), C);
        int right = Math.max(Math.min(C, G), A);
        
        // consider  B, D, H, F in one dimension, is there overlap?
        // B---------D
        //     F---------H
        int top = Math.max(Math.min(H, D), F);
        int bottom = Math.min(Math.max(B, F), H);
        
        overlap = (right - left) * (top - bottom);
        
        return twoRect - overlap;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2)); // 16
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));   // 45
        System.out.println(computeArea(-3,0,0,5,0,0,3,5));   // 30
    }
    
}
