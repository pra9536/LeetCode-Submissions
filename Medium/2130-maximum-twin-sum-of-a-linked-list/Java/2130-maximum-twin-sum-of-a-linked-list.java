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
    public int pairSum(ListNode head) {
        // ListNode slow = head;
        // ListNode fast = head;

        // while(fast.next.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // ListNode curr = slow.next;
        // slow.next = null;
        // ListNode prev = null;
        // while(curr != null) {
        //     ListNode next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }
        // ListNode head2 = prev;

        // // calculate sum
        // int sum = 0;

        // while(head != null) {
        //     sum = Math.max(sum, head.val + head2.val);
        //     head = head.next;
        //     head2 = head2.next;
        // }
        // return sum;


        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int i = 0;
        int j = list.size()-1;
        int max = Integer.MIN_VALUE;

        while(i < j) {
            max = Math.max(max, list.get(i) + list.get(j));
            i++;
            j--;

        }
        return max;
    }
}