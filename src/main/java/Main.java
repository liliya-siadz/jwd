import exception.FigureException;
import model.Figure;
import model.FigureFactory;
import model.FigureType;
import model.Point;

public class Main {

    public static void main(String[] args) throws FigureException {
        Point point = new Point(1, 2);
        Point point1 = new Point(5, 2);
        Point point2 = new Point(3, 7);
        Point[] points = new Point[]{point,point1,point2};

        FigureFactory factory = new FigureFactory();
        Figure figure = factory.createFigure(FigureType.TRIANGLE, points);

    }
}
