/*
 * Copyright 2016 Yuanjie
 */

package pkg155_min_stack;

import java.util.Stack;

/**
 * @author Pomme
 */

public class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public MinStack() {
        
    }
    
    
    public void push(int x) {
        s1.push(x);
        s2.push(Math.min(x, s2.size() > 0 ? s2.peek() : x));
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
