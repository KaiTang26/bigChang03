public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here


        if(heights==null || heights.length==0){
            return 0;
        }

        int left = 0;
        int right = heights.length-1;

        int count=0;

        int leftH=heights[left];
        int rightH=heights[right];

        while(left<right){

            if(leftH<rightH){
                left++;

                if(leftH>heights[left]){

                    count+=leftH-heights[left];

                }else{
                    leftH = heights[left];
                }

            }else{
                right--;

                if(rightH>heights[right]){
                    count += rightH-heights[right];

                }else{
                    rightH = heights[right];
                }

            }

        }

        return count;
    }
}
