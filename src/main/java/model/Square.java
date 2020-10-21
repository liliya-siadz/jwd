package model;

import strategy.impl.SquarePropertiesStrategy;

import java.util.List;

public class Square extends Figure {

    Square(List<Point> figureConstituents) {
        super(FigureType.SQUARE, SquarePropertiesStrategy.getInstance(), figureConstituents);
    }

}
