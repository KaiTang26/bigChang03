import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList<>();

        if(n<=0){
            return  results;
        }

        backTrack(0, 0, "", n, results);

        return results;
        
    }


    public void backTrack(int open, int close, String cur, int limit, List<String> results){


        if(open>limit || close>limit){
            return;
        }

        if(cur.length()==limit*2){
            results.add(cur);
            return;
        }

        if(open>close){
            backTrack(open, close+1, cur+')', limit, results);
        }

        backTrack(open+1, close, cur+'(', limit, results);

    }
}