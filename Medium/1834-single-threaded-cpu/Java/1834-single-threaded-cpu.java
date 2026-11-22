class Solution {
    class Pair{
        int enq;
        int process;
        int index;

        Pair(int enq, int process, int index) {
            this.enq = enq;
            this.process = process;
            this.index = index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        
        int time = 0;

        int [][]arr = new int[tasks.length][3];
        for(int i = 0; i<tasks.length; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));

        boolean []visited = new boolean[tasks.length];

        int []ans = new int[tasks.length];

        int k = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.process != b.process ? Integer.compare(a.process, b.process) : Integer.compare(a.index, b.index));
        
        int next = 0;
        int n = arr.length;

        while(k < n) {
            if(q.isEmpty() && time < arr[next][0]) {
                time = arr[next][0];
            }

            while(next < n && time >= arr[next][0]) {
                q.add(new Pair(arr[next][0], arr[next][1], arr[next][2]));
                next++;
            }
            Pair p = q.remove();
            time += p.process;
            ans[k++] = p.index;
        }


        return ans;


    }
}