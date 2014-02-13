package chess;

public enum ChessPiece {
    WHITE_PAWN(PieceColor.WHITE, PieceType.PAWN),
    WHITE_ROOK(PieceColor.WHITE, PieceType.ROOK),
    WHITE_KNIGHT(PieceColor.WHITE, PieceType.KNIGHT),
    WHITE_BISHOP(PieceColor.WHITE, PieceType.BISHOP),
    WHITE_KING(PieceColor.WHITE, PieceType.KING),
    WHITE_QUEEN(PieceColor.WHITE, PieceType.QUEEN),

    BLACK_PAWN(PieceColor.BLACK, PieceType.PAWN),
    BLACK_ROOK(PieceColor.BLACK, PieceType.ROOK),
    BLACK_KNIGHT(PieceColor.BLACK, PieceType.KNIGHT),
    BLACK_BISHOP(PieceColor.BLACK, PieceType.BISHOP),
    BLACK_KING(PieceColor.BLACK, PieceType.KING),
    BLACK_QUEEN(PieceColor.BLACK, PieceType.QUEEN);

    public final PieceColor color;
    public final PieceType type;

    ChessPiece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public static ChessPiece from(PieceColor color, PieceType type) {
        for (ChessPiece chessPiece : values()) {
            if (chessPiece.type == type && chessPiece.color == color) {
                return chessPiece;
            }
        }
        throw new IllegalArgumentException(String.format("There is no chess piece of type and color: [%s, %s]", type, color));
    }
}
