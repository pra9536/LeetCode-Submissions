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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr1 = head;
        ListNode curr2 = head.next;
        ListNode temp = curr2;

        while(curr2 != null && curr2.next != null) {
            curr1.next = curr2.next;
            curr1 = curr1.next;
            curr2.next = curr1.next;
            curr2 = curr2.next;
        }

        curr1.next = temp;
        return head;

    }
}