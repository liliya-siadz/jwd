import exception.FigureException;
import factory.ApplicationContext;
import model.FigureType;
import model.Point;

public class Main {

    public static void main(String[] args) throws FigureException {
        Point[] points = new Point[]{new Point(5, 3), new Point(5, 3)};
        System.out.println(ApplicationContext.createFigure(FigureType.LINE, points));
    }
}
