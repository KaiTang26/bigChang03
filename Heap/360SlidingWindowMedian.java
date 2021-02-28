import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here


        List<Integer> ans = new ArrayList<Integer>();


        if(nums==null || nums.length==0 ){
            return ans;
        }

        if(k==1){
            for(int i=0; i<nums.length; i++){
                ans.add(nums[i]);
            }

            return ans;
        }



        Comparator<Record> samllComparator = new Comparator<Record>() {
            @Override
            public int compare(Record a, Record b) {
                return b.val -a.val;
            }
        };

        Comparator<Record> bigComparator = new Comparator<Record>(){
            @Override
            public int compare(Record a, Record b){
                return a.val - b.val;
            }
        };

        Record[] numsR = new Record[nums.length];

        // pull larger value
        Queue<Record> keepSamllQ = new PriorityQueue<>(samllComparator);

        // pull small value
        Queue<Record> keepBigQ = new PriorityQueue<>(bigComparator);


        for(int i=0; i<nums.length; i++){

            Record newCase = new Record(nums[i], i);
            numsR[i] = newCase;

            if(i==0){
                keepSamllQ.offer(newCase);
                continue;
            }

            Record ref = keepSamllQ.peek();
            

            if(nums[i]>=ref.val){
                keepBigQ.offer(newCase);
            }else{
                keepSamllQ.offer(newCase);
            }

            int kB = keepBigQ.size();
            int kS = keepSamllQ.size();

            queueShake(keepBigQ, keepSamllQ);


            if(kB+kS==k){
                ans.add(keepSamllQ.peek().val);
            }

            if(kB+kS>k){
                int removeIndex = i-k;

                if(!keepBigQ.remove(numsR[removeIndex])){
                    keepSamllQ.remove(numsR[removeIndex]);
                }

                queueShake(keepBigQ, keepSamllQ);

                ans.add(keepSamllQ.peek().val);
            }

        }

        return ans;
    }


    public void queueShake( Queue keepBigQ,  Queue keepSamllQ){

        int kB = keepBigQ.size();
        int kS = keepSamllQ.size();

        if(kB>kS){
            keepSamllQ.offer(keepBigQ.poll());
        }else if(kS>kB+1){
            keepBigQ.offer(keepSamllQ.poll());
        }
    }
}



class Record{
    public long val;
    public int index;

    public Record(int val, int index){
        this.val = val;
        this.index = index;
    }
}