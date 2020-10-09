package model;


import strategy.impl.TrianglePropertiesStrategy;

public class Triangle extends Figure {


    Triangle(Point[] figureConstituents) {
        super(FigureType.TRIANGLE, TrianglePropertiesStrategy.INSTANCE, figureConstituents);
    }

}
