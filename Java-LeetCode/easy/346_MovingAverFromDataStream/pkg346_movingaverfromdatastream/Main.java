 
package pkg346_movingaverfromdatastream;

/*

Given a stream of integers and a window size, calculate the moving average 
of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3


 */
public class Main {

    
    public static void main(String[] args) {
        // Your MovingAverage object will be instantiated and called as such:
        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        double param_1 = obj.next(1);
         obj.next(10);
        double param_3 = obj.next(3);
        double param_4 = obj.next(5);
        
        System.out.println(param_4);
    }
    
}
