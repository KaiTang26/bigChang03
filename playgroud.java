import jdk.internal.net.http.LineSubscriberAdapter;
import jdk.nashorn.internal.ir.LiteralNode;

public class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }


 
 public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public void partitionArray(int[] nums, int k) {
        // write your code here

        int left = 0;
        int right = nums.length-1;

        while(left<=right){

            while(left<=right && nums[left]<k){
                left++;

            }

            while(left<=right && nums[right]>=k){
                right--;
            }

            if(left<=right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }
}