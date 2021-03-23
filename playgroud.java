public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length-1;

        while(start+1<end){
            int target = nums[end];
            int mid = start+(end-start)/2;

            if(nums[mid]>target){
                start = mid;
            }else if(nums[mid]<target){
                end = mid;
            }else{ 
                start =mid;
            }
        }

        if(nums[start]<nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}