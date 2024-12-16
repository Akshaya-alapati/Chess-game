import enums.Color;

public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    // Abstract method to be implemented by each piece for their specific move validation
    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Board board);
}
