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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> temp = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode n = p.node;
            int level = p.level;
            if(level != currLevel){
                currLevel = level;
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
            if(level % 2 == 0)
            temp.add(n.val);
            else
            temp.add(0, n.val);
                if(n.left != null) q.add(new Pair(n.left, level + 1));
                if(n.right != null) q.add(new Pair(n.right, level + 1));
        }
        ans.add(temp);
        return ans;
    }
}