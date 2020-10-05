package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point {
    static Logger logger = LoggerFactory.getLogger(Point.class);
    private final int coordinateA;
    private final int coordinateB;

    public Point(int coordinateA, int coordinateB) {
        logger.debug("Point doesn't extend class Figure");
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
