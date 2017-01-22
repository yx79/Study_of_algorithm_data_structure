 
package pkg069_sqrt;

/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Main {
    public static int sqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return left;
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sqrt(29));
    }
    
}
