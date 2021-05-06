import java.util.Queue;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null){
            return "[]";
        }

        String ans = "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node==null){

                ans +="null";

            }else{
                ans += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }

            ans+=",";
        }

        ans = ans.substring(0, ans.length()-1);

        return "["+ans+"]";
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("[]")){
            return null;
        }

        String[] nodeValues = data.substring(1,data.length()-1).split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean isLeft = true;

        TreeNode current = null;

        for(int i=1; i<nodeValues.length; i++){
            String v = nodeValues[i];
            if(isLeft){
                current = queue.poll();
                if(!v.equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(v));
                    current.left = leftNode;
                    queue.offer(leftNode);
                }
                isLeft = false;
            }else{
                if(!v.equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(v));
                    current.right = rightNode;
                    queue.offer(rightNode);
                }
                isLeft = true;
            }
            
        }

        return root;
    }
}