public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        int minLen = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                for(int k=i; k<=j; k++){
                    sum += nums[k];

                    if(sum>=s){
                        minLen =Math.min(j-i+1, minLen);
                    }
                }
            }
        }

        if(minLen<Integer.MAX_VALUE){
            return minLen;
        }else{
            return -1;
        }



    }

    
}


public class Solution2 {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        // O(n2)

        int minLen = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum>=s){
                    minLen =Math.min(j-i+1, minLen);
                    break;
                }
            }
        }

        if(minLen<Integer.MAX_VALUE){
            return minLen;
        }else{
            return -1;
        }



    }

    
}


public class Solution3 {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        // O(n2)

        int minLen = Integer.MAX_VALUE;

        int sum = 0;
        int j = 0;

        for(int i=0; i<nums.length; i++){


            while(j<nums.length && sum<s){
                sum += nums[j];
                j++;
            }

            if(sum>=s){
                minLen =Math.min(j-i+1, minLen);
                sum -= nums[i];
            }
        }

        if(minLen<Integer.MAX_VALUE){
            return minLen;
        }else{
            return -1;
        }



    }

    
}