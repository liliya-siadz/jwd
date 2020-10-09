package exception.decorator;

import exception.FigureException;
import factory.FigureFactory;
import model.Figure;
import model.FigureType;
import model.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    private final FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(figureType, figureConstituents);
    }
}
