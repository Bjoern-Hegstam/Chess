package chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    private void assertPieceTypePlacement(Board board, PieceType type, int column) {
        final ChessPiece whitePiece = ChessPiece.from(PieceColor.WHITE, type);
        final ChessPiece blackPiece = ChessPiece.from(PieceColor.BLACK, type);

        final int edgeOffset;
        if (type == PieceType.PAWN) {
            edgeOffset = 1;
        } else {
            edgeOffset = 0;
        }

        assertEquals(whitePiece, board.getPieceAt(edgeOffset, column));
        assertEquals(blackPiece, board.getPieceAt(7 - edgeOffset, column));
    }
}
