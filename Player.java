import enums.Color;

public class Player {
    private String name;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    // Getter for player's name
    public String getName() {
        return name;
    }

    // Getter for player's color
    public Color getColor() {
        return color;
    }
}

