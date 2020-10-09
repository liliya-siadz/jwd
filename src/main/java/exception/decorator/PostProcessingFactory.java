package exception.decorator;

import exception.FigureException;
import factory.FigureFactory;
import model.Figure;
import model.FigureType;
import model.Point;
import service.FigurePostProcessor;
import service.impl.FigurePostProcessorImpl;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private static PostProcessingFactory instance;
    private final FigurePostProcessor figurePostProcessor;

    private PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
        figurePostProcessor = FigurePostProcessorImpl.INSTANCE;
    }

    public static PostProcessingFactory getInstance(FigureFactory figureFactory) {
        if (instance == null) {
            instance = new PostProcessingFactory(figureFactory);
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return figurePostProcessor.process(super.createFigure(figureType, figureConstituents));
    }
}
