public class ConnectingGraph {
    /*
    * @param n: An integer
    */

    public int[] father;

    public int find(int x){

        if(father[x]==x){
            return x;
        }

        father[x]=find(father[x]);

        return father[x];
    }
    
    
    public ConnectingGraph(int n) {
        // do intialization if necessary

        this.father= new int[n+1];

        for(int i=1; i<=n; i++){
            this.father[i]=i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here

        int aFather = find(a);
        int bFather = find(b);

        if(aFather!=bFather){
            father[aFather]=father[bFather];
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here

        int aFather = find(a);
        int bFather = find(b);

        if(aFather==bFather){
            return true;
        }else{
            return false;
        }


    }
}