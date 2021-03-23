public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if(matrix==null || matrix.length==0){
            return false;
        }

        int startRow = 0;
        int endRow = matrix.length-1;

        int row = 0;


        while(startRow+1<endRow){
            
            int mid = startRow+(endRow-startRow)/2;

            if(matrix[mid][0]>target){
                endRow = mid;
            }else{
                startRow = mid;
            }
        }


        if(matrix[endRow][0]<=target){
            row = endRow;
        }else{
            row = startRow;
        }

        int start = 0;
        int end = matrix[0].length-1;

        while(start+1<end){
            int mid = start + (end-start)/2;

            if(matrix[row][mid]>target){
                end = mid;
            }else{
                start=mid;
            }
        }

        if(matrix[row][start]==target || matrix[row][end]==target){
            return true;
        }else{
            return false;
        }

       
    }
}