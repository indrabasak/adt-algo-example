package com.basaki.cracking.moderate;

/**
 * Tic Tac Win: Design an algorithm to figure out if someone has won a
 * game of tic-tac-toe.
 */
public class TicTacWin {

    enum Piece {Empty, Red, Blue};

    public static Piece hasWon(Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            // check rows - [i][0], [i][1], [i][2]
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }

            // check columns - [0][i], [1][i], [2][i]
            if (hasWinner(board[0][i], board[1][i], board[2][i])) {
                return board[0][i];
            }
        }

        // check diagonals - [0][0], [1][1], [2][2]
        if (hasWinner(board[0][0], board[1][1], board[2][2])) {
            return board[0][0];
        }

        // check diagonals - [2][0], [1][1], [0][2]
        if (hasWinner(board[2][0], board[1][1], board[0][2])) {
            return board[2][0];
        }

        return Piece.Empty;
    }

    private static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
        if (p1 == Piece.Empty) {
            return false;
        }

        return p1 == p2 && p2 == p3;
    }
}
