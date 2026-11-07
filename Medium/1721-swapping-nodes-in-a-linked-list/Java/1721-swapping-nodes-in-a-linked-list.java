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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode first = head;
        int i = 1;
        while(i < k) 
        {
            first = first.next;
            curr = curr.next;
            i++;
        }
        ListNode second = head;
        while(curr.next != null) {          
            second = second.next;
            curr = curr.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;      
    }
}