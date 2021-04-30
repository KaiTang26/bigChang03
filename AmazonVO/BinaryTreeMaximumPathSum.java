
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {

    private int globlePathMax = Integer.MIN_VALUE;

   
    public int maxPathSum(TreeNode root) {

        if(root==null){
            return 0;
        }

        dfs(root);

        return globlePathMax;
        
    }

    private int dfs(TreeNode node){

        if(node==null){
            return 0;
        }


        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        // find max for: left+val, right+val, val
        int edgeSumMax = Math.max(left+node.val, right+node.val);

        globlePathMax =Math.max( Math.max(left+right+node.val, edgeSumMax), globlePathMax);

        return edgeSumMax;
    }
}