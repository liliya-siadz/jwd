package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;

import java.util.List;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    /* 1 Lazy Singleton realization */
    private static SquarePropertiesStrategy instance;

    private SquarePropertiesStrategy() {
    }

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculateArea(List<Point> figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(1));
        double lengthAD = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(3));
        double lengthBC = LineUtil.calculateLength(figureConstituents.get(1), figureConstituents.get(2));
        double lengthCD = LineUtil.calculateLength(figureConstituents.get(2), figureConstituents.get(3));
        double p = calculatePerimeter(figureConstituents) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAD) * (p - lengthBC) * (p - lengthCD));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(List<Point> figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(1));
        double lengthAD = LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(3));
        double lengthBC = LineUtil.calculateLength(figureConstituents.get(1), figureConstituents.get(2));
        double lengthCD = LineUtil.calculateLength(figureConstituents.get(2), figureConstituents.get(3));
        return lengthAB + lengthAD + lengthBC + lengthCD;
    }
}
