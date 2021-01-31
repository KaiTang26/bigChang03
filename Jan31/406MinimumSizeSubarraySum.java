public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        int minLen = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                for(int k=i; k<=j; k++){
                    sum += nums[k];

                    if(sum>=s){
                        minLen =Math.min(j-i+1, minLen);
                    }
                }
            }
        }

        if(minLen<Integer.MAX_VALUE){
            return minLen;
        }else{
            return -1;
        }



    }

    
}