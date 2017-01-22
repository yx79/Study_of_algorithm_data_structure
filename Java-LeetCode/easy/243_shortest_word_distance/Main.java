
package pkg243_shortest_word_distance;

/*

Given a list of words and two words word1 and word2, return the shortest 
distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are 
both in the list.


 */
public class Main {

    // O(n) time complexity
    // inplace 
    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int min = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                int temp = (index2 - index1) > 0 ? index2 - index1 : index1 - index2;
                if (min != 0) {
                    min = min > temp ? temp : min;
                } else {
                    min = temp;
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String[] words = {"Happy", "New", "Year"};
        String word1 = "Happy";
        String word2 = "Year";
        int ans = shortestDistance(words, word1, word2);
        System.out.print(ans);
    }
    
}
