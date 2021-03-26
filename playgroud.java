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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
   
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here

        List<String> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }

        List<String> left = binaryTreePaths(root.left);

        List<String> right = binaryTreePaths(root.right);

        for(String i: left){
            String path = root.val+"->"+i;
            ans.add(path);
        }

        for(String i: right){
            String path = root.val+"->"+i;
            ans.add(path);
        }

        if(left.size()==0 && right.size()==0){
            ans.add(Integer.toString(root.val));
        }

        return ans;

    }
}