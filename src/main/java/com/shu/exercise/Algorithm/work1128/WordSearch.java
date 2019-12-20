package Algorithm.work1128;

public class WordSearch {


    public boolean exist(char[][] board, String word) {
        Boolean flag = new Boolean(false);
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (find(i, j, board, word, 0, visited, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int i, int j, char[][] board, String word, int index, boolean[][] visited, Boolean flag) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || index >= word.length() || flag) {
            return false;
        }
        if(word.charAt(index) == board[i][j]) {
            visited[i][j] = true;
            if (index + 1 == word.length()) {
                flag.booleanValue();
                return true;
            }
        } else {
            return false;
        }
        return find(i, j + 1, board, word, index + 1, visited, flag) ||
                find(i, j - 1, board, word, index + 1, visited, flag) ||
                find(i + 1, j, board, word, index + 1, visited, flag) ||
                find(i - 1, j, board, word, index + 1, visited, flag);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";  //true
        String word2 = "SEE";  //true.
        String word3 = "ABCB";  //false.

        WordSearch wordSearch = new WordSearch();
//        System.out.println(wordSearch.exist(board, word1));
        System.out.println(wordSearch.exist(board, word2));
//        System.out.println(wordSearch.exist(board, word3));
    }
}
