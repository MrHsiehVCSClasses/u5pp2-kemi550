package u5pp;

public class Queen extends ChessPiece {
    public Queen(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col) {
        // Check if target position is out of bounds or same as current position
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || (row == this.row && col == this.col)) {
            return false;
        }
        
        int rowDiff = Math.abs(this.row - row);
        int colDiff = Math.abs(this.col - col);

        // A queen can move diagonally or horizontally/vertically
        if (rowDiff != 0 && colDiff != 0 && rowDiff != colDiff) {
            return false;
        }

        // Check if there are pieces in between for white queen
        if (getIsWhite() == true || getIsWhite() == false) {
            int rowInc;
            if (rowDiff == 0) {
                rowInc = 0;
            } else {
                rowInc = (row - this.row) / rowDiff;
            }

            int colInc;
            if (colDiff == 0) {
                colInc = 0;
            } else {
                colInc = (col - this.col) / colDiff;
            }

            int currRow = this.row + rowInc;
            int currCol = this.col + colInc;

            // Check if there are pieces in between the queen's current and target position
            while (currRow != row || currCol != col) {
                if (board[currRow][currCol] != null) {
                    return false;
                }
                currRow += rowInc;
                currCol += colInc;
            }

            // Check if target position is empty or occupied by a piece of the opposite color
            if (board[row][col] == null || board[row][col].isWhite != this.isWhite) {
                return true;
            }
        }
        
        return false;
    }

    public String toString() {
        if (isWhite == false) {
            return "q";
        } else {
            return "Q";
        }
    }
}