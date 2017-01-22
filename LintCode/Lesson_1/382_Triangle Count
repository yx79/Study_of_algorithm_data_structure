/*

 Triangle Count

Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Have you met this question in a real interview? Yes
Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
Tags 
Two Pointers LintCode Copyright
Related Problems 
Medium 3Sum 20 %
Medium Two Sum 28 %

*/


public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int count = 0;
        for (int i = S.length - 1; i > 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (S[j] + S[k] > S[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
        
    }
}
