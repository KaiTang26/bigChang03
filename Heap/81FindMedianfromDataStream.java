import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here

        int[] ans = new int[nums.length];

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            temp.add(nums[i]);
            Collections.sort(temp);
            int median = (temp.size()-1)/2;

            ans[i] = temp.get(median);

        }

        return ans;
    }


   
}