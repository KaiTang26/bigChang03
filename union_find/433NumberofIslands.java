public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        int n = grid.length;
        if(grid==null || n==0){
            return 0;
        }
        int m = grid[0].length;
        if(m==0){
            return 0;
        }

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]){
                    count++;
                }
            }
        }

        UnionFind uf = new UnionFind(n*m);
        uf.setCount(count);


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]){


                    if(i>0 && grid[i-1][j]){
                        uf.union(i*m+j, (i-1)*m+j);
                    }

                    if(i<n-1 && grid[i+1][j]){
                        uf.union(i*m+j, (i+1)*m+j);
                    }

                    if(j>0 && grid[i][j-1]){
                        uf.union(i*m+j, i*m+j-1);
                    }


                    if(j<m-1 && grid[i][j+1]){
                        uf.union(i*m+j, i*m+j+1);
                    }
                   
                }
            }
        }


        return uf.query();


        
    }
}



class UnionFind{

    private int[] fathers = null;
    private int count;

    public UnionFind(int x){
        fathers = new int[x];
        for(int i=0; i<x; i++){
            fathers[i]=i;
        }
    }

    public void setCount(int count){
        this.count=count;
    }

    public int find(int a){

        if(a==fathers[a]){
            return a;
        }
        fathers[a]=find(fathers[a]);
        return fathers[a];
    }

    public void union(int a, int b){

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot!=bRoot){
            fathers[aRoot]=fathers[bRoot];
            count--;
        }

    }

    public int query(){
        return count;
    }
}