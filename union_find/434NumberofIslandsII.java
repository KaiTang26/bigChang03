import java.awt.List;

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
 }


public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */


    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here

       

        int[][] indexChange = new int[][]{{0,1},{0,-1}, {1,0}, {-1,0}};
        List<Integer> ans = new ArrayList<Integer>();

        if(operators==null||operators.length==0){
            return ans;
        }


        int count = 0;
        UnionFind uf = new UnionFind(n*m);
        for(Point p: operators){
            int row = p.x;
            int col = p.y;
            int index = row*m+col;
            if(uf.checkIsland(index)){
                ans.add(count);
                continue;
            }
            uf.markIsland(index);
            count++;
            for(int[] ic:indexChange){
                int newRow = row+ic[0];
                int newCol = col+ic[1];
                int newIndex = newRow*m+newCol;
                if(0<=newRow && newRow<n && 0<=newCol&& newCol<m && uf.checkIsland(newIndex)){
                    int iRoot = uf.find(index);
                    int niRoot = uf.find(newIndex);
                    if(iRoot!=niRoot){
                        uf.union(iRoot, niRoot);
                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}


class UnionFind{

    int[] fathers=null;
    boolean[] islands=null;


    public UnionFind(int x){

        fathers=new int[x];
        islands = new boolean[x];

        for(int i=0; i<x;i++){
            fathers[i]=i;
            islands[i]=false;
        }
    }

    public int find(int a){

        if(a==fathers[a]){
            return a;
        }

        return fathers[a]=find(fathers[a]);
    }

    public void union(int a, int b){

    
            fathers[a]=fathers[b];
        
    }

    public void markIsland(int a){

        islands[a]=true;
    }

    public boolean checkIsland(int a){
        return islands[a];
    }

    
}
