package factory;

import exception.FigureException;
import exception.decorator.PostProcessingFactory;
import exception.decorator.PreProcessingFactory;
import model.Figure;
import model.FigureType;
import model.Point;
import model.SimpleFigureFactory;

import java.util.List;

public class ApplicationContext {
    private ApplicationContext() {
    }

    public static Figure createFigure(FigureType figureType, List<Point> figureConstituents) throws FigureException {
        return PostProcessingFactory.
                getInstance(PreProcessingFactory.getInstance(SimpleFigureFactory.getInstance()))
                .createFigure(figureType, figureConstituents);
    }
}

