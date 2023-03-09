package u5pp;

import java.util.Scanner;

public class Chess {

    ChessPiece [][] board = new ChessPiece [8][8];

    /**
     * Used to print a chess board out.
     */
    public static String boardToString(ChessPiece[][] board) {

        String output = "";
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }
        
        output += "\n";
        output += "  " + "┌───" + "┬───".repeat(7) + "┐";
        output += "\n";
        for(int r = 0; r < board.length; r++) {
            output += (r)+1 + " │";
            for(int c = 0; c < board[r].length; c++) {
                output += " ";
                if(board[r][c] == null) {
                    output += " ";
                } else {
                    output += board[r][c];
                }
                output += " │";
            }
            output += (" " + (r+1));
            output += "\n";
                    
            if(r == board.length-1) {
                output += "  " + "└───" + "┴───".repeat(7) + "┘";
            } else {
                output += "  " + "├───" + "┼───".repeat(7) + "┤";
            }
            output += "\n";
        }
        
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }

        return output;
        
    }
    //Initializes board do you know how annoying this shit was????
    public static void play(Scanner scanner){
        ChessPiece[][] board = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(board, 1, i, true);
            board[6][i] = new Pawn(board, 6, i, false);
            }
                board[0][0] = new Rook(board, 0, 0, true);
                board[0][7] = new Rook(board, 0, 7, true);
                board[7][0] = new Rook(board, 7, 0, false);
                board[7][7] = new Rook(board, 7, 7, false);
                board[0][1] = new Knight(board, 0, 1, true);
                board[0][6] = new Knight(board, 0, 6, true);
                board[7][1] = new Knight(board, 7, 1, false);
                board[7][6] = new Knight(board, 7, 6, false);
                board[0][2] = new Bishop(board, 0, 2, true);
                board[0][5] = new Bishop(board, 0, 5, true);
                board[7][2] = new Bishop(board, 7, 2, false);
                board[7][5] = new Bishop(board, 7, 5, false);
                board[0][3] = new Queen(board, 0, 3, true);
                board[7][3] = new Queen(board, 7, 3, false);
                board[0][4] = new King(board, 0, 4, true);
                board[7][4] = new King(board, 7, 4, false);

                System.out.println(boardToString(board));
        }
    public static int getWinner(ChessPiece[][] board) {

        int whiteKingCount = 0;
        int blackKingCount = 0;
        
        for (ChessPiece[] row : board) {
            for (ChessPiece piece : row) {
                if (piece instanceof King) {
                    if (piece.getIsWhite()) {
                        whiteKingCount++;
                    } else {
                        blackKingCount++;
                    }
                }
            }
        }
        if (whiteKingCount > blackKingCount) {
            return 1;
        } else if (blackKingCount > whiteKingCount) {
            return -1;
        } else {
            return 0;
        }
    }
}
