package service;

import exception.FigureException;
import model.Figure;
import model.FigureFactory;

public interface FigurePostProcessor {

    default Figure process(Figure figure) throws FigureException {
        return FigureFactory.figureStorehouse.putToStorage(FigureFactory.figureStorehouse.setId(figure));
    }
}
