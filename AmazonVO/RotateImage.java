class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void transpose(int[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public void reverse(int[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++){
            int left = 0;
            int right = len-1;

            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}