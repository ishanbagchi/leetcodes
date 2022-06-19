class TrieNode {
    TrieNode[] children;
    List<String> set;
    public TrieNode() {
        set = new ArrayList<>();
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root = new TrieNode();
    void buildWords(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null)
                    cur.children[ch - 'a'] = new TrieNode();
                
                cur.children[ch - 'a'].set.add(word);
                cur = cur.children[ch - 'a'];
            }
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        TrieNode cur = trie.root;
        boolean flag = true;
        
        trie.buildWords(products);
        
        for (char ch : searchWord.toCharArray()) {
            List<String> list = new ArrayList<>();
            if (flag && cur.children[ch - 'a'] != null) {
                Collections.sort(cur.children[ch - 'a'].set);
                for (String s : cur.children[ch - 'a'].set) {
                    list.add(s);
                    if (list.size() == 3)
                        break;
                }
                cur = cur.children[ch - 'a'];
            } else
                flag = false;
            
            res.add(list);
        }
        return res;
    }
}