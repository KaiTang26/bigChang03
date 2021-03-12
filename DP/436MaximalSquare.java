public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;


        int[][] dp = new int[n][m];

        int ans = 0;

        for(int i=0; i<n; i++){
            dp[i][0] = matrix[i][0];

            if(dp[i][0]==1){
                ans =1;
            }
        }

        for(int i=0; i<m; i++){
            dp[0][i] = matrix[0][i];
            if(dp[0][i]==1){
                ans =1;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){


                if(matrix[i][j]==1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;

                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }

                
            }
        }


        return ans*ans;
    }
}
