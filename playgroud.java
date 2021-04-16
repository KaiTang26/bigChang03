import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.xml.namespace.QName;

import jdk.nashorn.internal.ir.IdentNode;

public class Solution {
    /**
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here

        // indegree map
        Map<Integer, Integer> indegree = new HashMap<>();

        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        for(int i=0; i<numCourses; i++){

            indegree.put(i, 0);
            courseMap.put(i, new ArrayList<>());
        }

        for(int[] i : prerequisites){
            int pre = i[1];
            int course = i[0];
            indegree.put(course, indegree.get(course)+1);
            courseMap.get(pre).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int k : indegree.keySet()){
            int count = indegree.get(k);
            if(count==0){
                queue.offer(k);
            }
        }

        Set<Integer> set = new HashSet<>();


        while(!queue.isEmpty()){

            int c = queue.poll();
            set.add(c);

            for(int n : courseMap.get(c)){
                int count = indegree.get(n)-1;
                indegree.put(n, count);
                if(count==0 && !set.contains(n)){
                    queue.offer(n);
                }
            }

        }



        return set.size()==numCourses;


    }
}

