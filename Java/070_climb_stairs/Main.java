/*
 * Copyright 2016 Yuanjie
 */
package pkg70_climb_stairs;

import java.util.Scanner;

/**
 *
 * @author Pomme
 */
public class Main {
    
    public static long climbStairO2n(int n) {
        if (n < 1) {
            return 0;
        } 
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairO2n(n - 1) + climbStairO2n(n - 2);
    }
    
    /**
     * 思路：
     *这题和Fibonacci Number差不多，第n级台阶，可以由第n-1级台阶走一步到达，也可以由第n-2级台阶走两步到达。
     *由此我们可以得到递推式: F(n) = F(n-1)+F(n-2); 初始值F(1) = 1, F(2) = 2。
     * 
     * 思路非常简单，但是算法复杂度高得惊人，为O(2^n)， OJ超时。

我们发现：
1. 每调用递归函数一次，都要进行压栈操作。当n非常大的时候容易造成内存溢出-stackoverflow。
2. 很多计算是重复的，比如f(5)要计算f(4)和f(3), f(4)又要计算一次f(3)。
3. 所以动态规划（DP）思路就出来了，抓住递推式，解决子问题，储存子问题。
     */
    
/**
 * 在这个解法里，我们用一个数组存储之前计算过的值，i从3到n依次取出dp[i-1]和dp[i-2]的值相加，也就是到达当前台阶的方法数。
时间复杂度O(n), 空间复杂度O(n)。
 * @param n
 * @return 
 */
    public static long climbStairOnOn(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] nums = new long[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        
        return nums[n];
    }
    
    /**
     * 在这个解法中，对于台阶i: 3<=i<=n, prevOfprev是到达第i-2级台阶的方法数，prev是到达第i-1级台阶的方法数，
在进入第i+1级台阶之前，更新prev和prevOfprev。
跳出循环后，prev就是我们要求的第n级台阶的方法数。
时间复杂度O(n),空间复杂度O(1).
     * @param n
     * @return 
     */
    public static long climbStairOnO1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        
        int preOfpre = 1;
        int pre = 2;
        int result = 0;
        
        for (int i = 3; i < n + 1; i++) {
            int temp = preOfpre;
            preOfpre = pre;
            pre = temp + pre;
        }
        
        return pre;
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("O(2n) O(1): " + climbStairO2n(n));
        
        System.out.println("O(n) O(n): " + climbStairOnOn(n));
        
        System.out.println("O(n) O(1): " + climbStairOnO1(n));

    }
    
}
