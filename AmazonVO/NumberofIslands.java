import java.util.Queue;

import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

class Solution {
    public int numIslands(char[][] grid) {


        int count=0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    count++;
                    BFS(i, j, grid);
                }
            }
        }
        return count;
        
    }


    private void BFS(int row, int col, char[][] grid){

        grid[row][col]='0';
        
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};

        int rowLimit = grid.length;
        int colLimit = grid[0].length;

        Queue<Record> queue = new LinkedList<>();
        Record root = new Record(row, col);

        queue.offer(root);

        while(!queue.isEmpty()){
            Record node = queue.poll();

            for(int i=0; i<4; i++){

                int newRow = node.row+dr[i];
                int newCol = node.col+dc[i];

                if(newRow>0 && newRow<rowLimit && newCol>0 && newCol<colLimit){
                    if(grid[newRow][newCol]=='1'){
                        grid[newRow][newCol]='0';
                        Record newNode = new Record(newRow, newCol);
                        queue.offer(newNode);
                    }
                }

            }
        }
    }



}

class Record{

    int row;
    int col;

    public Record(int row, int col){
        this.row = row;
        this.col = col;
    }
}