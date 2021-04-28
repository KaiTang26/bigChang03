class Solution {
    public int missingNumber(int[] nums) {

        int len = nums.length;

        int banchmark = 0;

        for(int i=0; i<=len; i++){
            banchmark +=i;
        }

        int sum = 0;

        for(int i:nums){
            sum+=i;
        }

        return banchmark-sum;
        
    }
}