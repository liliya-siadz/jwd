package factory;

import exception.FigureException;
import model.Figure;
import model.FigureType;
import model.Point;

public interface FigureFactory {
    Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException;
}
