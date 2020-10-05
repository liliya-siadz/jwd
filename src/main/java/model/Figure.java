package model;

import strategy.FigurePropertiesStrategy;
import util.PointUtil;

public abstract class Figure {

    private static Integer id = 0;
    private final FigureType figureType;
    private final FigurePropertiesStrategy figurePropertiesStrategy;
    protected Point[] points;

    Figure(FigureType figureType,
           FigurePropertiesStrategy figurePropertiesStrategy) {

        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.figureType = figureType;
        Figure.id++;
    }

    public static Integer getId() {
        return id;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Point[] getPoints() {
        return points;
    }

    public double getPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(this);
    }

    public double getArea() {
        return figurePropertiesStrategy.calculateArea(this);
    }


    @Override
    public String toString() {
        return String.format("%s (%s)\n",
                getFigureType(), PointUtil.printCoordinates(points));
    }
}


