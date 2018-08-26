package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Algorithm_36_Valid_Sudoku {

    private boolean isOk(char[] chars) {
        int[] t = new int[9];
        for (int i = 0; i < 9; i++) {
            if (0 <= chars[i] - '1' && chars[i] - '1' <= 8) {
                t[chars[i] - '1']++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (t[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isOk(board[i])) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            char[] temp = new char[9];
            for (int j = 0; j < 9; j++) {
                temp[j] = board[j][i];
            }
            if (!isOk(temp)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            int a = i % 3 * 3;
            int b = i / 3 * 3;

            char[] temp = new char[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[j * 3 + k] = board[a + j][b + k];
                }
                if (!isOk(temp)) {
                    return false;
                }
            }

        }

        return true;
    }
    public static void main(String[] args) {

        Algorithm_36_Valid_Sudoku solution = new Algorithm_36_Valid_Sudoku();
        System.out.println();
    }
}
