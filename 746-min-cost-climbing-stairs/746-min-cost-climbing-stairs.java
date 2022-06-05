class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = cost[1], c = cost[0];
        
        for (int i = 2; i < cost.length; i++) {
            a = cost[i] + Math.min(b, c);
            c = b;
            b = a;
        }
        
        return Math.min(b, c);
    }
}