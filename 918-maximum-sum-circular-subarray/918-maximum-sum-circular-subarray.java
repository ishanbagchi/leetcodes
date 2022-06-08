class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], minSum = nums[0], tempMax = nums[0], tempMin = nums[0], sum = nums[0];
        int isFirst = 1;
        
        for (int num : nums) {
            if (isFirst++ == 1) continue;
            tempMax = Math.max(tempMax + num, num);
            maxSum = Math.max(maxSum, tempMax);
            
            tempMin = Math.min(tempMin + num, num);
            minSum = Math.min(minSum, tempMin);
            
            sum += num;
        }
        
        return maxSum > 0
            ? Math.max((sum - minSum), maxSum)
            : maxSum;
    }
}