package model;

import strategy.impl.SquarePropertiesStrategy;

public class Square extends Figure {


    Square(Point[] figureConstituents) {
        super(FigureType.SQUARE, SquarePropertiesStrategy.getInstance(), figureConstituents);
    }

}
