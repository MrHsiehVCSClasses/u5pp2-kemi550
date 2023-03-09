package u5pp;

public class Bishop extends ChessPiece {
    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || (row == this.row && col == this.col)) {
            return false;
        }

        int rowDiff = Math.abs(this.row - row);
        int colDiff = Math.abs(this.col - col);

        // A bishop must move diagonally and there must be no pieces in between
        if (rowDiff != colDiff) {
            return false;
        }

        // Check if there are pieces in between for bishop
        int rowInc = (row - this.row) / rowDiff;
        int colInc = (col - this.col) / colDiff;
        int currRow = this.row + rowInc;
        int currCol = this.col + colInc;

        while (currRow != row || currCol != col) {
            if (board[currRow][currCol] != null) {
                return false;
            }
            currRow += rowInc;
            currCol += colInc;
        }

        if (board[row][col] == null || board[row][col].isWhite != this.isWhite) {
            return true;
        }

        return false;
    }

    public String toString() {
        if (isWhite == false){
            return "b";
        } else {
            return "B";
        }
    }
}