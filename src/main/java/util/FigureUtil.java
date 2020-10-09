package util;

import exception.factory.FactoryException;
import model.FigureType;
import model.Point;

public class FigureUtil {
    private FigureUtil() {
    }


    public static boolean calculateIsExist(FigureType figureType, Point[] figureConstituents) throws FactoryException {
        if (getIsFigure(figureConstituents)) {
            switch (figureType) {
                case LINE:
                    return calculateIsLine(figureConstituents);
                case TRIANGLE:
                    return calculateIsTriangle(figureConstituents);
                case SQUARE:
                    return calculateIsSquare(figureConstituents);
                default:

                    throw new FactoryException();
            }
        }
        return false;

    }

    public static boolean calculateIsLine(Point[] figureConstituents) {
        return figureConstituents.length == FigureType.LINE.getPointsQuantity();
    }

    public static boolean calculateIsTriangle(Point[] figureConstituents) {
        if (figureConstituents.length == FigureType.TRIANGLE.getPointsQuantity()) {
            return PointUtil.countMaxNumberOfPointsOnTheSameLine(figureConstituents) == 2;
        }
        return false;
    }


    public static boolean calculateIsSquare(Point[] figureConstituents) {
        return (figureConstituents.length == FigureType.SQUARE.getPointsQuantity());
        //logics in process...
    }

    public static boolean getAreFiguresEquals(FigureType figureTypeA, Point[] figureConstituentsA,
                                              FigureType figureTypeB, Point[] figureConstituentsB) {
        if (figureTypeA == figureTypeB) {
            return PointUtil.calculateIsEqual(figureConstituentsA, figureConstituentsB);
        }
        return false;
    }

    public static boolean getIsFigure(Point[] figureConstituents) {
        int figureConstituentsQuantity = figureConstituents.length;
        if (figureConstituentsQuantity > 1) {
            int i = 0;
            do {
                if (PointUtil.calculateIsEqual(figureConstituents[i], figureConstituents[i + 1])) {
                    return false;
                }
                i++;
            } while (i < figureConstituentsQuantity - 1);
            return true;
        }
        return false;
    }
}
