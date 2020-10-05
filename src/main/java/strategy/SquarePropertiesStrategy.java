package strategy;

import model.Figure;
import model.Point;
import util.FigureUtil;
import util.LineUtil;
import util.PointUtil;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    /*1 Lazy Singleton realization
     */
    private static SquarePropertiesStrategy instance;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private int lengthAB;
    private int lengthAD;
    private int lengthBC;
    private int lengthCD;
    private SquarePropertiesStrategy() {
    }

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    public static boolean calculateIsExist(Point[] points) {
        if (FigureUtil.getIsFigure(points)) {
            return PointUtil.countMaxNumberOfPointsOnTheSameLine(points) == 2;
        } else {
            return false;
        }
    }

    private void setPoints(Figure figure) {
        Point[] points = figure.getPoints();
        pointA = points[0];
        pointB = points[1];
        pointC = points[2];
        pointD = points[3];
    }

    private void setLengths() {
        lengthAB = LineUtil.calculateLength(pointA, pointB);
        lengthAD = LineUtil.calculateLength(pointA, pointD);
        lengthBC = LineUtil.calculateLength(pointB, pointC);
        lengthCD = LineUtil.calculateLength(pointC, pointD);
    }

    @Override
    public int calculateArea(Figure figure) {
        int p = calculatePerimeter(figure) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAD) * (p - lengthBC) * (p - lengthCD));
        return (int) area;
    }

    @Override
    public int calculatePerimeter(Figure figure) {
        setPoints(figure);
        setLengths();
        return lengthAB + lengthAD + lengthBC + lengthCD;
    }
}
