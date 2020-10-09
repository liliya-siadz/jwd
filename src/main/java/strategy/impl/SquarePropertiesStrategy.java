package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    /*1 Lazy Singleton realization
     */
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
    public double calculateArea(Point[] figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents[0], figureConstituents[1]);
        double lengthAD = LineUtil.calculateLength(figureConstituents[0], figureConstituents[3]);
        double lengthBC = LineUtil.calculateLength(figureConstituents[1], figureConstituents[2]);
        double lengthCD = LineUtil.calculateLength(figureConstituents[2], figureConstituents[3]);
        double p = calculatePerimeter(figureConstituents) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAD) * (p - lengthBC) * (p - lengthCD));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(Point[] figureConstituents) {
        double lengthAB = LineUtil.calculateLength(figureConstituents[0], figureConstituents[1]);
        double lengthAD = LineUtil.calculateLength(figureConstituents[0], figureConstituents[3]);
        double lengthBC = LineUtil.calculateLength(figureConstituents[1], figureConstituents[2]);
        double lengthCD = LineUtil.calculateLength(figureConstituents[2], figureConstituents[3]);
        return lengthAB + lengthAD + lengthBC + lengthCD;
    }
}
