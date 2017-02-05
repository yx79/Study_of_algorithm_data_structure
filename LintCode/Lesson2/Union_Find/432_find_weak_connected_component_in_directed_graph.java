/*
Find the number Weak Connected Component in the directed graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)

Sort the element in the set in increasing order



Example
Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}

*/


/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    // test case : {-3,-1,3#-1,2#2#3#5}
    /*
    class UnionFind2 {
        private int[] father = null;
        public UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                father[i] = 0;
            }
        }
        public int find(int x) {
            if (father[x] == 0) {
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
    */
    
    class UnionFind {
        private HashMap<Integer, Integer> map = new HashMap<>();
        public UnionFind (HashSet<Integer> set) {
            for (Integer label : set) {
                map.put(label, label);
            }
        }
        
        public int find(int x) {
            int parent = map.get(x);
            while (parent != map.get(parent)) {
                parent = map.get(parent);
            }
            return parent;
        }
        
        public int compressed_find(int x) {
            int parent = map.get(x);
            while (parent != map.get(parent)) {
                parent = map.get(parent);
            }
            int next;
            while (x != map.get(x)) {
                next = map.get(x);
                map.put(x, parent);
                x = next;
            }
            return parent;
        }
        
        public void union(int a, int b) {
            int root_a = compressed_find(a);
            int root_b = compressed_find(b);
            if (root_a != root_b) {
                map.put(root_a, root_b);
            }
        }
    }
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     * 
     * 
     * 
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        
        HashSet<Integer> set = new HashSet<>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
        }
        UnionFind union = new UnionFind(set);
        
        for (DirectedGraphNode node : nodes) {
            int cur = node.label;
            int root_c = union.compressed_find(cur);
            
            for (DirectedGraphNode neighbor : node.neighbors) {
                int neigh = neighbor.label;
                int root_n = union.compressed_find(neigh);
                if (root_c != root_n) {
                    union.union(root_n, root_c);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (DirectedGraphNode node : nodes) {
            int label = node.label;
            int root = union.compressed_find(label);
            if (!map.containsKey(root)) {
                List<Integer> list = new ArrayList<>();
                list.add(label);
                map.put(root, list);
            } else {
                map.get(root).add(label);
            }
        }
        
        for (Integer key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
