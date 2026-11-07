class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int count = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums1) set.add(n);

        for(int n : nums2){
            if(set.contains(n)) count = Math.min(count, n);
        }


        if(count == Integer.MAX_VALUE) return -1;
        return count;
    }
}