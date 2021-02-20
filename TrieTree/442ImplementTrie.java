import java.util.HashMap;

class TrieTree{

    public char c;
    public HashMap<Character, TrieTree> children;
    public boolean isEnd;

    public TrieTree(){
        children= new HashMap<>();
        isEnd=false;
    }


    public TrieTree(char c){
        this.c =c;
        children= new HashMap<>();
        isEnd=false;
    }


}



public class Trie {

    public TrieTree root;



    public Trie() {
        // do intialization if necessary
        this.root = new TrieTree();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieTree current = this.root;
        HashMap<Character, TrieTree> children = current.children;

        char[] cArray = word.toCharArray();


        for(int i=0; i<cArray.length; i++){
            char c = cArray[i];
            if(children.containsKey(c)){
                current = children.get(c);
            }else{
                TrieTree newNode = new TrieTree(c);
                children.put(c, newNode);
                current = newNode;
            }
            children =current.children;
            if(i==cArray.length-1){
                current.isEnd = true;
            }
        }
    }


    public TrieTree searchHelper(String s){

        TrieTree current = this.root;
        HashMap<Character, TrieTree> children = current.children;

        char[] sArray = s.toCharArray();

        for(int i=0; i<sArray.length;i++){

            char c = sArray[i];

            if(children.containsKey(c)){

                current = children.get(c);
                children = current.children;

            }else{
                return null;
            }

            
        }

        return current;


    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here

        TrieTree tt = searchHelper(word);

        if(tt==null|| !tt.isEnd){
            return false;
        }
        return true;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here

        TrieTree tt = searchHelper(prefix);

        if(tt==null){
            return false;
        }

        return true;
        
    }
}
