import java.util.Queue;

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here


        if(heights==null|| heights.length==0){
            return 0;
        }

        int row = heights.length;
        int col = heights[0].length;


        int count = 0;

        int[] drow = {0,1,0,-1};
        int[] dcol = {-1,0,1,0};

        // int[] dx = {1, -1, 0, 0};
        // int[] dy = {0, 0, 1, -1};


        Comparator<HRecord> customComparator = new Comparator<HRecord>() {
            @Override
            public int compare(HRecord a, HRecord b) {
                return a.val-b.val;
            }
        };

        Queue<HRecord> q = new PriorityQueue<>(customComparator);

        boolean[][] record = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                record[i][j]=false;
            }
        }

        for(int i=0; i<row; i++){
           
               
                q.offer(new HRecord(heights[i][0], i, 0));
                record[i][0]=true;
                q.offer(new HRecord(heights[i][col-1], i, col-1));
                record[i][col-1]=true;
            
        }

        for(int i=0; i<col; i++){
            
                
                q.offer(new HRecord(heights[0][i], 0, i));
                record[0][i]=true;
            
                q.offer(new HRecord(heights[row-1][i], row-1, i));
                record[row-1][i]=true;
            
        }

        while(!q.isEmpty()){
            HRecord c = q.poll();

            for(int i=0; i<4; i++){

                int nRow = c.row+drow[i];
                int nCol = c.col+dcol[i];


                if(nRow<0 || nRow>=row || nCol<0 || nCol>=col){
                    continue;
                }

                if(record[nRow][nCol]){
                    continue;
                }


                    HRecord newC = new HRecord(Math.max(c.val, heights[nRow][nCol]), nRow, nCol);
                    q.offer(newC);
                    record[nRow][nCol]=true;
                    count =count+ Math.max(0, (c.val-heights[nRow][nCol]));

                
            }

        }

        return count;

    }
}


class HRecord{
    public int val;
    public int row;
    public int col;

    public HRecord(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
