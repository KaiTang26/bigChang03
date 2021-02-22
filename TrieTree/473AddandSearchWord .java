import java.util.Currency;
import java.util.HashMap;

import org.graalvm.compiler.hotspot.replacements.HubGetClassNode;

import jdk.nashorn.internal.ir.IdentNode;

public class WordDictionary {
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */

     public TireNode root = new TireNode();

    public void addWord(String word) {
        // write your code here

        TireNode current = this.root;
        HashMap<Character, TireNode> children = current.children;

        char[] cArray = word.toCharArray();

        for(int i=0; i<word.length(); i++){

            if(children.containsKey(cArray[i])){
                current = children.get(cArray[i]);
            }else{
                TireNode tn = new TireNode(cArray[i]);
                children.put(cArray[i], tn);
                current = tn;
            }

            children = current.children;

        }

        current.isWord = true;


    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here

        TireNode current = this.root;
        char[] cArray = word.toCharArray();
        return searchHelper(current, cArray, 0);
    }


    public boolean searchHelper(TireNode curr, char[] cArray, int index){


        if(index==cArray.length){
            return curr.isWord;
        }

        char c = cArray[index]; // . //a
        HashMap<Character, TireNode> children = curr.children; // a

        if(c=='.'){
            for(char nc: children.keySet() ){  
                    if(searchHelper(children.get(nc), cArray, index+1)){
                        return true;
                    }

            }
            return false;

        }else if(children.containsKey(c)){
            return searchHelper(children.get(c), cArray, index+1);
        }else{

            return false;

        }

    }
}


class TireNode{

    public char c;
    public HashMap<Character, TireNode> children;
    public boolean isWord;

    public TireNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public TireNode(char root){
        c=root;
        children = new HashMap<>();
        isWord = false;
    }

}

