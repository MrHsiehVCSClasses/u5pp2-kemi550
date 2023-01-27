package u5pp;

public class Knight extends ChessPiece {
    
    public Knight(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col) {
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.col);
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            return true;
        }
        return false;
    }

    public void moveTo(int row, int col) {
        if (canMoveTo(row, col)) {
            ChessPiece[][] board = getBoard();
            board[this.row][this.col] = null;
            this.row = row;
            this.col = col;
            board[row][col] = this;
        } else {
            throw new IllegalArgumentException("Invalid move for Knight piece");
        }
    }
    
    public String toString() {
        return (getIsWhite() ? "N" : "n");
    }
}
