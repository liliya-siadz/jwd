package strategy;

import model.Point;

import java.util.List;

public interface FigurePropertiesStrategy {

    double calculateArea(List<Point> figureConstituents);

    double calculatePerimeter(List<Point> figureConstituents);
}
