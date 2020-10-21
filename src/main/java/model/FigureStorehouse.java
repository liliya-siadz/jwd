package model;

import exception.FigureException;
import exception.storehouse.StorehouseHasNoPlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FigureStorehouse {
    /* Singleton
     */

    private static final int STOREHOUSE_MAX_SIZE = 100;
    private static FigureStorehouse instance;
    private final Map<Integer, Figure> storehouse;
    Logger logger = LoggerFactory.getLogger(FigureStorehouse.class);

    private FigureStorehouse() {
        storehouse = new HashMap<>();
    }

    public static FigureStorehouse getInstance() {
        if (instance == null) {
            instance = new FigureStorehouse();
        }
        return instance;
    }

    public static Optional<Integer> getFigureId(Map<Integer, Figure> storehouse, Figure figure) {
        return storehouse.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), figure))
                .map(Map.Entry::getKey).findFirst();
    }

    public Optional<Figure> getFromStorage(int id) {
        return Optional.ofNullable(storehouse.get(id));

    }

    public boolean updateFigureInStorage(Figure figure, Figure figureNew) {
        Optional<Figure> opt = findInStorage(figure.getFigureType(), figure.getFigureConstituents());
        if (opt.isPresent()) {
            Optional<Integer> id = getFigureId(storehouse, figure);
            return storehouse.replace(id.get(), figure, figureNew);
        }
        return false;
    }

    public Figure getFromStorage(FigureType figureType, List<Point> figureConstituents) {
        return findInStorage(figureType, figureConstituents).get();
    }

    private Optional<Figure> findInStorage(FigureType figureType, List<Point> figureConstituents) {
        return storehouse.values().stream().filter(figure -> figureType.equals(figure.getFigureType())).
                filter(figure -> figureConstituents.equals(figure.getFigureConstituents())).findFirst();

    }

    public Optional<Figure> setId(Figure figure) {
        return Optional.ofNullable(storehouse.put(Figure.getId(), figure));
    }

    public Figure putToStorage(Figure figure) throws FigureException {
        if (followSize()) {
            return setId(figure).orElseThrow(FigureException::new);
        }
        throw new StorehouseHasNoPlace();
    }

    public boolean deleteFromStoreHouse(Figure figure) {
        Optional<Figure> opt = findInStorage(figure.getFigureType(), figure.getFigureConstituents());
        if (opt.isPresent()) {
            return storehouse.entrySet().remove(opt.get());
        }
        return false;
    }

    private boolean followSize() {
        return storehouse.size() == STOREHOUSE_MAX_SIZE;
    }

}