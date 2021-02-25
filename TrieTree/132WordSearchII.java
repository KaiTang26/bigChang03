import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here


        List<String> ans = new ArrayList<String>();


        if(board==null || board.length==0 || words==null || words.size()==0){
            return ans;
        }




        TireTree tt = new TireTree();

        for(String s : words){
            tt.insert(s);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                wordDFS(board, i, j, ans, tt.root);

            }
        }

        return ans;
    }

    public void wordDFS(char[][] board, int x, int y, List<String> ans, TireNode node ){

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{-1,0,1,0};

        if(node.isWord){
            if(!ans.contains(node.word)){
                ans.add(node.word);
            }
        }



        if(x<0 || x>=board.length || y<0 ||y>=board[0].length || !node.children.containsKey(board[x][y]) || board[x][y]==0){
            return;
        }

        if(node.children.containsKey(board[x][y])){

            for(int i=0; i<4; i++){
                char c = board[x][y];
                board[x][y]=0;
                wordDFS(board, x+dx[i], y+dy[i], ans, node.children.get(c));
                board[x][y]=c;
            }
        }

    }
}


class TireNode{

    public String word;
    public HashMap<Character, TireNode> children;
    public boolean isWord;

    public TireNode(){
        children=new HashMap<>();
        isWord=false;
    }
}


class TireTree{

    public TireNode root;

    public TireTree(){
        root = new TireNode();
    }

    public void insert(String s){

        TireNode current = root;
        HashMap<Character, TireNode> children = root.children;

        char[] cArray = s.toCharArray();

        for(int i=0; i<cArray.length; i++){

            char c = cArray[i];

            if(children.containsKey(c)){
                current = children.get(c);
            }else{
                TireNode tn = new TireNode();
                children.put(c, tn);
                current =tn;
            }

            children = current.children;

        }

        current.word = s;
        current.isWord =true;

    }

    public boolean find(String s){

        TireNode current = root;
        HashMap<Character, TireNode> children = root.children;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(children.containsKey(c)){
                current = children.get(c);
                children = current.children;
            }else{
                return false;
            }
        }
        return current.isWord;
    }

}