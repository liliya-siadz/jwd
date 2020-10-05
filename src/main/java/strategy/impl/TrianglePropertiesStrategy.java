package strategy.impl;

import model.Figure;
import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;


public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {
    /*3 Simple Singleton not lazy realization
     */
    public static final TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();

    private double lengthAB;
    private double lengthAC;
    private double lengthBC;

    private TrianglePropertiesStrategy() {
    }

    private void setLengths(Figure figure) {
        Point[] points = figure.getPoints();
        lengthAB = LineUtil.calculateLength(points[0], points[1]);
        lengthAC = LineUtil.calculateLength(points[0], points[2]);
        lengthBC = LineUtil.calculateLength(points[1], points[2]);
    }

    @Override
    public double calculateArea(Figure figure) {
        double p = calculatePerimeter(figure) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAC) * (p - lengthBC));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        setLengths(figure);
        return lengthAB + lengthAC + lengthBC;
    }
}

