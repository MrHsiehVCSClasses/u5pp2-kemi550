package u5pp;

public class Rook extends ChessPiece {

    public Rook(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    // Check if the rook can move to the specified row and column
    public boolean canMoveTo(int row, int col) {
        // Return false if the row or column is out of bounds or the same as the rook's current position
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || (row == this.row && col == this.col)) {
            return false;
        }

        // Check if the rook is moving vertically
        if (this.col == col) {
            // Determine the direction of movement
            int rowInc = (row - this.row) / Math.abs(row - this.row);
            int currRow = this.row + rowInc;

            // Check if there are any pieces blocking the rook's path
            while (currRow != row) {
                if (board[currRow][col] != null) {
                    return false;
                }
                currRow += rowInc;
            }
        }

        // Check if the rook is moving horizontally
        else if (this.row == row) {
            // Determine the direction of movement
            int colInc = (col - this.col) / Math.abs(col - this.col);
            int currCol = this.col + colInc;

            // Check if there are any pieces blocking the rook's path
            while (currCol != col) {
                if (board[row][currCol] != null) {
                    return false;
                }
                currCol += colInc;
            }
        }
        // Rook can only move vertically or horizontally
        else {
            return false;
        }

        // Check if the target square is either empty or occupied by an opponent's piece
        if (board[row][col] == null || board[row][col].isWhite != this.isWhite) {
            return true;
        }

        return false;
    }

    // Return the character representing the rook
    public String toString() {
        if (isWhite) {
            return "R";
        } else {
            return "r";
        }
    }
}