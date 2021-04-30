import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> dic = new HashSet<>();

        for(String s: wordList){
            dic.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);

        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            step++;

            for(int i=0; i<size; i++){
                String word = queue.poll();

                if(word.equals(endWord)){
                    return step;
                }

                for(String n : neighours(word, dic)){

                    if(!set.contains(n)){

                        queue.offer(n);
                        set.add(n);
                    }

                }
            }

        }



        return 0;



        
    }


    public List<String> neighours(String word, List<String> dic){

        List<String> adjectWords = new ArrayList<>();

        for(int i=0; i<word.length(); i++){

            char[] wordChars = word.toCharArray();
            char currentLetter = wordChars[i];

            for(char c='a'; c<='z'; c++){

                if(c!=currentLetter){
                    wordChars[i]=c;
                    String newWord = new String(wordChars);
                    if(dic.contains(newWord)){
                        adjectWords.add(newWord);
                    }
                }
            }

            wordChars[i] = currentLetter;
        }

        return adjectWords;

    }
}