public class ConnectingGraph2 {

    public int[] father = null;
    public int[] size = null;

    public int find(int x){

        if(this.father[x]==x){
            return x;
        }

        this.father[x]=find(father[x]);

        return this.father[x];
    }


    



   public ConnectingGraph2(int n) {
        // do intialization if necessary

        this.father = new int[n+1];
        this.size = new int[n+1];

        for(int i=1; i<=n; i++){
            father[i]=i;
            size[i]=1;
        }

    }

    
    public void connect(int a, int b) {
        // write your code here

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot!=bRoot){
            this.father[aRoot]=this.father[bRoot];
            this.size[bRoot]+=this.size[aRoot];
            
        }
    }

    
    public int query(int a) {
        // write your code here
        int aRoot = find(a);
        return this.size[aRoot];
    }
}
