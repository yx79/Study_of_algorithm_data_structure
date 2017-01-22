/*
 * Copyright 2016 Yuanjie
 */
package pkg232_implement_queue_using_stacks;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push 
to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may 
simulate a stack by using a list or deque (double-ended queue), as long as 
you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek 
operations will be called on an empty queue).

 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.peek());
        // q 1, 2, 3
        q.pop();
        // q.pop();
        System.out.println(q.peek());
    }
    
}
