class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        int i = 0; 
        while(i < n) {
            int m = 0;

            while(map.getOrDefault(m, 0) > 0) {
                m++;
            }

            if(m == 0){
                list.add(0);

                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
                continue;
            }

            int[] temp = new int[m];

            int nd = m;

            while(i < n && nd > 0) {
                int v = nums[i];

                map.put(v, map.get(v) - 1);
                if(map.get(v) == 0) {
                    map.remove(v);
                }

                if(v < m && temp[v] == 0) {
                    temp[v] = 1;
                    nd--;
                }
                i++;
            }
            list.add(m);
        }

        int ans[] = new int[list.size()];
        for(i = 0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}