class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[m+1][n+1];



        for(int i=0; i<=m; i++){

            dp[i][0] = i;

            for(int j=1; j<=n; j++){
                if(i>0){

                    if(word1.charAt(j-1)==word2.charAt(i-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = 1 + (Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]));
                    }

                }else{
                    dp[i][j] = j;
                }

            }
        }

        return dp[m][n];


    }
}
