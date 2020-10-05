package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strategy.SquarePropertiesStrategy;

public class Square extends Figure {
    static Logger logger = LoggerFactory.getLogger(Square.class);

    Square(Point[] points) {
        super(FigureType.SQUARE, SquarePropertiesStrategy.getInstance());
        this.points = points;
    }

}
