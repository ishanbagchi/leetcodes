class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        if(len == 1 || nums[0] < nums[len - 1])
            return nums[0];
        
        if (len == 2)
            return Math.min(nums[0], nums[1]);
        
        int left = 0, right = len - 1, mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            else if (nums[mid] < nums[right])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}