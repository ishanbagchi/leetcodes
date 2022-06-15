class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        
        wordDict.forEach((word) -> {
            set.add(word);
        });
        
        int len = s.length(), i, j;
        int[] arr = new int[len];
        String currWord;
        
        for (i = 0; i < len; i++) {
            for (j = 0; j <= i; j++) {
                currWord = s.substring(j, i + 1);
                if (set.contains(currWord))
                    arr[i] += j == 0 ? 1 : arr[j - 1];
            }
        }
        
        return arr[len - 1] > 0;
    }
}