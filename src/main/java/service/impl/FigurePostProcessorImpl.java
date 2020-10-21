package service.impl;

import exception.FigureException;
import model.Figure;
import model.SimpleFigureFactory;
import service.FigurePostProcessor;

public enum
FigurePostProcessorImpl implements FigurePostProcessor {
    INSTANCE;

    public Figure process(Figure figure) throws FigureException {
        return SimpleFigureFactory.figureStorehouse.putToStorage(SimpleFigureFactory.figureStorehouse.setId(figure).get());
    }
}
