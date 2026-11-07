class Solution {

    boolean isPrime[];

    public void buildSeive(int maxElement){
        isPrime = new boolean[maxElement + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int num = 2; num*num <= maxElement; num++){
            if(isPrime[num]){
                for(int multiple = num * num; multiple <= maxElement; multiple += num){
                    isPrime[multiple] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxElement = 0;


        for(int i = 0; i<n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

            maxElement = Math.max(maxElement, nums[i]);
        }

        buildSeive(maxElement);

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];

        queue.add(0);

        visited[0] = true;

        HashSet<Integer> set = new HashSet<>();

        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                 int i = queue.remove();
                 
                 if(i == n - 1){
                    return count;
                 }

                 if(i-1 >= 0 && !visited[i-1]){
                    queue.add(i-1);
                    visited[i-1] = true;
                 }

                if(i+1 < n && !visited[i+1]){
                    queue.add(i+1);
                    visited[i+1] = true;
                }

                if(!isPrime[nums[i]] || set.contains(nums[i])){
                    continue;
                }

                for(int multiple = nums[i]; multiple <= maxElement; multiple += nums[i]){
                    if(!map.containsKey(multiple)){
                        continue;
                    }

                    for(int j : map.get(multiple)){
                        if(!visited[j]){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
                set.add(nums[i]);
            }
            count++;
        }
        return -1;
    }
}