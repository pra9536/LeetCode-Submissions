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
 class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
 }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
         if(root == null) return ans;
        q.add(new Pair(root, 0));
        int currLevel = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode node = p.node;
            int level = p.level;
            if(level != currLevel){
                currLevel = level;
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
            temp.add(node.val);
            if(node.left != null) q.add(new Pair(node.left, level+1));
            if(node.right != null) q.add(new Pair(node.right, level+1));
        }
        ans.add(new ArrayList<>(temp));
        return ans;


    }
}