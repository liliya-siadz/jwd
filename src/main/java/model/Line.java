package model;

import strategy.impl.LinePropertiesStrategy;

import java.util.List;

public class Line extends Figure {
    Line(List<Point> figureConstituents) {
        super(FigureType.LINE, LinePropertiesStrategy.INSTANCE, figureConstituents);
    }

}
