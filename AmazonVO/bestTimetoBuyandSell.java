class Solution {
    public int maxProfit(int[] prices) {


        int profit = 0;
        int min = prices[0];

        for(int i=1; i<prices.length;i++){

            profit = Math.max(prices[i]-min, 0);

            min = Math.min(min, prices[i]);

        }

        return profit;
        
    }
}