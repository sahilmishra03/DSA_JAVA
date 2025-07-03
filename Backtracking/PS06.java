package Backtracking;

public class PS06 {

    // Solves the Sudoku using Backtracking
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // ✅ Base Case: If we've filled all rows, puzzle is solved
        if (row == 9) {
            return true;
        }

        // ✅ Calculate next cell position
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // ✅ If current cell is already filled, move to next
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // ✅ Try all digits from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place digit

                // ✅ Recurse for next cell
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }

                sudoku[row][col] = 0; // ❌ Backtrack if solution not found
            }
        }

        return false; // ❌ No valid digit found for this cell
    }

    // Checks whether it's safe to place a digit at sudoku[row][col]
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // 🔍 Check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit)
                return false;
        }

        // 🔍 Check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit)
                return false;
        }

        // 🔍 Check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }

        return true; // ✅ It's safe to place the digit
    }

    // Prints the Sudoku grid
    public static void printSudoku(int[][] sudoku) {
        System.out.println("🔢 Final Sudoku Grid:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to run the solver
    public static void main(String[] args) {
        // 🧩 Initial Sudoku puzzle (0 = empty cell)
        int[][] sudoku = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        // 🚀 Start solving
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("✅ Sudoku Solved Successfully!");
            printSudoku(sudoku);
        } else {
            System.out.println("❌ Unable to solve the Sudoku.");
        }
    }
}
