class Solution {
    public int maxProduct(int[] nums) {
        int curr = 1, i, len = nums.length;
        int max = Integer.MIN_VALUE;
        
        for (i = 0; i < len; i++) {
            curr *= nums[i];
            max = Math.max(max, curr);
            if (curr == 0) curr = 1;
        }
      
        curr = 1;
      
        for (i = len - 1; i >= 0; i--) {
            curr *= nums[i];
            if (curr > max) max = curr;
            if (curr == 0) curr = 1;
        }
      
        return max;
    }
}