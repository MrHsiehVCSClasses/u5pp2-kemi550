package u5pp;

public class King extends ChessPiece {

    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col) {
        if (!isMoveValid(row, col)) {
            return false;
        }
        if (isKingInCheck(row, col)) {
            return false;
        }
        ChessPiece destination = board[row][col];
        return destination == null || destination.isWhite != isWhite;
    }

    private boolean isMoveValid(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        int rowDiff = Math.abs(this.row - row);
        int colDiff = Math.abs(this.col - col);
        return rowDiff <= 1 && colDiff <= 1 && (rowDiff + colDiff > 0);
    }

    private boolean isKingInCheck(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isEnemyKing(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEnemyKing(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        ChessPiece piece = board[row][col];
        return piece instanceof King && piece.isWhite != isWhite;
    }

    public String toString() {
        return isWhite ? "K" : "k";
    }

}