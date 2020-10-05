import exception.FigureException;
import model.Figure;
import model.FigureFactory;
import model.FigureType;
import model.Point;

public class Main {

    public static void main(String[] args) throws FigureException {
        Point point = new Point(2, 2);
        Point[] points = new Point[]{point, point};

        FigureFactory factory = new FigureFactory();
        Figure figure = factory.createFigure(FigureType.LINE, points);

    }
}
