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
    public TreeNode helper(int pLow, int pHi, int inLow, int inHi, int []inorder, int []postorder){
        if(pLow > pHi || inLow > inHi) return null;
        int val = postorder[pHi];
        int r = inLow;
        TreeNode root = new TreeNode(val);
        for(int i = inLow; i<=inHi; i++){
            if(val == inorder[i]){
                r = i;
                break;
            }
        }
        int cnt = r - inLow;
        root.left = helper(pLow, pLow+cnt-1, inLow, r-1, inorder, postorder);
        root.right = helper(pLow+cnt, pHi-1, r+1, inHi, inorder, postorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(0, n-1, 0, n-1, inorder, postorder);

    }
}