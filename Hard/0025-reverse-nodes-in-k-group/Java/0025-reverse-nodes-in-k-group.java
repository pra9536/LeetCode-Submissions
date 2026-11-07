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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;
        while(size >= k) {
            ListNode temp = curr;
             ListNode prev2 = null;
            for(int j = 0; j<k; j++){
                ListNode next = curr.next;
                curr.next = prev2;
                prev2 = curr;
                curr = next;
            }
            prev.next = prev2;
            temp.next = curr;
            prev = temp;
            size -= k;
        }
        return dummy.next;
    }
}