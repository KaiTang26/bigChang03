public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */

     public int[][] dp;
     public boolean[][]flag;

    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int ans = 0;

        dp = new int[n][m];
        flag = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                dp[i][j] = search(i, j, matrix);

                ans= Math.max(ans, dp[i][j]);
            }
        }


        return ans;


    }


    public int search(int x, int y, int[][] matrix){

        if(flag[x][y]){
            return dp[x][y];
        }

        dp[x][y] = 1;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};

        for(int i=0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<matrix.length && ny>=0 && ny<matrix[0].length){
                if(matrix[nx][ny]<matrix[x][y]){
                    dp[x][y] = Math.max(dp[x][y], search(nx, ny, matrix)+1);
                    flag[x][y]=true;
                }
            }
        }


        return dp[x][y];




    }
}