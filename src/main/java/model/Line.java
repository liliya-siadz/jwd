package model;

import strategy.impl.LinePropertiesStrategy;

public class Line extends Figure {
    Line(Point[] figureConstituents) {
        super(FigureType.LINE, LinePropertiesStrategy.INSTANCE, figureConstituents);
    }

}
