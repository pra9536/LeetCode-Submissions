class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;

        int i = 0;
        int j = nums.size()-1;

        Collections.sort(nums);
        int sum = 0;

        while(i < j) {
            while(i < j && nums.get(i) + nums.get(j) >= target) j--;
            count += j-i;
            i++;
        }
        return count;
    }
}