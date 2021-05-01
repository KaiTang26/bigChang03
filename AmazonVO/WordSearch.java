class Solution {
    public boolean exist(char[][] board, String word) {


        int m = board.length;
        int n = board[0].length;

        boolean[][] visit = new boolean[m][n];

        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){

                visit[i][j]=true;

                if(backTrack(word, board, i, j, 0, m, n, visit)){
                    return true;
                }

                visit[i][j]=true;

            }
        }

        return false;
        
    }


    public boolean backTrack(String word, char[][] board, int x, int y, int index, int m, int n, boolean[][] visit){

        if(board[x][y]!=word.charAt(index)){
            return false;
        }

        if(index == word.length()-1){
            return true;
        }

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        for(int i=0; i<4; i++){

            int newR = x+dr[i];
            int newC = y+dc[i];

            if(newR>=0 && newR<m && newC>=0 && newC<n && !visit[newR][newC]){
                visit[newR][newC] = true;
                if(backTrack(word, board, newR, newC, index+1, m, n, visit)){
                    return true;
                }
                visit[newR][newC] = false;
            }


        }

        return false;

    }
}
