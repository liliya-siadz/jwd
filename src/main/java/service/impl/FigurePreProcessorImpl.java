package service.impl;

import model.FigureType;
import model.Point;
import service.FigurePreProcessor;
import strategy.LinePropertiesStrategy;
import strategy.SquarePropertiesStrategy;
import strategy.TrianglePropertiesStrategy;


public class FigurePreProcessorImpl implements FigurePreProcessor {
    @Override
    public boolean calculateIsExist(FigureType figureType, Point[] points) {
        switch (figureType) {
            case LINE:
                return LinePropertiesStrategy.calculateIsExist(points);
            case SQUARE:
                return SquarePropertiesStrategy.calculateIsExist(points);
            case TRIANGLE:
                return TrianglePropertiesStrategy.calculateIsExist(points);
            default:
                return false;
        }
    }

}
