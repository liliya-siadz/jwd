package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;


public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {
    /*3 Simple Singleton not lazy realization
     */
    public static final TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();


    private TrianglePropertiesStrategy() {
    }

    @Override
    public double calculateArea(Point[] figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents[0], figureConstituents[1]);
        double lengthAC = LineUtil.calculateLength(figureConstituents[0], figureConstituents[2]);
        double lengthBC = LineUtil.calculateLength(figureConstituents[1], figureConstituents[2]);
        double p = calculatePerimeter(figureConstituents) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAC) * (p - lengthBC));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(Point[] figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents[0], figureConstituents[1]);
        double lengthAC = LineUtil.calculateLength(figureConstituents[0], figureConstituents[2]);
        double lengthBC = LineUtil.calculateLength(figureConstituents[1], figureConstituents[2]);
        return lengthAB + lengthAC + lengthBC;
    }
}

