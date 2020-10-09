package util;

import model.Point;

public class PointUtil {

    private PointUtil() {
    }

    public static boolean calculateIsEqual(Point[] figureConstituentsA, Point[] figureConstituentsB) {
        int lengthA = figureConstituentsA.length;
        int length2 = figureConstituentsB.length;
        if (lengthA == length2) {
            int t = 0;
            for (int i = 0; i < lengthA; i++) {
                for (int j = 0; j < lengthA; j++) {
                    if (PointUtil.calculateIsEqual(figureConstituentsA[i], figureConstituentsB[j])) {
                        t++;
                    }
                }
            }
            return (t == lengthA);
        }
        return false;

    }

    public static boolean calculateIsEqual(Point pointA, Point pointB) {
        int coordinateA1 = pointA.getCoordinateA();
        int coordinateA2 = pointB.getCoordinateA();
        int coordinateB1 = pointA.getCoordinateB();
        int coordinateB2 = pointB.getCoordinateB();
        return ((coordinateA1 == coordinateA2) & (coordinateB1 == coordinateB2));
    }

    public static String printCoordinates(Point... figureConstituents) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < figureConstituents.length; i++) {
            stringBuilder.append(figureConstituents[i]);
            if (i < figureConstituents.length - 1) {
                stringBuilder.append(",");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static boolean calculateIsPointsOnOneLine(Point pointA, Point pointB) {
        return (pointA.getCoordinateA() == pointB.getCoordinateA()) | (pointA.getCoordinateB() == pointB.getCoordinateB());
    }

    public static int countMaxNumberOfPointsOnTheSameLine(Point[] figureConstituents) {
        int numberOfPointsOnOneLine = 1;
        for (int i = 0; i < figureConstituents.length - 1; i++) {
            if (calculateIsPointsOnOneLine(figureConstituents[i], figureConstituents[i + 1])) {
                numberOfPointsOnOneLine++;
            }
        }
        return numberOfPointsOnOneLine;
    }
}
