public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        double eps = 1e-8;

        for(int i: nums){

            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        double start = (double) min;
        double end = (double) max;


        while(start+eps<end){
            double mid = start + (end-start)/2;
            if(check(nums, k, mid)){
                end = mid;
            }else{
                start =mid;
            }
        }

        if(check(nums, k, start)){
            return start;
        }else{
            return end;
        }
    }


    public boolean check(int[] nums, int k, double checkAve){

        int index = 0;

        double sum = 0;

        while(index<k){
            sum += (double)nums[index];
            index++;
        }

        if((sum/k)>checkAve){
            return false;
        }

        while(index<nums.length){

            sum += (double)nums[index];
            sum -= (double)nums[index-k];

            if((sum/k)>checkAve){
                return false;
            }

            index++;
        }

        return true;

    }
}
