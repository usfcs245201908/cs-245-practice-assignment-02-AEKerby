/**
 * NQueens.java Solves problem of placing n chess queens on an n×n chessboard,
 * such that no two queens threaten each other.
 *
 * @author Austin Kerby
 *
 */
public class NQueens {

    public int queens;
    public int row;
    public int col;
    public int[][] board;

    public NQueens(int n) {
        queens = n;
        board = new int[n][n];
    }

    // N Queens Handler Method - Calls Recursive Solver
    public boolean placeNQueens() throws Exception {
        // Check that Board Exists
        if (board[0][0] == 0) {
            // Call Recursive Solve
            if (placeNQueens(0) == true) {
                return true;
            } else {
                // System.out.println("placeNQueens Failed Here");
                return false;
            }
            // Check if "n" is Less Than 0
        } else if (queens < 0) {
            throw new Exception();
            // If Something Else is Broken Return False
        } else {
            return false;
        }
    }

    // Recursive Contained Queen Method
    private boolean placeNQueens(int col) throws Exception {
        // Check Base Case
        // See If We are at The Last Column & Row
        if (col == queens) {
            printToConsole();
            return true;
        }

        // If Base Case Not Met Loop Through Columns
        for (int i = 0; i < queens; i++) {
            // System.out.println("Looping Through Columns");
            if ((isMarked(i, col) == false) && board[i][col] != 1) {
                // System.out.print("Adding Queen: ");
                // System.out.println("Row:" + row + " Col:" + col);

                board[i][col] = 1;

                // Recurse and Move to the Next Row
                if (placeNQueens(col + 1) == true) {
                    // System.out.println("Recursive Called");
                    return true;
                } else {
                    // Remove Queen if Solution Isn't Viable
                    // System.out.println("Removing Queen");
                    board[i][col] = 0;
                }
            }
        }
        // System.out.println("recursiveQ Failed Here");
        return false;
    }

    // Marked for Death Method to Find Attacking Queen
    public boolean isMarked(int row, int col) {
        int r, c;

        // Leftward Row Check
        for (c = 0; c < col; c++) {
            if (board[row][c] == 1) {
                return true;
            }
        }

        // Upwards Column Check
        for (r = 0; r <= col; r++) {
            if (board[r][col] == 1) {
                return true;
            }
        }

        // Downward Left Diagonal Check
        for (r = row, c = col; r < queens && c >= 0; r++, c--) {
            if (board[r][c] == 1) {
                return true;
            }
        }

        // Upward Left Diagonal Check
        for (r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1) {
                return true;
            }
        }
        return false;
    }

    // Print Method - Called if Board is Populated
    public void printToConsole() throws Exception {
        for (int col = 0; col < queens; col++) {
            for (int row = 0; row < queens; row++)
                if (board[row][col] == 1) {
                    System.out.print(" " + "Q" + " ");
                } else if (board[row][col] == 0) {
                    System.out.print(" " + "_" + " ");
                } else {
                    throw new Exception();
                }
            System.out.println();
        }
    }
}
