import exception.FigureException;
import model.Figure;
import model.FigureFactory;
import model.FigureType;
import model.Point;

public class Main {

    public static void main(String[] args) throws FigureException {
        Point point = new Point(2, 2);
        Point point1 = new Point(0, 2);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(2, 0);
        Point[] points = new Point[]{point, point1, point2, point3};
        Point[] points1 = new Point[]{point, point1};

        FigureFactory factory = new FigureFactory();
        Figure figure = factory.createFigure(FigureType.SQUARE, points);
        Figure figure2 = factory.createFigure(FigureType.SQUARE, points);
        Figure figure4 = factory.createFigure(FigureType.SQUARE, points);
        Figure figure3 = factory.createFigure(FigureType.LINE, points1);
        Figure ffigure3 = factory.createFigure(FigureType.LINE, points1);
        System.out.println(Figure.getId());
        System.out.println(factory.countProducedFigures());
    }
}
