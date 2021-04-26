class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = new String(sArray);

            if(map.containsKey(key)){
                map.put(key, map.get(key).add(s));
            }else{
                map.put(key, new ArrayList<>(s));
            }

        }


        List<List<String>> ans = new ArrayList<>();

        for(String key : map.keySet()){

            ans.add(map.get(key));
        }

        return ans;
        
    }
}
