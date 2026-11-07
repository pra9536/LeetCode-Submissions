/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode first = curr;
           ListNode second = curr.next;
        
        while(curr != null && curr.next != null) {
           first = curr;
           second = curr.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }
}