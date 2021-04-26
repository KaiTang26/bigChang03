import java.util.HashMap;

public class Trie {

    private TrieNode root;
    public Trie() {
        // do intialization if necessary

        this.root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here

        TrieNode current = this.root;

        HashMap<Character, TrieNode> children = current.children;

        char[] chars = word.toCharArray();

        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(!children.containsKey(c)){
                TrieNode node = new TrieNode(c);
                children.put(c, node);
                current = node;
            }else{
                current = children.get(c);
            }
            children = current.children;

            if(i==chars.length-1){
                current.isWord = true;
            }

        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here

        TrieNode node = this.helper(word);

        if(node==null){
            return false;
        }

        return node.isWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode node = this.helper(prefix);

        if(node==null){
            return false;
        }

        return true;
    }

    private TrieNode helper(String word){

        TrieNode current = this.root;
        HashMap<Character, TrieNode> children = current.children;

        char[] charArray = word.toCharArray();

        for(int i=0; i<charArray.length; i++){

            char c = charArray[i];

            if(children.containsKey(c)){
                current = children.get(c);
                children = current.children;
            }else{
                return null;
            }

        }
        return current;
    }
}

class TrieNode{
    public char content;
    public HashMap<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode(){
        this.children = new HashMap<>();
    }

    public TrieNode(char c){
        this.content = c;
        this.children = new HashMap<>();
        this.isWord = false;
    }
}