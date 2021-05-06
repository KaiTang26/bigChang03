class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {


        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<username.length; i++){

            String name = username[i];

            if(!map.containsKey(name)){
                List<String> webs = new ArrayList<>();
                map.put(name, webs);
            }

            map.get(name).add(website.get(i));

        }



        return new ArrayList<>();



        
    }
}
