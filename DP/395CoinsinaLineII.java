public int[] sum;
    public int[] dp;
    public boolean[] flag;

    public boolean firstWillWin(int[] values) {
        // write your code here

        sum = new int[values.length+1];
        dp= new int[values.length+1];
        flag = new boolean[values.length+1];
        sum[0] = 0;
        dp[0] = 0;
        flag[0]=true;

        for(int i=1; i<=values.length; i++){
            sum[i] = sum[i-1]+values[values.length-i];
        }

        return search(values.length)*2>sum[values.length];
    }

    public int search(int n){

        if(n==1){
            dp[1] = sum[1];
            flag[1]=true;
            return dp[1];
        }

        if(n<=0){
            return dp[0];
        }

        if(flag[n]){
            return dp[n];
        }

        dp[n] = sum[n]-Math.min(search(n-1), search(n-2));
        flag[n]= true;
        
        return dp[n];

    }