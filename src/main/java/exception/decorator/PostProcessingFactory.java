package exception.decorator;

import exception.FigureException;
import factory.FigureFactory;
import model.Figure;
import model.FigureType;
import model.Point;
import service.FigurePostProcessor;
import service.impl.FigurePostProcessorImpl;

import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {
    /*
        PostProcessor has two states:ON/OFF
     */
    private static PostProcessingFactory instance;
    private static ProcessingStates state = ProcessingStates.OFF;
    private final FigurePostProcessor figurePostProcessor;

    private PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
        figurePostProcessor = FigurePostProcessorImpl.INSTANCE;
    }

    public static ProcessingStates getState() {
        return state;
    }

    public static void setState(ProcessingStates state) {
        PostProcessingFactory.state = state;
    }

    public static PostProcessingFactory getInstance(FigureFactory figureFactory) {
        if (instance == null) {
            instance = new PostProcessingFactory(figureFactory);
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> figureConstituents) throws FigureException {
        switch (state) {
            case ON:
                return figurePostProcessor.process(super.createFigure(figureType, figureConstituents));
            case OFF:
                return super.createFigure(figureType, figureConstituents);
            default:
                throw new FigureException();
        }
    }
}
