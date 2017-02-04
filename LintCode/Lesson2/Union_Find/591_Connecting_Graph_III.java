/*

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(), Returns the number of connected component in the graph


Example
5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3
*/


public class ConnectingGraph3 {
    
    private int[] father = null;
    private int count;
    
    public int find(int x) {
        if (father[x] == 0) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        count = n;
        
        for (int i = 1; i <= n; i++) {
            father[i] = 0;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
}
