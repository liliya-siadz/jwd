package factory;

import exception.FigureException;
import model.Figure;
import model.FigureType;
import model.Point;

import java.util.List;

public interface FigureFactory {
    Figure createFigure(FigureType figureType, List<Point> figureConstituents) throws FigureException;
}
