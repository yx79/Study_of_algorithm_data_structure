/*
 * Copyright 2016 Yuanjie
 */

package pkg346_movingaverfromdatastream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pomme
 */

public class MovingAverage {
    private int size;
    private int sum = 0;
    private Queue<Integer> q = new LinkedList<>();
    
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size() >= size) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
