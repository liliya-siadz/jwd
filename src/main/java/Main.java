import exception.FigureException;
import factory.ApplicationContext;
import model.Figure;
import model.FigureType;
import model.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FigureException {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 3));
        Figure figure = ApplicationContext.createFigure(FigureType.LINE, points);
        System.out.println(figure);
    }
}
