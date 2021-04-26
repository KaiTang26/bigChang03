class Solution {
    public int maxArea(int[] height) {

        int volum = 0;

        int left = 0;
        int right = height.length-1;

        int leftWaterH = height[left];
        int rightWaterH = height[right];

        while(left<right){

            int w = right-left;

            if(leftWaterH<=rightWaterH){

                volum = Math.max(w*leftWaterH, volum);

                left++;
                if(height[left]>leftWaterH){
                    leftWaterH = height[left];
                }

            }else{

                volum = Math.max(w*rightWaterH, volum);

                right--;
                if(height[right]>rightWaterH){
                    rightWaterH =height[right];
                }

            }

        }

        return volum;
    }
}
