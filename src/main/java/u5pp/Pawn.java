package u5pp;

public class Pawn extends ChessPiece{

    public Pawn(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    
    public boolean canMoveTo(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        // white pawn can move one space forward or two spaces if it's first move
        // and it cannot move backwards or move diagonally unless taking an enemy piece
        if (getIsWhite() == false){
            if (row == this.row - 1 && col == this.col && board[row][col] == null)
                return true;
            if (this.row == 7 && row == this.row - 2 && col == this.col && board[row - 1][col] == null && board[row][col] == null)
                return true;
            if (row == this.row - 1 && (col == this.col + 1 || col == this.col - 1) && board[row][col] != null && board[row][col].isWhite)
                return true;
            return false;
        }
        // black pawn can move one space forward or two spaces if it's first move
        // and it cannot move backwards or move diagonally unless taking an enemy piece
        else {
            if (row == this.row + 1 && col == this.col && board[row][col] == null)
                return true;
            if (this.row == 0 && row == this.row + 2 && col == this.col && board[row + 1][col] == null && board[row][col] == null)
                return true;
            if (row == this.row + 1 && (col == this.col + 1 || col == this.col - 1) && board[row][col] != null && !board[row][col].isWhite)
                return true;
            return false;
        }
    }
    public void doMove(int row, int col) {
        board[row][col] = this;
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
    }

    public String toString() {
        if (isWhite == false){
            return "p";
        }
        else {
            return "P";
        }
    }
}