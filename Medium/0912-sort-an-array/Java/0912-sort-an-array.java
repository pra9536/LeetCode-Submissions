class Solution {
    public void sort(int[] arr, int left, int right){
        int mid = (left + right)/2;
        if(left >= right){
            return; 
        }
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int arr[], int left, int mid, int right){
        int temp[] = new int[right - left + 1];
        int low = left;
        int high = mid+1;
        int j = 0;
        while((low <= mid) && (high <= right)){
            if(arr[low] <= arr[high]){
                temp[j] = arr[low];
                low++;
            } else{
                temp[j] = arr[high];
                high++;
            }
            j++;
        }

         while(low <= mid){
            temp[j] = arr[low];
            j++;
            low++;
         }
         while(high <= right){
            temp[j] = arr[high];
            j++;
            high++;
         }

        for(j = 0; j<temp.length; j++){
            arr[left+j] = temp[j];
        }
    }
    public int[] sortArray(int[] nums) {
         sort(nums, 0, nums.length-1);
         return nums;
    }
}