package ekwong.question36;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        // 1. every row
        // 2. every column
        // 3. every grid
        for (char[] row : board) {
            Set<Character> numRow = generateSet();
            for (char r : row) {
                if ('.' != r) {
                    if (!numRow.remove(r)) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> numColumn = generateSet();
            for (char[] row : board) {
                if (row[i] != '.') {
                    if (!numColumn.remove(row[i])) {
                        return false;
                    }
                }
            }
        }

        Set<Character> numGrid = generateSet();
        for (int i = 0; i < 3; i++) {
            char[] grid = board[i];
            for (int j = 0; j < 3; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 0; i < 3; i++) {
            char[] grid = board[i];
            for (int j = 3; j < 6; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 0; i < 3; i++) {
            char[] grid = board[i];
            for (int j = 6; j < 9; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 3; i < 6; i++) {
            char[] grid = board[i];
            for (int j = 0; j < 3; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 3; i < 6; i++) {
            char[] grid = board[i];
            for (int j = 3; j < 6; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 3; i < 6; i++) {
            char[] grid = board[i];
            for (int j = 6; j < 9; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }

        numGrid = generateSet();
        for (int i = 6; i < 9; i++) {
            char[] grid = board[i];
            for (int j = 0; j < 3; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 6; i < 9; i++) {
            char[] grid = board[i];
            for (int j = 3; j < 6; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        numGrid = generateSet();
        for (int i = 6; i < 9; i++) {
            char[] grid = board[i];
            for (int j = 6; j < 9; j++) {
                char item = grid[j];
                if (item != '.') {
                    if (!numGrid.remove(item)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Set<Character> generateSet() {
        Set<Character> number = new HashSet<>();
        number.add('1');
        number.add('2');
        number.add('3');
        number.add('4');
        number.add('5');
        number.add('6');
        number.add('7');
        number.add('8');
        number.add('9');
        return number;
    }
}
