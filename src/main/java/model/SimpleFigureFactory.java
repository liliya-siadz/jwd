package model;

import exception.FigureException;
import exception.factory.FactoryException;
import factory.FigureFactory;

import java.util.List;

public class SimpleFigureFactory implements FigureFactory {
    public static FigureStorehouse figureStorehouse;
    private static SimpleFigureFactory instance;


    private SimpleFigureFactory() {
        figureStorehouse = FigureStorehouse.getInstance();
    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFigureFactory();
        }
        return instance;
    }

    public Figure createFigure(FigureType figureType, List<Point> figureConstituents) throws FigureException {
        switch (figureType) {
            case LINE:
                return new Line(figureConstituents);
            case TRIANGLE:
                return new Triangle(figureConstituents);
            case SQUARE:
                return new Square(figureConstituents);
            default:
                throw new FactoryException();
        }
    }
}

