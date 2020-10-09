package strategy;

import model.Point;

public interface FigurePropertiesStrategy {

    double calculateArea(Point[] figureConstituents);

    double calculatePerimeter(Point[] figureConstituents);
}
