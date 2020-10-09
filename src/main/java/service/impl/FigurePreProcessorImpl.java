package service.impl;

import exception.FigureException;
import exception.figuretype.FigureNotExistException;
import model.Figure;
import model.FigureType;
import model.Point;
import model.SimpleFigureFactory;
import service.FigurePreProcessor;
import util.FigureUtil;

public enum FigurePreProcessorImpl implements FigurePreProcessor {
    INSTANCE;

    public Figure process(FigureType figureType, Point[] figureConstituents) throws FigureException {
        if (FigureUtil.calculateIsExist(figureType, figureConstituents)) {
            return SimpleFigureFactory.figureStorehouse.getFromStorage(figureType, figureConstituents);
        }
        throw new FigureNotExistException();
    }
}
