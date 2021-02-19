public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public int[] fathers=null;
   
    public boolean validTree(int n, int[][] edges) {
        // write your code here

        if((n-1)!=edges.length){
            return false;
        }
       

        fathers=new int[n];

        for(int i=0; i<n; i++){
            fathers[i]=i;
        }

        for(int[] pair: edges){
            int a = pair[0];
            int b = pair[1];

            int aRoot = find(a);
            int bRoot = find(b);

            if(aRoot==bRoot){
                return false;
            }

            fathers[bRoot]=fathers[aRoot];
        }

        return true;

       


    }

    public int find(int x){

        if(x==fathers[x]){
            return x;
        }
        return fathers[x]=find(fathers[x]);
    }

   
}
