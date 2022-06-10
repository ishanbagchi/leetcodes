class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length, result = 0, max = 0;
        
        for (int i = 1; i < len; i++) {
            result = Math.max(result, values[i - 1] + i - 1);
            max = Math.max(max, result + values[i] - i);
        }
        
        return max;
    }
}