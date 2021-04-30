import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        int takenCourse = 0;


        int[] indegree = new int[numCourses];

        Map<Integer, Set<Integer>> neightbors = new HashMap<>();

        for(int[] p : prerequisites){

            int courseFirst = p[1];
            int courseSecond = p[0];
            indegree[courseSecond]+=1;
            if(!neightbors.containsKey(courseFirst)){
                neightbors.put(courseFirst, new HashSet<>());               
            }
            neightbors.get(courseFirst).add(courseSecond);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()){
            int pre = queue.poll();
            takenCourse++;

            if(neightbors.containsKey(pre)){

                for(int n : neightbors.get(pre)){

                    indegree[n]-=1;
    
                    if(indegree[n]==0){
                        queue.offer(n);
                    }
                }

            }

            

        }

        return takenCourse==numCourses;
        
    }
}
