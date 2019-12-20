package Algorithm.work1127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 解数独
 * leetcode37 https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SodokuSolver {

    boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {
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
                char c = board[i][j];
                if(c != '.') {
                    rows[i].add(c);
                    cols[j].add(c);
                    blocks[(i/3) * 3 + j/3].add(c);
                }
            }
        }

        backtrack(0, 0, rows, cols, blocks, board);
    }

    private void backtrack(int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] blocks, char[][] board) {
        if(board[row][col] == '.') {
            for (int num = 1; num <= 9; num++) {
                if (isMarked(num, row, col, rows, cols, blocks, board)) {
                    place(num, row, col, rows, cols, blocks, board);
                    if ((col + 1 == 9) && (row + 1 == 9)) {
                        return;
                    } else {
                        if (col == 9 - 1) backtrack(row + 1, 0, rows, cols, blocks, board);
                        else backtrack(row, col + 1, rows, cols, blocks, board);
                    }
//                    if (!sudokuSolved) {
                        resetSituation(num, row, col, rows, cols, blocks, board);
//                    }
                }
            }
        } else {
            if ((col + 1 == 9) && (row + 1 == 9)) {
                return;
            } else {
                if (col == 9 - 1) backtrack(row + 1, 0, rows, cols, blocks, board);
                else backtrack(row, col + 1, rows, cols, blocks, board);
            }
        }
    }

    private void placeNextNumbers(int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] blocks, char[][] board) {
        if ((col + 1 == 9) && (row + 1 == 9)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == 9 - 1) backtrack(row + 1, 0, rows, cols, blocks, board);
                // go to the next column
            else backtrack(row, col + 1, rows, cols, blocks, board);
        }
    }

    private void place(int num, int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] blocks, char[][] board) {
        char c = (char) (num + 48);
        board[row][col] = c;
        rows[row].add(c);
        cols[col].add(c);
        blocks[((row / 3 * 3) + col / 3)].add(c);
    }

    private void resetSituation(int num, int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] blocks, char[][] board) {
        char c = (char)(num + 48);
        board[row][col] = '.';
        rows[row].remove(c);
        cols[col].remove(c);
        blocks[((row / 3 * 3) + col / 3)].remove(c);
    }

    private boolean isMarked(int number, int row, int col,
                             Set<Character>[] rows, Set<Character>[] cols,
                             Set<Character>[] blocks, char[][] board) {
        char c = (char) (number + 48);
        if (!rows[row].contains(c) && !cols[col].contains(c)
                && !blocks[((row / 3 * 3) + col / 3)].contains(c)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SodokuSolver sodokuSolver = new SodokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sodokuSolver.solveSudoku(board);
        Arrays.stream(board).forEach(
                chars -> {
                    for (char c : chars) {
                        System.out.printf(c + " ");
                    }
                    System.out.println();
                }
        );
    }
}
