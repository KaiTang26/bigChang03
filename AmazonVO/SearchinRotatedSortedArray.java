class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        while(start+1<end){
            int mid = start +(end-start)/2;
            int startValue = nums[start];
            int endValue = nums[end];
            int midValue = nums[min];

            if(midValue == target){
                return mid;
            }
            if(startValue==target){
                return start;
            }

            if(endValue == target){
                return  end;
            }

            if(target>startValue && target>endValue){

                if(midValue>=startValue && midValue>endValue && midValue<target){
                    start = mid;
                }else{
                    end = mid;
                }

            }else if(target<startValue && target<endValue){

                if(midValue>target && midValue<=endValue){
                    end = mid;
                }else{
                    start = mid;
                }

            }else{
                if(midValue>target){
                    end = mid;
                }else{
                    start =mid;
                }
            }
        }


        if(nums[start]==target){
            return start;
        }else if(nums[end]==target){
            return end;
        }else{
            return -1;
        }

    
    }
}