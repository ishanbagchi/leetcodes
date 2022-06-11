class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0, len = nums.length;
        for (int num : nums) total += num;
        
        int maxLen = -1, current = 0;
        for (int i = 0, j = 0; j < len; j++) {
            current += nums[j];
            while (i <= j && current > total - x) current -= nums[i++];
            if (current == total - x) maxLen = Math.max(maxLen, j - i + 1);
        }
        
        return maxLen == -1 ? -1 : len - maxLen;
    }
}