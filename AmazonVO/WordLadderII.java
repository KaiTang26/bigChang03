import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiConsumer;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> results = new ArrayList<>();

        Map<String, List<String>> wordNeighbours = nerighbours(beginWord, wordList);

        if(wordNeighbours.get(endWord)==null){
            return results;
        }

        Map<String, Integer> wordDistance = BFS(wordNeighbours, endWord);

        backTracking(results, wordDistance);

        return results;
        
    }

    public void backTracking(Map<String, List<String>> neighbours, Map<String, Integer> wordDistance, String word, List<String> comb, List<List<String>> results, Set<String> set ){

        
        int currentDis = wordDistance.get(word);

        if(currentDis==0){
            results.add(new ArrayList(comb));
        }

        List<String> wordList = neighbours.get(word);

        for(int i=0; i<wordList.size(); i++){

            String nextWord = wordList.get(i);
            int dis = wordDistance.get(nextWord);

            if(dis<currentDis && set.add(nextWord)){

                comb.add(nextWord);
                backTracking(neighbours, wordDistance, nextWord, comb, results);
                comb.remove(comb.size()-1);
                set.remove(nextWord);

            }

        }

    }



    public Map<String, Integer> BFS(Map<String, List<String>> neighbours, String endWord){

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> results = new HashMap<>();

        int count =0;
        results.put(endWord, count);
        queue.offer(endWord);
        set.add(endWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i=0; i<size; i++){
                String word = queue.poll();
                for(String neighbour: neighbours.get(word)){
                    if(!set.contains(neighbour)){

                        results.put(neighbour, count);
                        queue.offer(neighbour);
                        set.add(neighbour);

                    }
                }
            }
        }

        return results;
    }

    public Map<String, List<String>> nerighbours(String beginWord, List<String> wordList){

        List<String> allWordList = new ArrayList<>();
        allWordList.add(beginWord);
        allWordList.addAll(wordList);

        Set<String> dic = new HashSet<>();

        for(String s: allWordList){
            dic.add(s);
        }

        Map<String, List<String>> results = new HashMap<>();


        for(String word : allWordList){
            List<String> adjentWords = new ArrayList<>();
            char[] chars = word.toCharArray();

            for(int i=0; i<chars.length; i++){
                char currentChar = chars[i];

                for(char c='a'; c<='z'; c++){

                    if(c!=currentChar){
                        chars[i]=c;
                        String newWord = new String(chars);

                        if(dic.contains(newWord)){
                            adjentWords.add(newWord);
                        }
                    }
                }
                chars[i] = currentChar;

            }

            results.put(word, adjentWords);

        }

        return results;
    }
}
