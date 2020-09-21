class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int in[] = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        //Create an adjacency list
        for(int i = 0; i < prerequisites.length; i++){
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];
            List<Integer> list = map.get(s);
            if(list == null)
                list = new ArrayList<>();
            list.add(d);
            map.put(s, list);
        }
        
        //Create an indegree array specifying indegree of all nodes
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int e = entry.getKey();
            List<Integer> list = entry.getValue();
            for(Integer a : list){
                in[a] += 1;
            }
        }
        
        //Add all the nodes with indegree 0 to the queue
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < in.length; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        
        int c = 0;
        //Remove elements from the queue and decrement the indegree of all childs
        while(!q.isEmpty()){
            
            Integer pop = q.poll();
            c++;
            List<Integer> list = map.get(pop);
            if(list != null){
                for(Integer a : list){
                    in[a] -= 1;
                    if(in[a] == 0)
                        q.add(a);
                }
            }
        }
        
        //Count of all queue elements should be equal to number of courses
        return c == numCourses;
    }
}
