package util;

import model.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class LineUtil {
    private LineUtil() {
    }

    public static double calculateLength(Point pointA, Point pointB) {
        int coordinateA1 = pointA.getCoordinateA();
        int coordinateA2 = pointB.getCoordinateA();
        int coordinateB1 = pointA.getCoordinateB();
        int coordinateB2 = pointB.getCoordinateB();
        return sqrt((pow((coordinateA1 - coordinateA2), 2) + pow((coordinateB1 - coordinateB2), 2)));
    }
}
