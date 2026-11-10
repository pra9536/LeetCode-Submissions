class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        // reverse the graph
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i<graph.length; i++) list.add(new ArrayList<>());

        for(int i = 0; i<graph.length; i++) {
            for(int j = 0; j<graph[i].length; j++) {
                int a = graph[i][j];

                list.get(a).add(i);
            }
        }

        // find indegree

        int[] indegree = new int[graph.length];

        for(int i = 0; i<list.size(); i++) {
           for(int j = 0; j<list.get(i).size(); j++) {
            indegree[list.get(i).get(j)]++;
           }
        }

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int val = q.remove();

            ans.add(val);

            for(int i = 0; i<list.get(val).size(); i++) {
                indegree[list.get(val).get(i)]--;
                if(indegree[list.get(val).get(i)] == 0) {
                    q.add(list.get(val).get(i));
                }
            }
        }

        Collections.sort(ans);

        return ans;

    }
}