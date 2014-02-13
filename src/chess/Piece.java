package chess;

import java.util.List;

public interface Piece {
    public List<Position> getLegalMoves(Position pos, Board board);
}
