import java.util.ArrayList;
import java.util.List;

public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }


  public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here


        List<Integer> ans = new ArrayList();

        if(root==null){
            return ans;
        }

        List<Integer> left = postorderTraversal(root.left);
        ans.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        ans.addAll(right);
        ans.add(root.val);

        return ans;


    }
}