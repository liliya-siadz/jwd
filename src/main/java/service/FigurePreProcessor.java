package service;

import exception.FigureException;
import model.Figure;
import model.FigureType;
import model.Point;

import java.util.List;

public interface FigurePreProcessor {

    Figure process(FigureType figureType, List<Point> figureConstituents) throws FigureException;
}
