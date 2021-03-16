public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */

     public int[][] sum;
     public int[][] dp;
     public boolean[][] flag;

    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;

        sum= new int[n+1][n+1];
        dp= new int[n+1][n+1];
        flag = new boolean[n+1][n+1];

        dp[0][0] = 0;
        flag[0][0] = true;
        sum[0][0] = 0;

        for(int i=0; i<n+1; i++){
            for(int j=1; j<n+1; j++){

               

                    if(j<i){
                        continue;
                    }else if(i==j){
                        sum[i][j] = values[j-1];
                    }else{
                        sum[i][j]= sum[i][j-1]+values[j-1];
                    }
                

            }
        }

        return search(0, n)*2>sum[0][n];

    }


    public int search(int i, int j){


        if(j<i){
            dp[i][j]=0;
            flag[i][j]=true;
            return 0;
        }


        if(flag[i][j]){
            return dp[i][j];
        }

        if(i==j){
            dp[i][j]=sum[i][j];
            flag[i][j]=true;
            return dp[i][j];
        }

        dp[i][j]= sum[i][j]-Math.min(search(i+1, j), search(i, j-1));
        flag[i][j]=true;
        return dp[i][j];

    }
}
