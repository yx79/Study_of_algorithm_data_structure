/*
 * Copyright 2016 Yuanjie
 */
package pkg252_meeting_room;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Pomme
 */
public class Main {

    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 1) return true;
        int[] list = new int[intervals.length * 2];
        HashMap map = new HashMap();
        
        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i].start;
            int e = intervals[i].end;
            list[2 * i] = s;
            list[2 * i + 1] = e;
            map.put(s, e);
        }
        
        Arrays.sort(list);
        
        for (int i = 0; i < list.length; i += 2) {
            int val = (int) map.get(list[i]);
            if (val != list[i + 1]) {
                return false;
            }
        }
        
        return true;
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Interval[] intervals = {new Interval(0, 3), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(canAttendMeetings(intervals));
    }
    
}
