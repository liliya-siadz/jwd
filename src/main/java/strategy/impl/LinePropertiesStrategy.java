package strategy.impl;

import model.Point;
import strategy.FigurePropertiesStrategy;
import util.LineUtil;

import java.util.List;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {

    /* 2 Not Lazy Singleton realization using ENUM */
    INSTANCE;

    @Override
    public double calculateArea(List<Point> figureConstituents) {
        return 0;
    }

    @Override
    public double calculatePerimeter(List<Point> figureConstituents) {
        return LineUtil.calculateLength(figureConstituents.get(0), figureConstituents.get(1));
    }
}
