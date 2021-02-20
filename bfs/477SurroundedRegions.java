import java.util.Queue;

import javax.management.Query;

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here

        if(board==null || board.length==0 || board.length==1){
            return;
        }

        int row = board.length;
        int col = board[0].length;

        Queue<Record> queue = new LinkedList<Record>();

        for(int i=0; i<row; i++){
            char firstCol = board[i][0];
            char lastCol = board[i][col-1];

            if(firstCol=='O'){
                queue.offer(new Record(i, 0));
                
            }

            if(lastCol=='O'){
                queue.offer(new Record(i, col-1));
            }
        }

        for(int i=0; i<col; i++){
            char firstRow = board[0][i];
            char lastRow = board[row-1][i];

            if(firstRow=='O'){
                queue.offer(new Record(0, i));
                
            }

            if(lastRow=='O'){
                queue.offer(new Record(row-1,i));
            }
        }

        int[][] coordinate = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};


        while(!queue.isEmpty()){
            Record r = queue.poll();
            board[r.x][r.y]='W';
            for(int[] c : coordinate){
                int newRow = r.x+c[0];
                int newCol = r.y+c[1];
                if(0<newRow&&newRow<row && 0<newCol&& newCol<col && board[newRow][newCol]=='O'){
                    queue.offer(new Record(newRow,newCol));
                }
            }
        }


        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }

                if(board[i][j]=='W'){
                    board[i][j]='O';
                }
            }
        }
    }
}


class Record{
    public int x;
    public int y;

    public Record(int x, int y){
        this.x =x;
        this.y =y;
    }

}
