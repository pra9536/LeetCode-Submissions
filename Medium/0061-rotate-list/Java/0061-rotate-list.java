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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int size = 1;

        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            size++;
        }

        k = k % size;

        if(k == 0) return head;

        tail.next = head;

        int target = size - k;

        for(int i = 1; i<target; i++){
            head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}