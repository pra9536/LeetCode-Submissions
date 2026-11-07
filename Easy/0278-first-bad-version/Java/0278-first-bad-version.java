/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        int ans = 0;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(isBadVersion(mid)) {
            //   ans = mid;
              right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : -1;
    }
}