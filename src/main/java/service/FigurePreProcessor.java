package service;

import exception.FigureException;
import exception.FigureNotExistException;
import model.Figure;
import model.FigureFactory;
import model.FigureType;
import model.Point;
import util.FigureUtil;

public interface FigurePreProcessor {

    default Figure process(FigureType figureType, Point[] points)
            throws FigureException {
        if (FigureUtil.getIsFigure(points)) {
            if (FigureUtil.calculateIsExist(figureType, points)) {
                return FigureFactory.figureStorehouse.
                        getFromStorage(figureType, points);
            } else {
                throw new FigureNotExistException();
            }
        } else {
            throw new FigureException();
        }
    }
}
