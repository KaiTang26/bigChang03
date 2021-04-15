public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here

        if(edges.length-1 != n){
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for(int i=0; i<edges.length; i++){

            int[] edge = edges[i];

            uf.Union(edge[0], edge[1]);
        }

        return uf.count==1;
    }
}

class UnionFind{

    public int[] fathers;
    public int count;

    public UnionFind(int n){
        fathers = new int[n];

        count = n;

        for(int i=0; i<n; i++){

            fathers[i]=i;
        }

    }

    public int find(int x){

        if(fathers[x]==x){
            return x;
        }
        fathers[x] = find(fathers[x]);
        return fathers[x];
    }

    public void Union(int a, int b){
        int fatherA = find(a);
        int fatherB = find(b);
        if(fatherA != fatherB){
            fathers[a] = fatherB;
            count--;
        }
    }
}