import java.security.PublicKey;
import java.util.Map;

import jdk.tools.jlink.resources.plugins;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {


        List<String> results = new ArrayList<>();
        Set<String> set = new Set(words);


        TrieTree tTree = new TrieTree();

        for(String w : words){
            tTree.insert(w);   
        }




        int m = board.length;
        int n = board[0].length;

        boolean[][] visit = new boolean[m][n];


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                visit[i][j]=true;

                backTrack(board, tTree, visit, i, j, "", m, n, results);

                visit[i][j]=false;

            }
        }

        return result;
    }


    public void backTrack(char[][] board, TrieTree tTree, boolean[][] visit, int x, int y, String word, int m, int n, List<String> results){

        if(x==m || y==n){
            return;
        }

        word += board[x][y];

        if(!tTree.findPrefix(word)){
            return;
        }

        if(tTree.findWord(word)){
            results.add(word);
            return;
        }


        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};


        for(int i=0; i<4; i++){

            int nr = x+dr[i];
            int nc = y+dc[i];

            if(nr>=0 && nr<m && nc>=0 && nc<n && !visit[nr][nc]){

                visit[nr][nc]=true;

                backTrack(board, tTree, visit, nr, nc, word, m, n, results);

                visit[nr][nc]=false;
            }

            
        }

    }
}


class TrieNode{

    public char root;
    public Map<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode(){
        this.children = new HashMap<>();
    }

    public TrieNode(char c){
        this.root =c;
        this.children = new HashMap<>();
        isWord = false;
    }

}

class TrieTree{

    public TrieNode root;

    public TrieTree(){

        this.root = new TireNode();
    }

    public void insert(String w){

        TrieNode current = this.root;
        Map<Character, TrieNode> children = current.children;

        char[] chars = w.toCharArray();

        for(int i=0; i<chars.length; i++){

            char c = chars[i];
            if(!children.containsKey(c)){
                TrieNode node = new TrieNode(c);
                children.put(c, node);
            }

            current = children.get(c);
            children = current.children;

            if(i==w.length()-1){
                current.isWord=true;
            }
        }
    }

    public boolean findPrefix(String w){

        TrieNode node = help(w);

        if(node !=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean findWord(String w){
        TrieNode node = help(w);

        if(node ==null || !node.isWord){
            return false;
        }else{
            return true;
        }
    }

    public TrieNode help(String w){

        TrieNode current = this.root;
        Map<Character, TrieNode> children = current.children;

        for(char c : w.toCharArray()){

            if(!children.containsKey(c)){
                return null;
            }

            current = children.get(c);
            children =current.children;
        }

        return current;
    }
}
