public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here

        int count = 0;

        if(matrix==null || matrix.length==0|| matrix[0].length==0){
            return count;
        }




        for(int[] row : matrix){

            if(row[0]<=target && row[row.length-1]>=target && checkTarget(row, target)){
                count++;
            }
        }

        return count;
    }

    public boolean checkTarget(int[] row, int target){
        int start = 0;
        int end = row.length-1;

        while(start+1<end){

            int mid = start+(end-start)/2;

            if(row[mid]>target){
                end = mid;
            }else if(row[mid]<target){
                start = mid;
            }else{
                return true;
            }

        }

        if(row[start]==target){
            return true;
        }else if(row[end]==target){
            return true;
        }else{
            return false;

        }


        
    }
}