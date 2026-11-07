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

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            temp.next = head1;
        }

        if(head2 != null) {
            temp.next = head2;
        }

        return dummy.next;
    }

    public ListNode divide(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode h1 = divide(head);
        ListNode h2 = divide(head2);

        return merge(h1, h2);

    }
    public ListNode sortList(ListNode head) {
        return divide(head);
    }
}