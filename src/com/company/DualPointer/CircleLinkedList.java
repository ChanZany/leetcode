package com.company.DualPointer;

/**
 * @Author ChanZany
 * @Date 2021/7/2 19:28
 * @Version 1.0
 */
public class CircleLinkedList {
    public ListNode detectCycle(ListNode head) {
         ListNode slow = head, fast = head;
         do{
             if(fast == null || fast.next == null) return null;
             fast = fast.next.next;
             slow = slow.next;
         }while (slow != fast);     //first counter
         fast = head;
         while (slow != fast){
             fast = fast.next;
             slow = slow.next;
         }
         return fast;
    }
}
