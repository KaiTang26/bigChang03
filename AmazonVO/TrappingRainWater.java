class Solution {
    public int trap(int[] height) {


        int left = 0;
        int leftWaterH = height[0];

        int right = height.length-1;
        int rightWaterH=height[right];

        int trap = 0;

        while(left<right){

            if(leftWaterH<=rightWaterH){
                left++;

                if(height[left]>leftWaterH){
                    leftWaterH = height[left];
                }else{
                    trap = trap+ leftWaterH-height[left];
                }
            }else{
                right--;

                if(height[right]>rightWaterH){
                    rightWaterH = height[right];
                }else{
                    trap = trap+ rightWaterH-height[right];
                }

            }
        }

        return trap;
        
    }
}
