class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--)
            for(int j = 0; j < n; j++) 
                matrix[i][j] +=
                    Math.min(
                        j - 1 < 0 ? Integer.MAX_VALUE : matrix[i+1][j-1],
                        Math.min(
                            matrix[i+1][j],
                            j + 1 > n - 1 ? Integer.MAX_VALUE : matrix[i+1][j+1]
                        )
                    ); 
        
		return Arrays.stream(matrix[0]).min().getAsInt();
           
    }
}