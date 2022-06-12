class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastIdx = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        
        int result = 0, total = 0, idx = -1, len = nums.length;
        for (int i = 0; i < len; i++) {
            total += nums[i];
            if (lastIdx.containsKey(nums[i]))
                idx = Math.max(idx, lastIdx.get(nums[i]));
            
            result = (idx == -1)
                ? Math.max(result, total)
                : Math.max(result, total - sum.get(idx));
            
            lastIdx.put(nums[i], i);
            sum.put(i, total);
        }
        return result;
    }
}