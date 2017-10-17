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

    private void placePiece(ChessPiece piece, int row, int column) {
        board[row][column] = piece;
    }

    private void placePiece(ChessPiece piece, Position position) {
        placePiece(piece, position.getRow(), position.getColumn());
    }

    public boolean hasPieceAt(Position position) {
        return getPieceAt(position) != null;
    }

    public ChessPiece getPieceAt(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    private ChessPiece removePiece(Position from) {
        final ChessPiece piece = board[from.getRow()][from.getColumn()];
        board[from.getRow()][from.getColumn()] = null;
        return piece;
    }

    public void movePiece(Position from, Position to) {
        ChessPiece piece = removePiece(from);
        placePiece(piece, to);
    }
}
