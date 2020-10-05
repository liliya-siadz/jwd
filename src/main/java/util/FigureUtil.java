package util;

import model.Figure;
import model.FigureType;
import model.Point;

public class FigureUtil {

    public static boolean calculateIsExist(FigureType figureType, Point[] points){
        switch (figureType){
            case LINE:
                return calculateIsLine(points);
            case TRIANGLE:
                return calculateIsTriangle(points);
            case SQUARE:
                return calculateIsSquare(points);
            default:
                return false;
        }
    }

    public static boolean calculateIsLine(Point[] points) {
        if(points.length == FigureType.LINE.getPointsQuantity()){
            return FigureUtil.getIsFigure(points);
        }else {
            return false;
        }

    }

    public static boolean calculateIsTriangle(Point[] points) {
        if(points.length == FigureType.TRIANGLE.getPointsQuantity()){
            if (FigureUtil.getIsFigure(points)) {
                return PointUtil.countMaxNumberOfPointsOnTheSameLine(points) == 2;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


    public static boolean calculateIsSquare(Point[] points) {
        if(points.length == FigureType.SQUARE.getPointsQuantity()){
            if (FigureUtil.getIsFigure(points)) {
                //проверки
                return false;
            } else {
                return false;
            }
        }else {
            return false;
        }

    }

    public static boolean getAreFiguresEquals(FigureType figureTypeA, Point[] pointsA,
                                              FigureType figureTypeB, Point[] pointsB) {
        if (figureTypeA == figureTypeB) {
            return PointUtil.calculateIsEqual(pointsA, pointsB);
        }
        return false;
    }

    public static boolean getAreFiguresEquals(Figure figureA, Figure figureB) {
        if (figureA.getFigureType() == figureB.getFigureType()) {
            Point[] pointsA = figureA.getPoints();
            Point[] pointsB = figureB.getPoints();
            return PointUtil.calculateIsEqual(pointsA, pointsB);
        }
        return false;
    }

    public static boolean getIsFigure(Point[] points) {
        int pointsQuantity = points.length;
        if (pointsQuantity > 1) {
            for (int i = 0; i < pointsQuantity - 1; i++) {
                if (PointUtil.calculateIsEqual(points[i], points[i + 1])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
