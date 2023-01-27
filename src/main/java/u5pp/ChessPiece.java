package u5pp;

public class ChessPiece {

    protected ChessPiece[][] board;
    protected int row;
    protected int col;
    protected boolean isWhite;

    
    public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite){
        this.board = board;
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }
    
    public ChessPiece[][] getBoard(){
        return board;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public boolean getIsWhite(){
        return isWhite;
    }

    public boolean canMoveTo(int row, int col){
        //Checks is destination is out of bounds
        if (row < 0 || row >= 8 || col < 0 || col >= 8) {
            return false;
        }
        //Checks if destination has a piece that is the same color
        if (board[row][col] != null && board[row][col].isWhite == this.isWhite) {
            return false;
        }
        return true;
    }

    public void moveTo(int row, int col){
        
    }
    //real 
    public String toString(){
        return "idontknowhowtocode";
    }
}