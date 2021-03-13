class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean[] dp;
    public boolean[] flag;
    public boolean firstWillWin(int n) {
        // write your code here

        if(n==0){
            return  false;
        }
        if(n==1){
            return  true;
        }
        if(n==2){
            return  true;
        }
        if(n==3){
            return  false;
        }
        dp = new boolean[n+1];
        flag = new boolean[n+1];

        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        flag[0] = true;
        flag[1] = true;
        flag[2] = true;
        flag[3] = true;

        return search(n);
    }

    public boolean search(int n){

        if(flag[n]){
            return dp[n];
        }else{
            dp[n] = (search(n-2)&&search(n-3))||(search(n-3)&&search(n-4));
            flag[n]=true;
            return dp[n];
        }

    }

}
