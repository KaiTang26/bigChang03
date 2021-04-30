import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.relation.Role;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {


       PriorityQueue<Record> pq = new PriorityQueue<>((a,b)->{
           return a.h-b.h;
       });

       int m = forest.size();
       int n= forest.get(0).size();

       for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
               if(forest.get(i).get(j)>1){
                   pq.offer(new Record(i, j, forest.get(i).get(j)));
               }
           }
       }

       int stepSum = 0;

       Record start = new Record(0, 0, 0);


       while(!pq.isEmpty()){

            Record target = pq.poll();


            int step = BFS(start, target, forest, m, n);

            if(step<0){
                return -1;
            }

            stepSum+=step;

            start = target;
       }


       return stepSum;
        
    }


    public int BFS(Record start, Record target, List<List<Integer>> forest, int m, int n){

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        boolean[][] visited = new boolean[m][n];
        Queue<Record> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.row][start.col]=true;
        int step=0;


        while(!queue.isEmpty()){
            Record r = queue.poll();
            if(r.row==target.row&&r.col==target.col){
                return step;
            }
            for(int i=0; i<4; i++){
                int nr = r.row+dr[i];
                int nc = r.col+dc[i];

                if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visited[nr][nc]&&forest.get(nr).get(nc)>0){

                    queue.offer(new Record(nr, nc, forest.get(nr).get(nc)));
                    visited[nr][nc]=true;

                }

            }
            step++;

        }


        return -1;
    }
}


class Record{
    public int row;
    public int col;
    public int h;

    public Record(int row, int col, int h){
        this.row = row;
        this.col = col;
        this.h = h;
    }
}