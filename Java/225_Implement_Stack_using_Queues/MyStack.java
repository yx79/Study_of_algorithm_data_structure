/*
 * Copyright 2016 Yuanjie
 */

package pkg225_implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pomme
 */

public class MyStack {
    Queue<Integer> q = new LinkedList<>();
    //Queue<Integer> b = new LinkedList<>();
    
    // 1 2 3 4
    public void push(int x) {        
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }
    
    public void pop() {
        q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }

}
