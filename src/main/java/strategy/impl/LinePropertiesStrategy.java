package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {

    /*2 Not Lazy Singleton realization using ENUM
     */
    INSTANCE;

    @Override
    public double calculateArea(Point[] figureConstituents) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Point[] figureConstituents) {
        return LineUtil.calculateLength(figureConstituents[0], figureConstituents[1]);
    }
}
