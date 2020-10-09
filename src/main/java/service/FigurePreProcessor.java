package service;

import exception.FigureException;
import model.Figure;
import model.FigureType;
import model.Point;

public interface FigurePreProcessor {

    Figure process(FigureType figureType, Point[] figureConstituents) throws FigureException;
}
