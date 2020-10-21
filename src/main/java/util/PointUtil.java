package util;

import model.Point;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PointUtil {

    private PointUtil() {
    }

    public static boolean calculateIsEqual(List<Point> figureConstituentsA, List<Point> figureConstituentsB) {
        return figureConstituentsA.containsAll(figureConstituentsB);
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

    public static String printCoordinates(List<Point> figureConstituents) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < figureConstituents.size() - 1) {
            stringBuilder.append(figureConstituents.stream().map(point -> point + ",").collect(Collectors.toList()));
        }
        return String.valueOf(stringBuilder);
    }

    public static boolean calculateIsPointsOnOneLine(Point pointA, Point pointB) {
        return (pointA.getCoordinateA() == pointB.getCoordinateA()) | (pointA.getCoordinateB() == pointB.getCoordinateB());
    }

    public static int countMaxNumberOfPointsOnTheSameLine(List<Point> figureConstituents) {
        return new HashSet<Point>(figureConstituents).size() - figureConstituents.size() + 1;
    }
}
