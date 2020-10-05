package strategy;

import model.Figure;
import model.Point;
import util.LineUtil;


public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {
    /*3 Simple Singleton not lazy realization
     */
    public static final TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private double lengthAB;
    private double lengthAC;
    private double lengthBC;

    private TrianglePropertiesStrategy() {
    }

    private void setPoints(Figure figure) {
        Point[] points = figure.getPoints();
        pointA = points[0];
        pointB = points[1];
        pointC = points[2];
    }

    private void setLengths() {
        lengthAB = LineUtil.calculateLength(pointA, pointB);
        lengthAC = LineUtil.calculateLength(pointA, pointC);
        lengthBC = LineUtil.calculateLength(pointB, pointC);
    }

    @Override
    public double calculateArea(Figure figure) {
        double p = calculatePerimeter(figure) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAC) * (p - lengthBC));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        setPoints(figure);
        setLengths();
        return lengthAB + lengthAC + lengthBC;
    }
}

