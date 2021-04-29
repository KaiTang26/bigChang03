import java.awt.List;
import java.util.Queue;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean zigZag = false;
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> levels= new ArrayList<>();

            for(int i=0; i<size; i++){

                TreeNode node = queue.poll();
                levels.add(node.val);

                    if(node.right!=null){
                        queue.offer(node.right);
                    }

                    if(node.left!=null){
                        queue.offer(node.left);
                    }
            }

            if(levels.size()>0){

                if(zigZag){
                    Collations.reverse(levels);
                }
                ans.add(levels);
            }

            zigZag = !zigZag;
        }

        return ans;


        
    }
}
