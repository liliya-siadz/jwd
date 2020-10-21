package service.impl;

import exception.FigureException;
import factory.ApplicationContext;
import model.Figure;
import model.SimpleFigureFactory;
import service.Criteria;
import service.FigureCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return SimpleFigureFactory.figureStorehouse.followStorage().get(id);
    }

    @Override
    public Figure Find(Figure figure) {
        return SimpleFigureFactory.figureStorehouse.followStorage().values().stream()
                .filter(figure::equals)
                .findFirst()
                .get()
                ;
    }

    @Override
    public Figure FindByCriteria(Criteria criteria) {
        Map<Integer, Figure> map = SimpleFigureFactory.figureStorehouse.followStorage();
        while (map.values().iterator().hasNext()) {
            Figure f = map.values().iterator().next();
            Criteria c = new Criteria.Builder(f.getFigureType(), f.getFigureConstituents()).build();
            if (criteria.equals(c)) {
                return f;
            }
        }
        return null;

    }
}
