import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here

        List<Integer> ans = new ArrayList<Integer>();

        if(A==null || A.length==0){
            return ans;
        }

        int start = 0;
        int end = A.length-1;

        while(start+1<end){

            int mid = start + (end-start)/2;

            int col = findMax(A[mid]);

            if(A[mid][col]>A[mid-1][col] && A[mid][col]>A[mid+1][col]){

                ans.add(mid);
                ans.add(col);
                break;
            }else if(A[mid][col]<A[mid-1][col] && A[mid][col]>A[mid+1][col]){
                end = mid;

            }else if(A[mid][col]>A[mid-1][col] && A[mid][col]<A[mid+1][col]){
                start = mid;
            }else if(A[mid][col]<A[mid-1][col] && A[mid][col]<A[mid+1][col] && A[mid+1][col]>A[mid-1][col]){
                start = mid;
            }else{
                end = mid;
            }

        }

        return ans;
    }

    public int findMax(int[] B){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<B.length; i++){
            if(B[i]>max){
                max = B[i];
                index = i;
            }
        }
        return index;
    }
}



public class Solution_2 {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */



    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        int n = A.length;
        int m = A[0].length;
        return find(1, n-2, 1, m-2, A);
    }


    public List<Integer> find(int xs, int xe, int ys, int ye, int[][] A){

        int midX = xs+(xe-xs)/2;

        int midY = ys+(ye-ys)/2;

        int x = midX;

        int y = midY;

        int max = A[midX][midY];


       

        // find max along y
        for(int i=ys; i<=ye; ++i){
            if(A[midX][i]>max){
                max = A[midX][i];
                y = i;
                x = midX;
            }
        }

         // find max along x
         for(int i=xs; i<=xe; ++i){
            if(A[i][midY]>max){
                max = A[i][midY];
                x = i;
                y = midY;
            }
        }

        boolean isPeak = true;

        if(A[x][y-1]>A[x][y]){
            isPeak = false;
            y -=1;
        }else if(A[x][y+1]>A[x][y]){
            isPeak =false;
            y +=1;
        }else if(A[x-1][y]>A[x][y]){
            isPeak = false;
            x -=1;
        }else if(A[x+1][y]>A[x][y]){
            x +=1;
            isPeak =false;
        }


        if(isPeak){
            return new ArrayList<Integer>(Arrays.asList(x,y));
        }


        if(x>=xs && x<midX && y>=ys && y<midY){
            return find(xs, midX-1, ys, midY-1, A);
        }

        if(x>=xs && x<midX && y<=ye && y>midY){
            return find(xs, midX-1, midY+1, ye, A);
        }

        if(x<=xe && x>midX && y>=ys && y<midY){
            return find(midX+1, xe, ys, midY-1, A);
        }

        if(x<=xe && x>midX && y<=ye && y<midY){
            return find(midX+1, xe, midY+1, ye, A);
        }  
        
      
     

        return new ArrayList<Integer>(Arrays.asList(-1,-1));

    }
}