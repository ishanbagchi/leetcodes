class Solution {
    public int maxSubArray(int[] nums) {
        /*int sum = 0;
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;*/
        int sum = 0;
        int max = 0;

        for (int num : nums) {
            sum = (sum + num > 0) ? sum + num : 0;
            max = Math.max(max, sum);
        }

        if (max == 0 && nums.length >= 1) {
            max = nums[0];
            for(int num : nums)
                max = Math.max(max, num);
        }

        return max;
    }
}