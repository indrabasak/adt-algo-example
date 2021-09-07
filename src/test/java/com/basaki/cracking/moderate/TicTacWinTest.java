package com.basaki.cracking.moderate;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static com.basaki.cracking.moderate.TicTacWin.hasWon;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacWinTest {

    TicTacWin.Piece[][] getBoard() {
        TicTacWin.Piece[][] board = new TicTacWin.Piece[3][3];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], TicTacWin.Piece.Empty);
        }

        return board;
    }

    @Test
    void testHasWonRows() {
        TicTacWin.Piece[][] board = getBoard();
        board[0][0] = TicTacWin.Piece.Blue;
        board[0][1] = TicTacWin.Piece.Blue;
        board[0][2] = TicTacWin.Piece.Blue;
        assertEquals(board[0][0], hasWon(board));

        board[0][2] = TicTacWin.Piece.Red;
        assertEquals(TicTacWin.Piece.Empty, hasWon(board));
    }

    @Test
    void testHasWonColumns() {
        TicTacWin.Piece[][] board = getBoard();
        board[0][0] = TicTacWin.Piece.Blue;
        board[1][0] = TicTacWin.Piece.Blue;
        board[2][0] = TicTacWin.Piece.Blue;
        assertEquals(board[0][0], hasWon(board));

        board[2][0] = TicTacWin.Piece.Red;
        assertEquals(TicTacWin.Piece.Empty, hasWon(board));
    }

    @Test
    void testHasWonDiagonals() {
        TicTacWin.Piece[][] board = getBoard();
        board[0][0] = TicTacWin.Piece.Blue;
        board[1][1] = TicTacWin.Piece.Blue;
        board[2][2] = TicTacWin.Piece.Blue;
        assertEquals(board[0][0], hasWon(board));

        board[2][2] = TicTacWin.Piece.Red;
        assertEquals(TicTacWin.Piece.Empty, hasWon(board));
    }
}
