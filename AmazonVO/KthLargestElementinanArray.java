class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    }


    public quickSort(int[] nums, int start, int end){

        if(start>=end){
            return;
        }

        int pivot = nums[start];

        int left = start;

        int right = end;

        while(left<=right){
            while(left<=right && nums[left]<pivot){
                left++;
            }

            while(left<=right && nums[right]>pivot){
                right--;

            }

            if(left<=right){
                int temp = nums[right];
                nums[right]=nums[left];
                nums[left] = temp;

                left++;
                right--;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}