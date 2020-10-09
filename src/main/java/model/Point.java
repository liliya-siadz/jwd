package model;

public class Point {
    private final int coordinateA;
    private final int coordinateB;

    public Point(int coordinateA, int coordinateB) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
    }

    public int getCoordinateA() {
        return coordinateA;
    }

    public int getCoordinateB() {
        return coordinateB;
    }

    @Override
    public String toString() {
        return String.format("(%o, %o)", coordinateA, coordinateB);
    }
}
