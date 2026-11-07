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
    public int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int size = size(head);

        // int target = size - n;

        // int i = 0;

        // ListNode temp = head;
        // ListNode dummy = new ListNode(0);
        // ListNode prev = dummy;
        // dummy.next = head;

        // while(i < target) {
        //     prev = prev.next;
        //     temp = temp.next;
        //     i++;
        // }

        // prev.next = temp.next;

        // return dummy.next;


        ListNode dummy = new ListNode(0);

        ListNode temp = head;
        dummy.next = head;
        ListNode prev = dummy;

        int i = 0;

        while(i < n) {
            temp = temp.next;
            i++;
        }

        while(temp != null) {
            prev = prev.next;
            temp = temp.next;
        }

        prev.next = prev.next.next;




        return dummy.next;
    }
}