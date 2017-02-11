/*

Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple 
(start, end, height)，where start is the start position on x-axis, end is the end position on 
x-axis and height is the height of the building. Buildings may overlap if you see them from far away，
find the outline of them。

An outline can be represented by a triple, (start, end, height), where start is the start position 
on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.


Notice

Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.

Example
Given 3 buildings：

[
  [1, 3, 3],
  [2, 4, 4],
  [5, 6, 1]
]
The outlines are：

[
  [1, 2, 3],
  [2, 4, 4],
  [5, 6, 1]
]

*/


import java.util.*;

/*

corner case to think:
[[4,67,187],[3,80,65],[49,77,117],[67,74,9],[6,42,92],[48,67,69],[10,13,58],[47,99,152],[66,99,53],[66,71,34],[27,63,2],[35,81,116],[47,49,10],[68,97,175],[20,33,53],[24,94,20],[74,77,155],[39,98,144],[52,89,84],[13,65,222],[24,41,75],[16,24,142],[40,95,4],[6,56,188],[1,38,219],[19,79,149],[50,61,174],[4,25,14],[4,46,225],[12,32,215],[57,76,47],[11,30,179],[88,99,99],[2,19,228],[16,57,114],[31,69,58],[12,61,198],[70,88,131],[7,37,42],[5,48,211],[2,64,106],[49,73,204],[76,88,26],[58,61,215],[39,51,125],[13,38,48],[74,99,145],[4,12,8],[12,33,161],[61,95,190],[16,19,196],[3,84,8],[5,36,118],[82,87,40],[8,44,212],[15,70,222],[16,25,176],[9,100,74],[38,78,99],[23,77,43],[45,89,229],[7,84,163],[48,72,1],[31,88,123],[35,62,190],[21,29,41],[37,97,81],[7,49,78],[83,84,132],[33,61,27],[18,45,1],[52,64,4],[58,98,57],[14,22,1],[9,85,200],[50,76,147],[54,70,201],[5,55,97],[9,42,125],[31,88,146]]



*/
public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    class Edge {
        int pos, h;
        boolean isStart;
        public Edge(int x, int height, boolean start) {
            pos = x;
            h = height;
            isStart = start;
        }
    }
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ans;
        }
        // 1 3 3
        // 2 4 4
        // 5 6 1
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return (int) b - (int) a;
            }
        });
        
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int start = buildings[i][0];
            int end = buildings[i][1];
            int height = buildings[i][2];
            list.add(new Edge(start, height, true));
            list.add(new Edge(end, height, false));
        }
        
        
        Collections.sort(list, new Comparator<Edge>(){
            @Override
            public int compare(Edge a, Edge b) {
                // pos from 0 to max ascending
                if (a.pos == b.pos) {
                    // both start edge descending
                    if (a.isStart && b.isStart) {
                        return b.h - a.h;
                    }
                    // both end ascending
                    if (!a.isStart && !b.isStart) {
                        return a.h - b.h;
                    }
                    // start (T) come before end (F)
                    return a.isStart ? -1 : 1;
                }
                return a.pos - b.pos;
            }
        });
        
        int left = list.get(0).pos;
        int right = list.get(list.size() - 1).pos;
        ArrayList<Integer> now = null;
        for (Edge e : list) {
            if (e.isStart) {
                if (maxHeap.isEmpty() || e.h > maxHeap.peek()) {
                    now = new ArrayList<Integer>(Arrays.asList(e.pos, e.h));
                    ans.add(now);
                }
                maxHeap.add(e.h);
            } else {
                maxHeap.remove(e.h);
                if (maxHeap.isEmpty() || e.h > maxHeap.peek()) {
                    if (maxHeap.isEmpty()) {
                        now = new ArrayList<Integer>(Arrays.asList(e.pos, 0));
                    } else {
                        now = new ArrayList<Integer>(Arrays.asList(e.pos, maxHeap.peek()));
                    }
                    ans.add(now);
                }
            }
        }
        
        return format(ans);
    }
    
    // Format the result to list.
    private ArrayList<ArrayList<Integer>> format(ArrayList<ArrayList<Integer>> data) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (data.size() > 0) {
            int start =  data.get(0).get(0);
            int height = data.get(0).get(1);
            for (int i = 1; i < data.size(); i++) {
                ArrayList<Integer> now = new ArrayList<>();
                int end = data.get(i).get(0);
                if (height > 0) {
                    now.add(start);
                    now.add(end);
                    now.add(height);
                    ans.add(now);
                }
                start = end;
                height = data.get(i).get(1);
            }
        }
        return ans;
    }
}
