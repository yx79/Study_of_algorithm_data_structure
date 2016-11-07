/*
 * Copyright 2016 Yuanjie
 */
package pkg155_min_stack;

/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 */
public class Main {

    public static void main(String[] args) {
        MinStack minS = new MinStack();
        minS.push(3);
        minS.push(5);
        minS.push(4);
        System.out.println(minS.getMin());
        minS.pop();
        minS.push(1);
        System.out.println(minS.getMin());
    }
    
}
