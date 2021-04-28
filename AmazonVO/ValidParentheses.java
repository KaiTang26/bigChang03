import java.util.Map;

class Solution {
    public boolean isValid(String s) {


        char[] sChars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        set<Character> openSet = new HashSet<>();
        openSet.add('(');
        openSet.add('{');
        openSet.add('[');

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');



        for(char c:sChars){
            if(stack.isEmpty()){
                if(openSet.contains(c)){
                    stack.push(c);
                }else{
                    return false;
                }
            }else{
                if(openSet.contains(c)){
                    stack.push(c);
                }else{
                    char bracket = stack.peek();

                    if(openSet.contains(bracket)&&map.get(bracket)==c){
                        stack.pop();
                    }else{
                        return false;
                    }
                 
                }
            }
        }

        return stack.isEmpty();
        
    }
}