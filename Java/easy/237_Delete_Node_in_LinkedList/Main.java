/*
 * Copyright 2016 Yuanjie
 */
package pkg237_delete_node_in_linkedlist;

/*
Write a function to delete a node (except the tail) in a singly linked list, 
given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third 
node with value 3, the linked list should become 1 -> 2 -> 4 
after calling your function.
 
 */
public class Main {

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
        
        deleteNode(second);
        System.out.println("\nAfter Deleting: ");
        
        ListNode pointer1 = head;
        while (pointer1 != null) {
            System.out.print(pointer1.val + " ");
            pointer1 = pointer1.next;
        }
        
    }
    
}
