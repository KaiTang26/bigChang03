public class ConnectingGraph3 {


    public int[] father = null;
    public int size;

    public int find(int x){

        if(x==father[x]){
            return father[x];
        }
        father[x] = find(father[x]);
        return father[x];
    }
    

    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        size = n;
        father = new int[n+1];
        for(int i=1; i<=n; i++){
            father[i]=i;
        }
    }
    
    public void connect(int a, int b) {
        // write your code here

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot!=bRoot){
            father[aRoot]=father[bRoot];
            size--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return size;
    }
}