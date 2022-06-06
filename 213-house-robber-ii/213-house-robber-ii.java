class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        
        int[] sum1 = new int [len];
        int[] sum2 = new int [len];
        
        sum1[0] = nums[0];
        sum1[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < len - 1; i++) {
            sum1[i] = Math.max(sum1[i - 2] + nums[i], sum1[i - 1]);
        }
        
        sum2[1] = nums[1];
        sum2[2] = Math.max(nums[1], nums[2]);
        
        for(int i = 2; i < len; i++) {
            sum2[i] = Math.max(sum2[i - 2] + nums[i], sum2[i - 1]);
        }
        return Math.max(sum1[len - 2], sum2[len - 1]);
    }
}