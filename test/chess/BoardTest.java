package chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void newBoard_verifyPiecePlacement() throws Exception {
        // when
        final Board board = new Board();

        // then
        for (int i = 0; i < 8; i++) {
            assertPieceTypePlacement(board, PieceType.PAWN, i);
        }

        assertPieceTypePlacement(board, PieceType.ROOK, 0);
        assertPieceTypePlacement(board, PieceType.KNIGHT, 1);
        assertPieceTypePlacement(board, PieceType.BISHOP, 2);

        assertPieceTypePlacement(board, PieceType.QUEEN, 3);
        assertPieceTypePlacement(board, PieceType.KING, 4);

        assertPieceTypePlacement(board, PieceType.BISHOP, 5);
        assertPieceTypePlacement(board, PieceType.KNIGHT, 6);
        assertPieceTypePlacement(board, PieceType.ROOK, 7);
    }

    @Test
    public void movePiece_beforeAndAfterPiecePlacement() throws Exception {
        // given
        final Board board = new Board();
        final Position from = new Position(0, 0);
        final Position to = new Position(3, 0);

        final ChessPiece piece = board.getPieceAt(from);

        // before
        assertTrue(board.hasPieceAt(from));
        assertFalse(board.hasPieceAt(to));

        // when
        board.movePiece(from, to);

        // then
        assertFalse(board.hasPieceAt(from));
        assertTrue(board.hasPieceAt(to));
        assertEquals(piece, board.getPieceAt(to));
    }

    private void assertPieceTypePlacement(Board board, PieceType type, int column) {
        final ChessPiece whitePiece = ChessPiece.from(PieceColor.WHITE, type);
        final ChessPiece blackPiece = ChessPiece.from(PieceColor.BLACK, type);

        final int edgeOffset;
        if (type == PieceType.PAWN) {
            edgeOffset = 1;
        } else {
            edgeOffset = 0;
        }

        assertEquals(whitePiece, board.getPieceAt(new Position(edgeOffset, column)));
        assertEquals(blackPiece, board.getPieceAt(new Position(7 - edgeOffset, column)));
    }
}
