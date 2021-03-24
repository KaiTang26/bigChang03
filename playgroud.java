public class Solution {
    
    public int minArea(char[][] image, int x, int y) {
        // write your code here

        if(image==null || image.length==0 || image[0].length==0){
            return 0;
        }

        int left = getLeft(image, 0, y);

        int right = getRight(image, y, image[0].length-1);

        int up = getTop(image, 0, x);

        int down = getDown(image, x, image.length-1);

        return (right-left+1)*(down-up+1);
    }

    private int getLeft(char[][] image, int left, int right){

        int start = left;
        int end = right;

        while(start+1<end){

            int mid = start + (end-start)/2;

            if(checkCol(image, mid)){
                end = mid;
            }else{
                start = mid;
            }

        }

        if(checkCol(image, start)){
            return start;
        }else{
            return end;
        }

    }

    private int getRight(char[][] image, int left, int right){
        int start = left;
        int end = right;

        while(start+1<end){

            int mid = start + (end-start)/2;

            if(checkCol(image, mid)){
                start = mid;
            }else{
                end = mid;
            }

        }

        if(checkCol(image, end)){
            return end;
        }else{
            return start;
        }

    }

    private int getTop(char[][] image, int top, int down){

        int start = top;
        int end = down;

        while(start+1<end){
            int mid = start+(end-start)/2;

            if(checkRow(image, mid)){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(checkRow(image, start)){
            return start;
        }else{
            return end;
        }

    }

    private int getDown(char[][] image, int top, int down){

        int start = top;
        int end = down;

        while(start+1<end){

            int mid = start+(end-start)/2;

            if(checkRow(image, mid)){
                start = mid;
            }else{
                end = mid;
            }

        }

        if(checkRow(image, end)){
            return end;
        }else{
            return start;
        }

    }

    private boolean checkRow(char[][] image, int row){

        for(char i: image[row]){
            if(i=='1'){
                return true;
            }
        }

        return false;

    }

    private boolean checkCol(char[][] image, int col){

        for(int i=0; i<image.length; i++){

            if(image[i][col]=='1'){
                return true;
            }
        }

        return false;

    }


}