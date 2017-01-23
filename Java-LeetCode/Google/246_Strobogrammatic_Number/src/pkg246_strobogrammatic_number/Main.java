
package pkg246_strobogrammatic_number;

/*

A strobogrammatic number is a number that looks the same when rotated 
180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number 
is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.


Company Tags Google

Tags Hash Table Math

Similar Problems (M) Strobogrammatic Number II (H) Strobogrammatic 
Number III


 */
public class Main {

    public static boolean isStrobogrammatic(String num) {
        int[] dic = new int[10];
        dic[0] = 0;
        dic[1] = 1;
        dic[2] = -1;
        dic[3] = -1;
        dic[4] = -1;
        dic[5] = -1;
        dic[6] = 9;
        dic[7] = -1;
        dic[8] = 8;
        dic[9] = 6;
        
        char[] number = num.toCharArray();
        for (int i = 0; i <= number.length / 2; i++) {
            int left = number[i] - '0';
            int right = number[number.length - 1 - i] - '0';

            if (dic[left] == -1 || dic[right] == -1) {
                return false;
            }
            if (dic[left] != right) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("181"));
    }
    
}
