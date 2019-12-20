package Algorithm.work1128;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search,
 * 和 startsWith 这三个操作
 * leetcode208 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

class TrieNode {
    private final int R = 26;
    private TrieNode[] links;
    private boolean isEnd;
    private String val;

    public TrieNode() {
        links = new TrieNode[R];
        this.val = "";
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void set(char ch) {
        links[ch - 'a'] = new TrieNode();
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}

public class Trie {

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curNode.containsKey(ch)) {
                curNode.set(ch);
            }
            curNode = curNode.get(ch);
        }
        curNode.setVal(word);
        curNode.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curNode.containsKey(ch)) {
                return false;
            }
            curNode = curNode.get(ch);
        }
        if(curNode.isEnd()) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curNode.containsKey(ch)) {
                return false;
            }
            curNode = curNode.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "hello";
        String prefix = "heel";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2 + " ," + param_3);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
