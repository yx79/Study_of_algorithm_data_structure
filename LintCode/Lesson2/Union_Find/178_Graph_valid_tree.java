/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

 Notice

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.


Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.


Tags 
Depth First Search Facebook Zenefits Union Find Breadth First Search Google
*/




public class Solution {
    class UnionFind {
        private int[] father = null;
        public UnionFind(int n) {
            father = new int[n]; 
            for (int i = 0; i < n; i++) {
                father[i] = -1;
            }
        }
        public int find(int x) {
            if (father[x] == -1) {
                return x;
            }
            return father[x] = find(father[x]);
        }
        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && (edges == null || edges.length == 0)) {
            // corner case 1, []
            return true;
        }
        if (edges == null || edges.length == 0) {
            // corner case 2, []
            return false;
        }
        // Write your code here
        UnionFind union = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int root_a = union.find(a);
            int root_b = union.find(b);
            if (root_a != root_b) {
                union.union(a, b);
            } else {
                return false;
            }
        }
        // all node should be linked
        // corner case 3, [[0,1]]
        int root = union.find(0);
        for (int i = 1; i < n; i++) {
            if (root != union.find(i)) {
                return false;
            }
        }
        return true;
        
    }
}
