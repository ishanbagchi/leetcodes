class Solution {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return 0;
        
        int maxLen = 0, sign = 1, firstPositive = -1, firstNegative = -1;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                sign = 1;
                firstPositive = -1;
                firstNegative = -1;
            } else if (nums[i] > 0) {
                if(firstPositive == -1) firstPositive = i;
            } else {
                sign = sign * -1;
                if (firstNegative == -1) firstNegative = i;
            }
            
            if (sign > 0) {
                if (firstPositive >= 0)
                    maxLen = Math.max(maxLen, i + 1 - firstPositive);
                
                if (firstNegative >= 0 )
                    maxLen = Math.max(maxLen, i + 1 - firstNegative);
                
            } else if (sign < 0)
                maxLen = Math.max(maxLen, i - firstNegative);
        }
        
        return maxLen;
    }
}