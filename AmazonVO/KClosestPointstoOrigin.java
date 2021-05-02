import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];

        PriorityQueue<Record> pq = new PriorityQueue<>((a,b)->{
            return a.distance - b.distance;
        });

        for(int[] p :points){
            int distance = p[0]*p[0]+p[1]*p[1];
            pq.offer(new Record(p, distance));
        }

        int index = 0;

        while(!pq.isEmpty() && k>0){

            ans[index] = pq.poll().point;
            k--;
            index++;

        }

        return ans;
    }
}

class Record{
    public int[] point;
    public int distance;

    public Record(int[] point, int distance){

        this.point = point;
        this.distance = distance;

    }
}