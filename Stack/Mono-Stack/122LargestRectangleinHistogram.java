public class Solution_1 {
   
    // Time Limit Exceeded

    public int largestRectangleArea(int[] heights) {
        // write your code here

        int maxArea = 0;

        for(int i=0; i<heights.length; i++){

            int currlow = heights[i];

            for(int j=i; j<heights.length; j++){

                if(heights[j]<=currlow){
                    currlow=heights[j];
                }

                maxArea = Math.max(maxArea, currlow*(j-i+1));

            }
        }

        return maxArea;
    }
}


public class Solution_2 {
   
    public int largestRectangleArea(int[] heights) {
        // write your code here

        int maxArea = 0;

        if(heights==null || heights.length==0){
            return maxArea;
        }
       // stack used for index 
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<heights.length; i++){

            int curr = heights[i];

            while(!stack.isEmpty()&& heights[stack.peek()]>=curr){

                int h = heights[stack.pop()];

                int w = stack.isEmpty()? i : i-stack.peek()-1;

                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }


        while(!stack.isEmpty()){

            int h = heights[stack.pop()];

            int w =  stack.isEmpty()? heights.length:heights.length-stack.peek()-1;

            System.out.println(w);

            maxArea = Math.max(maxArea, h*w);
        }

        return maxArea;

        
    }
}