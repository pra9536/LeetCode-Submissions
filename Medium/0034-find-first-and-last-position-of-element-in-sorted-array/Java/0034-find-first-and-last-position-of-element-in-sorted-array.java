class Solution {

    // first occurrence
    public int firstIndex(int []nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int firstIdx = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) 
            {
                firstIdx = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstIdx;
    }

    // last occurrence
        public int lastIndex(int []nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int lastIdx = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) 
            {
                lastIdx = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIdx;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[]{-1, -1};

        int firstIdx = firstIndex(nums, target);

        if(firstIdx == -1) {
            return new int[]{-1, -1};
        }

        int lastIdx = lastIndex(nums, target);

        return new int[]{firstIdx, lastIdx};
    }
}