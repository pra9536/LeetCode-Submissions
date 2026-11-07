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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null) {
           ListNode temp = curr;
           curr = curr.next;
           if(curr != null && temp.val == curr.val) {
            while(curr != null && temp.val == curr.val) {
                curr = curr.next;
            }
            prev.next = curr;
           } else {
            prev = temp;
           }
        }
        return dummy.next;
    }
}