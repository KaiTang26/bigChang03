
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
 }


public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public int[] nums;
    public TreeNode maxTree(int[] A) {
        // write your code here
        this.nums = A;

        int start = 0;
        int end = A.length-1;

        return helper(start, end);
    }
    

    public TreeNode helper(int start, int end){


        if(start == end){

            return new TreeNode(nums[start]);
        }

        

        int max = Integer.MIN_VALUE;
        int index = 0;

        for(int i=start; i<=end; i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);

        node.left = helper(start, index-1);

        if(index+1<=end){
            node.right = helper(index+1, end);
        }

        return node;

    }
}






public class Solution_2 {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
   
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack  = new Stack<>();

        TreeNode root = null;


        for(int i : A){
            TreeNode ref = new TreeNode(i);
            while(!stack.isEmpty() && stack.peek().val<ref.val){
                    TreeNode node = stack.pop();
                    if(stack.isEmpty()){
                        ref.left = node;
                    }else{

                        TreeNode remain = stack.peek();

                        if(remain.val>ref.val){

                            ref.left = node;

                        }else{
                            remain.right = node;
                        }
                    }
            }
            stack.push(ref);
        }


        while(!stack.isEmpty() ){
            TreeNode node = stack.pop();
            if(!stack.isEmpty()){
                TreeNode remain = stack.peek();

                if(remain.val>node.val){
                    remain.right = node;
                }else{
                    node.left = remain;
                }
                
            }else{
                root = node;
            }

        }
        return root;
    }
    
}