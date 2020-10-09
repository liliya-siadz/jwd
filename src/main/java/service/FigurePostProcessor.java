package service;

import exception.FigureException;
import model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
