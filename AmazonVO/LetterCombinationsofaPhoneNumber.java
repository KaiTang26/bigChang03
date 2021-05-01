import java.util.Map;

class Solution {


    public Map<Character, String> numberLetterMap;


    public List<String> letterCombinations(String digits) {

        numberLetterMap = new HashMap<>();
        numberLetterMap.put('2', "abc");
        numberLetterMap.put('3', "def");
        numberLetterMap.put('4', "ghi");
        numberLetterMap.put('5', "jkl");
        numberLetterMap.put('6', "mno");
        numberLetterMap.put('7', "pqrs");
        numberLetterMap.put('8', "tuv");
        numberLetterMap.put('9', "wxyz");

        List<String> comb = new ArrayList<>();

        bfs(0, digits, "", comb);

        return comb;
        
    }

    public void bfs(int index, String digits, String result, List<String> comb){

        if(result.length()==digits.length()){
            comb.add(result);
            return;
        }

        char c = digits.charAt(index);
        String letters = numberLetterMap.get(c);

        for(char l : letters.toCharArray()){

            bfs(index+1, digits, result+l, comb);
        }

        return;



    }
}