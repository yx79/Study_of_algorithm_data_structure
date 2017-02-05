/**/


public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // corner case : ["ABCE","SFCS","ADEE"], "ABCB"
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != w[0]) {
                    continue;
                }
                if (check(i, j, 0, board, w, used) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean check(int i, int j, int index, char[][] board, char[] word, boolean[][] used) {
        if (index == word.length) {
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        int w = word.length;
        if (i < 0 || i >= m || j < 0 || j >= n || index < 0 || index >= w || used[i][j] == true) {
            return false;
        }
        
        if (board[i][j] != word[index]) {
            return false;
        } 
        
        
        
        used[i][j] = true;
            
        boolean ans = check(i + 1, j, index + 1, board, word, used) || check(i - 1, j, index + 1, board, word, used) || check(i, j + 1, index + 1, board, word, used) || check(i, j - 1, index + 1, board, word, used);
        
        if (ans == false) {
            used[i][j] = false;
            return false;
        } else {
            return true;
        }
        
    }
}
