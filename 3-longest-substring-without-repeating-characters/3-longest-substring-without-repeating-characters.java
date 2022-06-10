import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> list = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        int i, j = 0;
        
        for(i = 0; i < s.length(); i++) {
            if(list.containsKey(s.charAt(i))) {
                max = Math.max(max, i - j);
                
                if(list.get(s.charAt(i)) >= j)
                    j = list.get(s.charAt(i)) + 1;
            }
            list.put(s.charAt(i), i);
        }
        max = Math.max(max, i - j);
        return max;
    }
}