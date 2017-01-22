/*
 * Copyright 2016 Yuanjie
 */

package pkg232_implement_queue_using_stacks;

import java.util.Stack;

/**
 * @author Pomme
 */

public class MyQueue {

    
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    // S: 1 -> 2 1 -> 3 2 1 peak 3
    // Q: 1 -> 1 2 -> 1 2 3 peak 1
    public void push(int x) {
        // s1 :  1 2 3 -> 4 1 2 3 we want  1 2 3 4
        while (!s1.isEmpty()) {
            // s2 : 1 -> 2 1 -> 3 2 1
            s2.push(s1.pop());
        }
        // s1 :  empty -> 4
        s1.push(x);
        
         // s1 :  4 -> 3 4 -> 2 3 4 -> 1 2 3 4
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }
    
    public void pop() {
        s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean isEmpty() {
        return s1.isEmpty();
    }
            
}
