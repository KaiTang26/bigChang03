import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // write your code here


        List<List<String>> ans = new ArrayList<>();

        if(words==null || words.length==0){
            return  ans;
        }

        Trie t = new Trie();

        for(String s : words){
            t.insert(s);
        }

        dfs(ans, new ArrayList<String>(), 0, t, words[0].length());

        return ans;
    }


    public void dfs( List<List<String>> ans, List<String> subAns, int index, Trie t, int limit ){

        if(index==limit){
            ans.add(new ArrayList(subAns));
            return;
        }

        String prefix = "";

        for(String s : subAns){
            prefix += s.charAt(index);
        }

        List<String> filterW = t.find(prefix);

        if(filterW.size()==0){
            return;
        }

        for(String w: filterW){
            subAns.add(w);
            dfs(ans, subAns, index+1, t, limit);
            subAns.remove(subAns.size()-1);
        }

    }
}


class TrieNode{
    public ArrayList<String> preWords;
    public HashMap<Character, TrieNode> children;

    public TrieNode(){
        preWords = new ArrayList<>();
        children=new HashMap<>();
    }

}

class Trie{

    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String s){

        TrieNode curr = root;
        HashMap<Character, TrieNode> children =curr.children;
        curr.preWords.add(s);

        char[] cArray = s.toCharArray();
        for(int i=0; i<cArray.length; i++){
            char c = cArray[i];
            if(!children.containsKey(c)){
                children.put(c, new TrieNode());
            }
            curr = children.get(c);
            curr.preWords.add(s);

            children = curr.children;
        }

    }

    public List<String> find(String s){

        TrieNode curr = root;
        HashMap<Character, TrieNode> children =curr.children;
        if(s.equals("")){
            return curr.preWords;
        }

        char[] cArray = s.toCharArray();

        for(int i=0; i<cArray.length; i++){

            char c =cArray[i];

            if(children.containsKey(c)){

                curr = children.get(c);
                children = curr.children;
            }else{
                return new ArrayList<String>();
            }

        }

        return curr.preWords;

    }
}