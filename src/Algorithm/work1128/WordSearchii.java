package Algorithm.work1128;

import java.util.*;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，
 * 找出所有同时在二维网格(字符必须按照单词中的顺序，各个字母必须相邻，且不允许重复使用)
 * 和字典中出现的单词。
 * leetcode212 https://leetcode-cn.com/problems/word-search-ii/
 */
public class WordSearchii {

    public List<String> findWords(char[][] board, String[] words) {
        // 初始化字典操作
        Trie dic = new Trie();
        for (String word:words) {
            dic.insert(word);
        }
        TrieNode root = dic.root;
        
        // 初始化标志矩阵
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        
        // 初始化结果集
        Set<String> res = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                find(i, j, board, root, visited, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void find(int i, int j, char[][] board, TrieNode node, boolean[][] visited, Set<String> res) {
        System.out.println("i=" + i + ", j=" + j);
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char ch = board[i][j];
        if(!node.containsKey(ch)) {
            return;
        }
        node = node.get(ch);
        visited[i][j] = true;
        if(node.isEnd()) {
            res.add(node.getVal());
        }
        find(i, j + 1, board, node, visited, res);
        find(i, j - 1, board, node, visited, res);
        find(i + 1, j, board, node, visited, res);
        find(i - 1, j, board, node, visited, res);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        WordSearchii wordSearchii = new WordSearchii();
        String[] words = {"oath","pea","eat","rain"};
        char board[][] = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        System.out.println(wordSearchii.findWords(board, words));
    }
}
