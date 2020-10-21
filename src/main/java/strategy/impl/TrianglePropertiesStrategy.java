package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;

import java.util.List;


public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {

    /* 3 Simple Singleton not lazy realization */
    public static final TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();

    private TrianglePropertiesStrategy() {
    }

    @Override
    public double calculateArea(List<Point> figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(1));
        double lengthAC = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(2));
        double lengthBC = LineUtil.calculateLength(figureConstituents.get(1), figureConstituents.get(2));
        double p = calculatePerimeter(figureConstituents) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAC) * (p - lengthBC));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(List<Point> figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(1));
        double lengthAC = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(2));
        double lengthBC = LineUtil.calculateLength(figureConstituents.get(1), figureConstituents.get(2));
        return lengthAB + lengthAC + lengthBC;
    }
}

