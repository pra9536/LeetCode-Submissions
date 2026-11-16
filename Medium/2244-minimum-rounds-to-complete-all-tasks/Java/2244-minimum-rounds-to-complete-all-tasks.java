class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int total = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            if(val == 1) return -1;

            if(val % 3 == 0) total += val / 3;

            else if(val % 3 == 2) {
                total += val / 3;
                total++;
            }

            else if(val % 3 == 1) {
                val -= 4;
                total += val / 3;
                total += 2;
            }
        }
        return total;
    }
}