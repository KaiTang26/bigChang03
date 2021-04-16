import java.util.Queue;

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here

        int count = 0;

        if(grid==null || grid.length==0){
            return count;
        }

        for(int i=0; i<grid.length; i++){

            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]){

                    BFS(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }


    public void BFS(int row, int col, boolean[][] grid ){


        int[] dRow = new int[]{-1,0,1,0};
        int[] dCol = new int[]{0,1,0,-1};

        int rowLimit = grid.length;
        int colLimit = grid[0].length;

        Record start = new Record(row, col);

        Queue<Record> queue = new LinkedList<>();

        queue.offer(start);
        grid[row][col]=false;

        while(!queue.isEmpty()){
            Record r = queue.poll();

        
            for(int i=0; i<4; i++){

                int dr = r.row+dRow[i];
                int dc = r.col+dCol[i];

                if(dr>=0 &&dr<rowLimit && dc>=0 && dc<colLimit){

                    if(grid[dr][dc]){
                        queue.offer(new Record(dr, dc));
                        grid[dr][dc]=false;
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