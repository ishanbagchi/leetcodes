class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        
        int maxPath = 1, currLen, i;
        String prev;
        for (String word : words) {
            currLen = 1;
            StringBuilder sb = new StringBuilder(word);
            for (i = 0; i < word.length(); i++) {
                sb.deleteCharAt(i);
                prev = sb.toString();
			    currLen = Math.max(currLen, map.getOrDefault(prev, 0) + 1);
                sb.insert(i, word.charAt(i));
            }
            map.put(word, currLen);
            maxPath = Math.max(maxPath, currLen);
        }
        
        return maxPath;
    }
}