public class Solution {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here

        int maxArea = 0;

        if(matrix==null || matrix.length==0){
            return maxArea;
        }

        int size = matrix[0].length;

        int[] heights = new int[size];

        for(int i=0; i<size; i++){
            heights[i]=0;
        }


        for(int i=0; i<matrix.length; i++){

            for(int j=0; j<size; j++){

                heights[j] = matrix[i][j]? heights[j]+1: 0;

            }

            maxArea = Math.max(maxArea, monoStack(heights));
        }

        return maxArea;

    }

    public int monoStack(int[] heights){

        int ma = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<=heights.length; i++){

            int currH = (i==heights.length)?-1:heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]>=currH){

                int h = heights[stack.pop()];

                int w = stack.isEmpty()? i: i-stack.peek()-1;

                ma= Math.max(ma, h*w);
            }

            stack.push(i);
        }

        return ma;

    }
}
