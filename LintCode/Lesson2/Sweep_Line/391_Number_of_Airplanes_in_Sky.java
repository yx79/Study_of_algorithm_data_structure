/*
Interval 


Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3

*/


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     * 
     * 
     * test case : [[10,14],[10,15],[10,16],[1,10],[2,10],[3,10],[4,10]]
     */
    public class Pair {
        int time;
        boolean flying;
        public Pair(int time, boolean flying) {
            this.time = time;
            this.flying = flying;
        }
    } 
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        int size = airplanes.size() * 2;
        Pair[] time = new Pair[size];

        for (int i = 0; i < size; i+= 2) {
            time[i] = new Pair(airplanes.get(i / 2).start, true);
            time[i + 1] = new Pair(airplanes.get(i / 2).end, false);
        }
        
        Arrays.sort(time, new Comparator<Pair>() {
            @Override
            // check the landing first
            public int compare(Pair a, Pair b) {
                if (a.time == b.time) {
                    int aFly = a.flying == true ? 1 : 0;
                    int bFly = b.flying == true ? 1 : 0;
                    // false before true, landing first
                    return aFly - bFly;
                }
                return a.time - b.time;
            }
        });
        int count = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (time[i].flying == false) {
                count--;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
