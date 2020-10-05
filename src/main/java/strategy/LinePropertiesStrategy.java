package strategy;

import model.Figure;
import model.Point;
import util.LineUtil;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {

    /*2 Not Lazy Singleton realization using ENUM
     */
    INSTANCE;

    @Override
    public double calculateArea(Figure figure) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        Point[] points = figure.getPoints();
        return LineUtil.calculateLength(points[0], points[1]);
    }
}
