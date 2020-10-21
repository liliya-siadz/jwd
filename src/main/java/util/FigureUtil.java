package util;

import exception.factory.FactoryException;
import exception.figuretype.FigureNotExistException;
import model.Figure;
import model.FigureType;
import model.Point;

import java.util.List;

public class FigureUtil {
    private FigureUtil() {
    }

    public static boolean calculateIsExist(FigureType figureType, List<Point> figureConstituents) throws FigureNotExistException, FactoryException {
        if ((getIsNotNull(figureType, figureConstituents)) && (getIsFigure(figureConstituents))) {
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

    public static boolean calculateIsLine(List<Point> figureConstituents) {
        return figureConstituents.size() == FigureType.LINE.getPointsQuantity();
    }

    public static boolean calculateIsTriangle(List<Point> figureConstituents) {
        return (figureConstituents.size() == FigureType.TRIANGLE.getPointsQuantity()) &&
                PointUtil.countMaxNumberOfPointsOnTheSameLine(figureConstituents) == 2;
    }


    public static boolean calculateIsSquare(List<Point> figureConstituents) {
        return (figureConstituents.size() == FigureType.SQUARE.getPointsQuantity());
        //logics in process...
    }

    public static boolean getAreFiguresEquals(FigureType figureTypeA, List<Point> figureConstituentsA,
                                              FigureType figureTypeB, List<Point> figureConstituentsB) {
        return figureTypeA == figureTypeB && PointUtil.calculateIsEqual(figureConstituentsA, figureConstituentsB);
    }

    public static boolean getAreFiguresEquals(Figure figureA, Figure figureB) {
        return figureA.getFigureType() == figureB.getFigureType() && PointUtil.calculateIsEqual(figureA.getFigureConstituents(),
                figureB.getFigureConstituents());
    }

    public static boolean getAreFiguresEquals(Figure figureA, FigureType figureTypeB, List<Point> figureConstituentsB) {
        return figureA.getFigureType() == figureTypeB && PointUtil.calculateIsEqual(figureA.getFigureConstituents(),
                figureConstituentsB);
    }


    public static boolean getIsFigure(List<Point> figureConstituents) {
        return figureConstituents.size() > 1 && (figureConstituents.stream().distinct().count()) == (figureConstituents.size());
    }

    public static boolean getIsNotNull(FigureType figureType, List<Point> figureConstituents) throws FigureNotExistException {
        if (figureType != null && figureConstituents != null) {
            return true;
        }
        throw new FigureNotExistException();

    }
}
