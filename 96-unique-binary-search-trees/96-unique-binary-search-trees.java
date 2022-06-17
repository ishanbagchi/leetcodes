class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return recursive(1, n, dp);
    }
    
    private int recursive(int left, int right, int[][] dp) {
        if (left == right) return 1;
        if (left > right) return 0;
        
        int result = 0;
        if (dp[left][right] > 0) return dp[left][right];
        
        for (int i = left; i <= right; i++) {
            int countLeft = recursive(left, i - 1, dp);
            int countRight = recursive(i + 1, right, dp);
            
            if (countLeft == 0) 
                result += countRight;
            else if (countRight == 0)
                result += countLeft;
            else
                result += countLeft * countRight;
        }
        dp[left][right] = result;
        return result;
    }
}