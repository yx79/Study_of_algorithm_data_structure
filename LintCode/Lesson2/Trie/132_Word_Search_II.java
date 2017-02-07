/*
Given a matrix of lower alphabets and a dictionary. 
Find all words in the dictionary that can be found in the matrix. 
A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

Example
Given matrix:
doaf
agai
dcan
and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


dog:
doaf
agai
dcan

dad:
doaf
agai
dcan

can:
doaf
agai
dcan

again:
doaf
agai
dcan

Challenge 
Using trie to implement your algorithm.

Tags 
LintCode Copyright Airbnb Trie
*/


public class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        TrieNode root = buildTrie(words);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, ans);
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j, char[][] board, TrieNode p, ArrayList<String> ans) {
        if (i < 0 || i >= board.length || j < 0|| j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        int index = c - 'a';
        if (p.next[index] == null) {
            return;
        } 
        p = p.next[index];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        dfs(i + 1, j, board, p, ans);
        dfs(i - 1, j, board, p, ans);
        dfs(i, j - 1, board, p, ans);
        dfs(i, j + 1, board, p, ans);
        board[i][j] = c;
    }
}
