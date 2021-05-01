class Solution {
    public int search(int[] nums, int target) {

        int minIndex=0;

        int start = 0;
        int end = nums.length-1;

        while(start+1<end){

            int mid = start+(end-start)/2;

            if(nums[mid]>nums[end]){

                start=mid;
            }else{
                end = mid;
            }
        }

        if(nums[start]<nums[end]){
            minIndex = start;
        }else{
            minIndex = end;
        }

        start = 0;
        end = nums.length-1;

        if(nums[end]>target){
            
        }



        
    }
}