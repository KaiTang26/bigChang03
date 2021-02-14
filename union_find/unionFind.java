package Feb11;

public class unionFind {

    public int[] father;

    public int find(int a){

        if(father[a]==a){
            return a;
        }

        return father[a]=find(father[a]);
    }

    public void union(int a, int b){

        int aRoot = find(a);

        int bRoot = find(b);

        if(aRoot !=bRoot){
            father[aRoot]=father[bRoot];
        }
    }
    
}
