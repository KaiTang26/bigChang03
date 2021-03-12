public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here

        int[][] dp = new dp[m][n];


        for(int i=0; i<m; i++){
            dp[i][0]=1;
            for(int j=1; j<n; j++){
                if(i>0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=1;
                }

            }
        }

        return dp[m-1][n-1];


    }
}


public class Solution2{
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here

        int[][] dp = new int[2][n];


        for(int i=0; i<m; i++){
            dp[i%2][0]=1;
            for(int j=1; j<n; j++){
                if(i>0){
                    dp[i%2][j]=dp[(i-1)%2][j]+dp[i%2][j-1];
                }else{
                    dp[0][j]=1;
                }

            }
        }

        return dp[(m-1)%2][n-1];


    }
}
