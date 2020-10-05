package strategy;

import model.Figure;
import model.Point;
import util.FigureUtil;
import util.LineUtil;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {

    /*2 Not Lazy Singleton realization using ENUM
     */
    INSTANCE;

    private Point pointA;
    private Point pointB;

    public static boolean calculateIsExist(Point[] points) {
        return FigureUtil.getIsFigure(points);
    }

    private void setPoints(Figure figure) {
        Point[] points = figure.getPoints();
        pointA = points[0];
        pointB = points[1];
    }

    @Override
    public int calculateArea(Figure figure) {
        return 0;
    }

    @Override
    public int calculatePerimeter(Figure figure) {
        setPoints(figure);
        return LineUtil.calculateLength(pointA, pointB);
    }
}
