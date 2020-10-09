package model;


import exception.storehouse.StorehouseHasNoPlace;
import util.FigureUtil;

public class FigureStorehouse {
    /* Singleton
     */

    private static final int STOREHOUSE_MAX_SIZE = 100;

    private static FigureStorehouse instance;
    private final FigurePlace[] storehouse;

    private FigureStorehouse() {
        storehouse = new FigurePlace[STOREHOUSE_MAX_SIZE];
    }

    public static FigureStorehouse getInstance() {
        if (instance == null) {
            instance = new FigureStorehouse();
        }
        return instance;
    }

    private boolean getIsAnyFreePlace() {
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace == null) {
                return true;
            }
        }
        return false;
    }

    public void printAllItems() {
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace != null) {
                System.out.println(figurePlace.getItem());
            }
        }
    }

    private int getFreePlaceIndex() throws StorehouseHasNoPlace {
        if (getIsAnyFreePlace()) {
            for (int i = 0; i < storehouse.length; i++) {
                if (storehouse[i] == null) {
                    return i;
                }
            }
        }
        throw new StorehouseHasNoPlace();
    }

    private Figure getFromStorage(int id) {
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace.getId() == id) {
                return figurePlace.getItem();
            }
        }
        return null;
    }

    private boolean getIsStoreHouseEmpty() {
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace != null) {
                return false;
            }
        }
        return true;
    }

    private FigurePlace findInStorage(FigureType figureType, Point[] figureConstituents) {
        if (!getIsStoreHouseEmpty()) {
            for (FigurePlace figurePlace : storehouse) {
                if (figurePlace != null) {
                    if (FigureUtil.getAreFiguresEquals(
                            figurePlace.getItem().getFigureType(),
                            figurePlace.getItem().getPoints(),
                            figureType, figureConstituents)) {
                        return figurePlace;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public Figure getFromStorage(FigureType figureType, Point[] figureConstituents) {
        FigurePlace figurePlace = findInStorage(figureType, figureConstituents);
        if (figurePlace != null) {
            return getFromStorage(figurePlace.getId());
        }
        return null;
    }

    public FigurePlace setId(Figure figure) {
        return new FigurePlace(figure, Figure.getId());
    }

    public Figure putToStorage(FigurePlace item) throws StorehouseHasNoPlace {
        int t = getFreePlaceIndex();
        storehouse[t] = item;
        storehouse[t].setId(Figure.getId());
        return storehouse[t].getItem();
    }

    public int getNumberOfOccupiedFigurePlaces() {
        int i = 0;
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace != null) {
                i++;
            }
        }
        return i;
    }

}
