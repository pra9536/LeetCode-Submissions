/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void insert(TreeNode root, int val){
        if(root == null) return;
        if(root.val < val)
        {
            if(root.right == null) root.right = new TreeNode(val);
            else insert(root.right, val);
        }
        else
        {
            if(root.left == null) root.left = new TreeNode(val);
            else insert(root.left, val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // TreeNode node = new TreeNode(val);
        // if(root == null) return node;
        // TreeNode curr = root;
        // TreeNode prev = null;
        // while(curr != null){
        //   if(val > curr.val){
        //     prev = curr;
        //     curr = curr.right;
        //   } else{
        //     prev = curr;
        //     curr = curr.left;
        //   }
        // }
        // if(val > prev.val) prev.right = node;
        // else prev.left = node;
        // return root;

       if(root == null) return new TreeNode(val);
        insert(root, val);
        return root;

    }
}