class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();


        if(buildings==null || buildings.length==0){
            return  ans;
        }

        List<Record> buildingRecords = new ArrayList<>(buildings.length*2);

        for(int i=0; i<buildings.length; i++){
            buildingRecords.add(new Record(buildings[i][0], true, buildings[i][2]));
            buildingRecords.add(new Record(buildings[i][1], false, buildings[i][2]));
        }

        Collections.sort(buildingRecords, new Comparator<Record>(){
            @Override
            public int compare(Record a, Record b){
                if(a.index!=b.index){
                    return a.index-b.index;
                }
                if(a.isStart && b.isStart){
                    return b.height-a.height;//进入高度从大到小
                }
                if(!a.isStart && !b.isStart){
                    return a.height-b.height;//出来高度从小到大
                }

                return a.isStart ? -1 : 1;//同x，start先end后
            }

        });

//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        tm.put(0,1);

        int pre = 0;


        for(int i=0; i<buildingRecords.size(); i++){
            Record r = buildingRecords.get(i);

            if(r.isStart){

                tm.compute(r.height, (k,v)->{
                    if(v !=null){
                        return v+1;
                    }
                    return 1;
                });
            }else{
                tm.compute(r.height, (k,v)->{
                    if(v == 1){
                        return null;
                    }
                    return v-1;
                });
            }
            int curr = tm.lastKey();
            if(pre!=curr){
                ans.add(new ArrayList<>(Arrays.asList(r.index, curr)));
                pre = curr;
            }
        }
        return  output(ans);
    }

    List<List<Integer>> output(List<List<Integer>> res) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (res.size() > 0) {
            int pre = res.get(0).get(0);
            int height = res.get(0).get(1);
            for (int i = 1; i < res.size(); i++) {
                List<Integer> now = new ArrayList<Integer>();
                int id = res.get(i).get(0);
                if (height > 0) {
                    now.add(pre);
                    now.add(id);
                    now.add(height);
                    ans.add(now);
                }
                pre = id;
                height = res.get(i).get(1);
            }
        }
        return ans;
    }




}

class Record{
    int index;
    boolean isStart;
    int height;

    Record(int index, boolean isStart, int height){
        this.index = index;
        this.isStart = isStart;
        this.height = height;
    }

    public String toString(){

        return "["+index+" "+height+" "+isStart+"]";
    }
}
