package Algorithm.work1127;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效
 * leetcode36 https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(null == board) {
            return false;
        }
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] blocks = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>(9);
            cols[i] = new HashSet<>(9);
            blocks[i] = new HashSet<>(9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if(current == '.') {
                    continue;
                }
                if(rows[i].contains(current) ||
                        cols[j].contains(current) || blocks[((i/3) * 3 + j/3)].contains(current)) {
                    return false;
                }
                rows[i].add(current);
                cols[j].add(current);
                blocks[((i/3) * 3 + j/3)].add(current);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        validSudoku.isValidSudoku(board);
    }
}
