package model;

import strategy.FigurePropertiesStrategy;
import util.PointUtil;

import java.util.List;

public abstract class Figure {

    private static Integer id = 0;
    private final FigureType figureType;
    private final FigurePropertiesStrategy figurePropertiesStrategy;
    private final List<Point> figureConstituents;

    Figure(FigureType figureType,
           FigurePropertiesStrategy figurePropertiesStrategy, List<Point> figureConstituents) {

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

    public List<Point> getFigureConstituents() {
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


