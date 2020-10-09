package model;

public enum FigureType {
    TRIANGLE(3),
    LINE(2),
    SQUARE(4),
    TETRAGON(4),
    PENTAGON(5),
    HEXAGON(6);

    private final int figureConstituentsQuantity;

    FigureType(int figureConstituentsQuantity) {
        this.figureConstituentsQuantity = figureConstituentsQuantity;
    }

    public int getPointsQuantity() {
        return figureConstituentsQuantity;
    }
}
