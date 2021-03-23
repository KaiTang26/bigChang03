public class Solution {


    public int[][] dp;
    public boolean[][] flag;
    public int[] sum;

    public int stoneGame(int[] A) {
        // write your code here

        // sum from 0 to i
        sum = new int[A.length];
        sum[0] = A[0];
        dp = new int[A.length][A.length];
        flag = new boolean[A.length][A.length];

        for(int i=1; i<A.length; i++){
            sum[i]=sum[i-1]+A[i];
        }


        return search(0, A.length-1, A);

    }

    public int search(int start, int end, int[] A){

        if(start>=end){
            dp[start][end]=0;
            flag[start][end]=true;
            return 0;
        }


        if(flag[start][end]){
            return  dp[start][end];
        }

        int s = sum[end];

        if(start>0){
            s-=sum[start-1];
        }
        

        dp[start][end] = Integer.MAX_VALUE;

        for(int k=start; k<end; k++){

            dp[start][end] = Math.min(dp[start][end], search(start,k,A)+search(k+1,end,A)+s );

        }
        flag[start][end]=true;

        return  dp[start][end];

    }

    
}
