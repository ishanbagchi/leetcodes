class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        if (word1.contains(word2)) return word1.length() - word2.length();
        if (word2.contains(word1)) return word2.length() - word1.length();
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] arr = new int[len1 + 1][len2 + 1];
        int       i, j;
        
        for (i = 0; i <= len1; i++) {
            for (j = 0; j <= len2; j++){
                
                if (i == 0 || j == 0)
                    arr[i][j] = i + j;
                else
                    arr[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1))
                        ? arr[i - 1][j - 1]
                        : 1 + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        
        return arr[len1][len2];
    }
}