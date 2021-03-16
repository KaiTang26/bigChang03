import jdk.javadoc.internal.doclets.formats.html.resources.standard;

class Solution1 {
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

        sum= new int[n][n];
        dp= new int[n][n];
        flag = new boolean[n][n];


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j<i){
                    continue;
                }else if(i==j){
                    sum[i][j] = values[j];
                }else{
                    sum[i][j]= sum[i][j-1]+values[j];
                }


                //System.out.println("sum: "+sum[i][j]+" i: "+i+" j: "+j);

            }
        }

        return search(0, n-1)*2>sum[0][n-1];

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
        System.out.println("dp: "+dp[i][j]+" i: "+i+" j: "+j);
        flag[i][j]=true;
        return dp[i][j];

    }
}



class Solution2 {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */

    public int[] sum;
    public int[][] dp;
    public boolean[][] flag;
    

    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;

        sum= new int[n+1];
        dp= new int[n][n];
        flag = new boolean[n][n];


        for(int i=1; i<=n; i++){

            sum[i]= sum[i-1]+values[i-1];
        }

        return search(0, n-1, values)*2>sum[n];

    }


    public int search(int i, int j, int[] values){

        if(j<i){
            dp[i][j]=0;
            flag[i][j]=true;
            return 0;
        }

        if(flag[i][j]){
            return dp[i][j];
        }

        if(i==j){
            dp[i][j]=values[j];
            flag[i][j]=true;

            return dp[i][j];
        }

        int s = sum[j+1] - sum[i];

        dp[i][j]= s-Math.min(search(i+1, j, values), search(i, j-1, values));
        System.out.println("dp: "+dp[i][j]+" i: "+i+" j: "+j);
        flag[i][j]=true;
        return dp[i][j];

    }
}

