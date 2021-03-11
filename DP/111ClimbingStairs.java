public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here

        int[] dp = new int[2];

        for(int i=1; i<=n; i++){

            if(i<=2){
                dp[i%2]=i;
            }else{
                dp[i%2]=dp[(i-1)%2]+dp[(i-2)%2];
            }
        }

        return dp[n%2];
    }
}
