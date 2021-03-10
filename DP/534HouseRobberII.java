public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here

        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int n = nums.length;

        int[] dp = new int[n];

        dp[0]=0;

        for(int i=0; i<n-1; i++){
        
            dp[i+1] = Math.max(dp[i], i==0?nums[i]:nums[i]+dp[i-1]);
        }


        int helfMax = dp[n-1];


        for(int i=1; i<n ; i++){

            dp[i] = Math.max(dp[i-1], i-2>=0?nums[i]+dp[i-2]: nums[i]);

        }

        return Math.max(helfMax, dp[n-1]);
    }
}
