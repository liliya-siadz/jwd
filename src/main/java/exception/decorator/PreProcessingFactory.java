package exception.decorator;

import exception.FigureException;
import factory.FigureFactory;
import model.Figure;
import model.FigureType;
import model.Point;
import service.FigurePreProcessor;
import service.impl.FigurePreProcessorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PreProcessingFactory extends FigureFactoryDecorator {
    /*
        PreProcessors has three states:ON/OFF/EXTRA(turbo state: 2 preprocessors works)
     */
    private static ProcessingStates state = ProcessingStates.ON;
    private static PreProcessingFactory instance;
    private final Map<String, FigurePreProcessor> figurePreProcessors;

    private PreProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
        figurePreProcessors = new HashMap<>();
        figurePreProcessors.put(FigurePreProcessorImpl.INSTANCE.name(), FigurePreProcessorImpl.INSTANCE);
        figurePreProcessors.put(FigurePreProcessorImpl.ALTERNATIVE_INSTANCE.name(), FigurePreProcessorImpl.ALTERNATIVE_INSTANCE);
    }

    public static ProcessingStates getState() {
        return state;
    }

    public static void setState(ProcessingStates state) {
        PreProcessingFactory.state = state;
    }

    public static PreProcessingFactory getInstance(FigureFactory figureFactory) {
        if ((instance == null)) {
            instance = new PreProcessingFactory(figureFactory);
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> figureConstituents) throws FigureException {
        Figure figure;
        switch (state) {
            case ON:
                figure =
                        figurePreProcessors.get(FigurePreProcessorImpl.INSTANCE.name()).process(figureType,
                                figureConstituents);
                break;
            case OFF:
                return super.createFigure(figureType, figureConstituents);
            case EXTRA:
                figure =
                        figurePreProcessors.get(FigurePreProcessorImpl.INSTANCE.name()).process(figureType,
                                figureConstituents);
                figure =
                        figurePreProcessors.get(FigurePreProcessorImpl.ALTERNATIVE_INSTANCE.name()).process(figure.getFigureType(),
                                figure.getFigureConstituents());
                break;
            default:
                throw new FigureException();
        }
        if (figure == null) {
            return super.createFigure(figureType, figureConstituents);
        }
        return figure;
    }
}
