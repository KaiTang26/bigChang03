public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here

        if(A==null||A.length==0){
            return 0;
        }

        long [] dp = new long [A.length+1];
        dp[0]=0;

        for(int i=0; i<A.length; i++){

            dp[i+1] = Math.max(dp[i], i-1>=0?A[i]+dp[i-1]:A[i]);
        }

        return dp[A.length];
    }
}