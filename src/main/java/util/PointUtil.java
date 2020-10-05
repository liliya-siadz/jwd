package util;

import model.Point;

public class PointUtil {

    private PointUtil() {

    }

    public static boolean calculateIsEqual(Point[] pointsA, Point[] pointsB) {
        int length1 = pointsA.length;
        int length2 = pointsB.length;
        if (length1 == length2) {
            boolean isEqual = true;
            boolean[] temp = new boolean[length1];
            for (int i = 0; i < length1; i++) {
                temp[i] = false;
            }
            for (int i = 0; i < length1; i++) {
                for (int j = 0; j < length1; j++) {
                    if (PointUtil.calculateIsEqual(pointsA[i], pointsB[j])) {
                        temp[i] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < length1; i++) {
                if (temp[i] == false) {
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        } else {
            return false;
        }
    }

    public static boolean calculateIsEqual(Point pointA, Point pointB) {
        int coordinateA1 = pointA.getCoordinateA();
        int coordinateA2 = pointB.getCoordinateA();
        int coordinateB1 = pointA.getCoordinateB();
        int coordinateB2 = pointB.getCoordinateB();
        return ((coordinateA1 == coordinateA2) & (coordinateB1 == coordinateB2));
    }

    public static String printCoordinates(Point... points) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            stringBuilder.append(points[i]);
            if (i < points.length - 1) {
                stringBuilder.append(",");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static boolean calculateIsPointsOnOneLine(Point pointA, Point pointB) {
        boolean temp1 = (pointA.getCoordinateA() == pointB.getCoordinateA());
        boolean temp2 = (pointA.getCoordinateB() == pointB.getCoordinateB());
        return temp1 | temp2;
    }

    public static int countMaxNumberOfPointsOnTheSameLine(Point[] points) {
        int numberOfPointsOnOneLine = 1;
        for (int i = 0; i < points.length - 1; i++) {
            if (calculateIsPointsOnOneLine(points[i], points[i + 1])) {
                numberOfPointsOnOneLine++;
            }
        }
        return numberOfPointsOnOneLine;
    }

    public static int[] getLengths(Point[] points) {
        return null;
    }
}
