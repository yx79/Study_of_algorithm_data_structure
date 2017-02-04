/*
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true


*/


public class ConnectingGraph { 
    private int[] father = null;

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = 0;
        }
    }
    
    public int find(int x) {
        if (father[x] == 0) {
            return x;
        }
        // compress
        return  father[x] = find(father[x]);
    }

    public void connect(int a, int b) {
        // Write your code here
        int a_root = find(a);
        int b_root = find(b);
        if (a_root != b_root) {
            father[a_root] = b_root;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int a_root = find(a);
        int b_root = find(b);
        return a_root == b_root;
    }
}
