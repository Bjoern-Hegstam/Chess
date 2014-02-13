package chess;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int SIDE = 8;
    private static final Map<PieceType, Piece> pieceTypes;

    static {
        pieceTypes = new HashMap<>();
    }

    private final ChessPiece[][] board = new ChessPiece[SIDE][];

    public Board() {
        initializeEmptyBoard();
        placeStartingPieces();
    }

    private void initializeEmptyBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = new ChessPiece[SIDE];
        }
    }

    private void placeStartingPieces() {
        for (int i = 0; i < SIDE; i++) {
            placePiecePair(PieceType.PAWN, i);
        }

        placePiecePair(PieceType.ROOK, 0);
        placePiecePair(PieceType.KNIGHT, 1);
        placePiecePair(PieceType.BISHOP, 2);

        placePiecePair(PieceType.QUEEN, 3);
        placePiecePair(PieceType.KING, 4);

        placePiecePair(PieceType.BISHOP, 5);
        placePiecePair(PieceType.KNIGHT, 6);
        placePiecePair(PieceType.ROOK, 7);
    }

    private void placePiecePair(PieceType type, int column) {
        final ChessPiece whitePiece = ChessPiece.from(PieceColor.WHITE, type);
        final ChessPiece blackPiece = ChessPiece.from(PieceColor.BLACK, type);

        final int edgeOffset;
        if (type == PieceType.PAWN) {
            edgeOffset = 1;
        } else {
            edgeOffset = 0;
        }

        placePiece(whitePiece, edgeOffset, column);
        placePiece(blackPiece, SIDE - 1 - edgeOffset, column);
    }

    private void placePiece(ChessPiece pieceType, int row, int column) {
        board[row][column] = pieceType;
    }

    public ChessPiece getPieceAt(int row, int column) {
        return board[row][column];
    }
}
