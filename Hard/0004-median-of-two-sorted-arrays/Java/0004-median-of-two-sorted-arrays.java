class Solution {
    public void merge(int []nums1, int []nums2, int []temp){
      int i = 0;
      int j = 0;
      int k = 0;
      while(i < nums1.length && j < nums2.length){
        if(nums1[i] < nums2[j]){
          temp[k++] = nums1[i++];
        } else {
            temp[k++] = nums2[j++];
        }
      }
      while(i < nums1.length){
        temp[k++] = nums1[i++];
      }
      while(j < nums2.length){
        temp[k++] = nums2[j++];
      }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int m = nums1.length;
     int n = nums2.length;
     int temp[] = new int[m+n];
     merge(nums1, nums2, temp);

      double median = 0;
      if((m+n)%2 != 0) {
        median = temp[(m+n)/2];
      } else {
        int m1 = (m+n)/2;
        median = (double)(temp[m1] + temp[m1-1])/2;
      }
      return median;
    }
}