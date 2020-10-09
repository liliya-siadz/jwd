package model;

import strategy.FigurePropertiesStrategy;
import util.PointUtil;

public abstract class Figure {

    private static Integer id = 0;
    private final FigureType figureType;
    private final FigurePropertiesStrategy figurePropertiesStrategy;
    private final Point[] figureConstituents;

    Figure(FigureType figureType,
           FigurePropertiesStrategy figurePropertiesStrategy, Point[] figureConstituents) {

        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.figureType = figureType;
        this.figureConstituents = figureConstituents;
        gainId();
    }

    public static Integer getId() {
        return id;
    }

    private void gainId() {
        Figure.id++;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Point[] getPoints() {
        return figureConstituents;
    }

    public double getPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(figureConstituents);
    }

    public double getArea() {
        return figurePropertiesStrategy.calculateArea(figureConstituents);
    }


    @Override
    public String toString() {
        return String.format("%s (%s)\n",
                getFigureType(), PointUtil.printCoordinates(figureConstituents));
    }
}


