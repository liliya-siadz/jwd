package model;


import exception.FigureException;
import util.FigureUtil;

public class FigureStorehouse {


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
        boolean isAnyFreePlace = false;
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace == null) {
                isAnyFreePlace = true;
                break;
            }
        }
        return isAnyFreePlace;
    }

    private int getFreePlaceIndex() {
        int freePlaceIndex = 0;
        for (int i = 0; i < storehouse.length; i++) {
            if (storehouse[i] == null) {
                freePlaceIndex = i;
                break;
            }
        }
        return freePlaceIndex;
    }

    private Figure getFromStorage(int id) {
        for (FigurePlace figurePlace : storehouse) {
            if (figurePlace.getId() == id) {
                return figurePlace.getItem();
            }
        }
        return null;
    }

    private boolean checkIsStorehouseEmpty(){
        for (FigurePlace figurePlace : storehouse) {
            if(figurePlace!=null){
                return false;
            }
        }return true;
    }
    public Figure getFromStorage(FigureType figureType, Point[] points) {
        if(!checkIsStorehouseEmpty()){
            for (FigurePlace figurePlace : storehouse) {
                FigureType figurePlaceFigureType = figurePlace.getItem().getFigureType();
                Point[] figurePlacePoints = figurePlace.getItem().getPoints();
                int figurePlaceId = figurePlace.getId();
                if (FigureUtil.getAreFiguresEquals(figurePlaceFigureType, figurePlacePoints, figureType, points)) {
                    return getFromStorage(figurePlaceId);
                }
            }
            return null;
        }else {
            return null;
        }

    }

    public FigurePlace setId(Figure figure) {
        return new FigurePlace(figure, Figure.getId());
    }

    public Figure putToStorage(FigurePlace item) throws FigureException {
        if (getIsAnyFreePlace()) {
            storehouse[getFreePlaceIndex()] = item;
            return item.getItem();
        }else {
            throw new FigureException();
        }
    }
}
