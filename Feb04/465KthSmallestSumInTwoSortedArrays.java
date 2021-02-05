import java.util.PriorityQueue;

public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here

        int rowLen = A.length;
        int colLen = B.length;

        Comparator<Record> customComparator = new Comparator<Record>() {
            @Override
            public int compare(Record a, Record b) {
                return a.val-b.val;
            }
        };

        PriorityQueue<Record> pq = new PriorityQueue<>(customComparator);

        for(int i=0; i<rowLen; i++){
            Record r = new Record(i, 0, A[i]+B[0]);
            pq.offer(r);
        }

        int count=0;

        while(!pq.isEmpty()){

            Record re = pq.poll();
            count++;

            if(count==k){
                return re.val;
            }

            if(re.col+1<colLen){
                Record r = new Record(re.row, re.col+1, A[re.row]+B[re.col+1]);
                pq.offer(r);
            }
        }

        return -1;




    }
}


class Record{
    public int col;
    public int row;
    public int val;

    public Record(int row, int col, int val){

        this.row = row;
        this.col = col;
        this.val = val;

    }
}