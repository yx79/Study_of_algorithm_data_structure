/*

Design a data structure that supports the following two operations: addWord(word) and search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or ..

A . means it can represent any one letter.

 Notice

You may assume that all words are consist of lowercase letters a-z.


Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
Tags 
Trie
Related Problems 
Medium Implement Trie
*/



/*
[search("lintcode"), search("lint"), addWord("lint"), search("lint")]


*/
public class WordDictionary {
    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean end; 
        public TrieNode() { }
        public TrieNode(char c) {
            this.c = c;
            end = false;
        }
    }

    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (curChildren.containsKey(w[i])) {
                cur = curChildren.get(w[i]);
            } else {
                TrieNode newNode = new TrieNode(w[i]);
                curChildren.put(w[i], newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if (i == w.length - 1) {
                cur.end = true;
            }
            System.out.println(w[i]);
        }
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        if (root == null) {
            return false;
        }
        char[] s = word.toCharArray();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        for (int i = 0; i < s.length; i++) {
            if (children.containsKey(s[i])) {
                cur = children.get(s[i]);
                children = cur.children;
            }  
            if (s[i] == '.') {
                return true;
            }
        }
        return cur.end;
    }
    
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
