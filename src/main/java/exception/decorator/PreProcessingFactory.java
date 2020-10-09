package exception.decorator;

import exception.FigureException;
import factory.FigureFactory;
import model.Figure;
import model.FigureType;
import model.Point;
import service.FigurePreProcessor;
import service.impl.FigurePreProcessorImpl;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private static PreProcessingFactory instance;
    /*Singleton

     */
    private final FigurePreProcessor figurePreProcessor;

    private PreProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
        this.figurePreProcessor = FigurePreProcessorImpl.INSTANCE;
    }

    public static PreProcessingFactory getInstance(FigureFactory figureFactory) {
        if (instance == null) {
            instance = new PreProcessingFactory(figureFactory);
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure figure = figurePreProcessor.process(figureType, figureConstituents);
        if (figure == null) {
            return super.createFigure(figureType, figureConstituents);
        }
        return figure;
    }
}
