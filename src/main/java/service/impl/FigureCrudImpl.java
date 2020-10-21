package service.impl;

import exception.FigureException;
import factory.ApplicationContext;
import model.Figure;
import model.FigureType;
import model.Point;
import model.SimpleFigureFactory;
import service.FigureCrud;

import java.util.ArrayList;
import java.util.List;

public class FigureCrudImpl implements FigureCrud {
    @Override
    public Figure Create(Figure figure) throws FigureException {
        return ApplicationContext.createFigure(figure.getFigureType(), figure.getFigureConstituents());
    }

    @Override
    public List<Figure> MultiCreate(Figure[] figures) throws FigureException {
        List<Figure> newFigures = new ArrayList<>();
        for (int i = 0; i < figures.length; i++) {
            newFigures.add(ApplicationContext.createFigure(figures[i].getFigureType(),
                    figures[i].getFigureConstituents()));
        }
        return newFigures;
    }

    @Override
    public boolean Delete(Figure figure) {
        return SimpleFigureFactory.figureStorehouse.deleteFromStoreHouse(figure);
    }

    @Override
    public boolean Update(Figure figure, Figure figureNew) {
        return SimpleFigureFactory.figureStorehouse.updateFigureInStorage(figure, figureNew);
    }

    @Override
    public Figure FindById(int id) {
        return SimpleFigureFactory.figureStorehouse.getFromStorage(id).get();
    }

    @Override
    public Figure Find(Figure figure) {
        return SimpleFigureFactory.figureStorehouse.getFromStorage(figure.getFigureType(),
                figure.getFigureConstituents());
    }

    @Override
    public Figure FindByCriteria(FigureType figureType, List<Point> figureConstituents) {
        return null;
    }
}
