package service;

import exception.FigureException;
import model.Figure;

import java.util.List;

public interface FigureCrud {
    Figure Create(Figure figure) throws FigureException;

    List<Figure> MultiCreate(Figure[] figures) throws FigureException;

    boolean Delete(Figure figure);

    boolean Update(Figure figure, Figure figureNew);

    Figure FindById(int id);

    Figure Find(Figure figure);

    Figure FindByCriteria(Criteria criteria);

}
