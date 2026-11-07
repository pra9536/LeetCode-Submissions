class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int []indegree = new int[numCourses];

        for(int []ele : prerequisites) {
            int a = ele[0], b = ele[1];

            graph.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<numCourses; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int front = queue.poll();

            ans.add(front);

            for(int i = 0; i<graph.get(front).size(); i++) {
                indegree[graph.get(front).get(i)]--;

                if(indegree[graph.get(front).get(i)] == 0) queue.add(graph.get(front).get(i));
            }

            
        }


            if(ans.size() != numCourses) return new int[]{};
            return ans.stream().mapToInt(Integer::intValue).toArray();


    }
}