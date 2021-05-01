import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image==null||image.length==0||image[0].length==0){
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};

        int targetColor = image[sr][sc];
        boolean[][] visit = new boolean[m][n];
        Queue<Record> queue = new LinkedList<>();

        queue.offer(new Record(sr, sc));
        visit[sr][sc]=true;
        while(!queue.isEmpty()){
            Record r = queue.poll();
            image[r.row][r.col]=newColor;

            for(int i=0; i<4; i++){
                int nr = r.row+dr[i];
                int nc = r.col+dc[i];

                if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visit[nr][nc]&&image[nr][nc]==targetColor){

                    queue.offer(new Record(nr, nc));
                    visit[nr][nc]=true;
                }
            }
        }

        return image;  
    }
}

class Record{
    public int row;
    public int col;

    public Record(int row, int col){
        this.row = row;
        this.col = col;
    }
}