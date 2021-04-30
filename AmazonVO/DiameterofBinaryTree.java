
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
    public int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);

        return max;
        
    }
   // max length path when this node is end
    public int helper(TreeNode node){


        if(node.left==null && node.right == null){
            return 0;
        }


        int left = node.left!=null?helper(node.left)+1:0;
        int right = node.right!=null?helper(node.right)+1:0;


        max =Math.max(left+right, max);

        return Math.max(left, right);



    }
}
