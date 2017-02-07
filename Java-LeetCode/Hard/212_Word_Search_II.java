/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/



public class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    // build Trie dictionary
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //System.out.print(c);
                int index = c - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.word = word;
         }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, ans);
            }
        }
        return ans;
    }
    public void dfs(int i, int j, char[][] board, TrieNode p, List<String> ans) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        
        char c = board[i][j];
        int index = c - 'a';
        p = p.next[index];
        if (p == null) {
            return;
        }
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        dfs(i + 1, j, board, p, ans);
        dfs(i - 1, j, board, p, ans);
        dfs(i, j + 1, board, p, ans);
        dfs(i, j - 1, board, p, ans);
        board[i][j] = c;
    }
}
