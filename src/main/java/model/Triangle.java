package model;


import strategy.impl.TrianglePropertiesStrategy;

import java.util.List;

public class Triangle extends Figure {

    Triangle(List<Point> figureConstituents) {
        super(FigureType.TRIANGLE, TrianglePropertiesStrategy.INSTANCE, figureConstituents);
    }

}
