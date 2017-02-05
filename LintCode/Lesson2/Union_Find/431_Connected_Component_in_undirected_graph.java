/*
Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a 
subgraph in which any two vertices are connected to each other by paths, 
and which is connected to no additional vertices in the supergraph.)


 Notice

Each connected component should sort by label.


Clarification
Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

Tags 
Breadth First Search Union Find
*/



/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
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
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            set.add(node.label);
        }
        UnionFind union = new UnionFind(set);
        
        for (UndirectedGraphNode node : nodes) {
            int cur = node.label;
            int root_c = union.compressed_find(cur);
            
            for (UndirectedGraphNode neighbor : node.neighbors) {
                int neigh = neighbor.label;
                int root_n = union.compressed_find(neigh);
                if (root_c != root_n) {
                    union.union(root_n, root_c);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (UndirectedGraphNode node : nodes) {
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
