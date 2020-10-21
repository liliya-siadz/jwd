package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return coordinateA == point.coordinateA &&
                coordinateB == point.coordinateB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateA, coordinateB);
    }
}
