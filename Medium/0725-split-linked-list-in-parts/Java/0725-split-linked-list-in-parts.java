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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode []ans = new ListNode[k];
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        int len = size / k;
        int rem = size % k;
        curr = head;

        for(int i = 0; i<k; i++) {
            ans[i] = curr;

            int length = len;
            if(rem > 0) {
                length++;
                rem--;
            }

            for(int j = 1; j < length; j++) {
                curr = curr.next;
            }

            if(curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return ans;
    }
}