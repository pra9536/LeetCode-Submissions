class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();

        boolean []visited = new boolean[rooms.size()];

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int val = q.remove();

            for(int i = 0; i<rooms.get(val).size(); i++) {
                if(!visited[rooms.get(val).get(i)]) {
                    visited[rooms.get(val).get(i)] = true;
                    q.add(rooms.get(val).get(i));
                }
            }
        }

        for(int i = 0; i<visited.length; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }
}