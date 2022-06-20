import java.util.Collection;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        
        for (String word : words)
            set.add(word);

        Collection<String> removedWords = new LinkedList<String>();
        
        for (String str : set)
            for (int j = 1; j < str.length(); j++)
                if (set.contains(str.substring(j)))
                    removedWords.add(str.substring(j));
        
        set.removeAll(removedWords);
        
        for (String s : set)
            sb.append(s + "#");
        
        return sb.length();
    }
}