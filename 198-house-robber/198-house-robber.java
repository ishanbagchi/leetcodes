class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < len; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[len - 1];
    }
}