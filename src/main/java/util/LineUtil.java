package util;

import model.Line;
import model.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class LineUtil {

    public static int calculateLength(Line line) {
        Point[] points = line.getPoints();
        int a1 = points[0].getCoordinateA();
        int a2 = points[1].getCoordinateA();
        int b1 = points[0].getCoordinateB();
        int b2 = points[1].getCoordinateB();
        int length = (int) sqrt((pow((a1 - a2), 2) + pow((b1 - b2), 2)));
        return length;
    }

    public static int calculateLength(Point pointA, Point pointB) {
        int a1 = pointA.getCoordinateA();
        int a2 = pointB.getCoordinateA();
        int b1 = pointA.getCoordinateB();
        int b2 = pointB.getCoordinateB();
        int length = (int) sqrt((pow((a1 - a2), 2) + pow((b1 - b2), 2)));
        return length;
    }

}
