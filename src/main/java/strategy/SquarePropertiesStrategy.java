package strategy;

import model.Figure;
import model.Point;
import util.LineUtil;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    /*1 Lazy Singleton realization
     */
    private static SquarePropertiesStrategy instance;

    private double lengthAB;
    private double lengthAD;
    private double lengthBC;
    private double lengthCD;

    private SquarePropertiesStrategy() {
    }

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    private void setLengths(Figure figure) {
        Point[] points = figure.getPoints();
        lengthAB = LineUtil.calculateLength(points[0], points[1]);
        lengthAD = LineUtil.calculateLength(points[0], points[3]);
        lengthBC = LineUtil.calculateLength(points[1], points[2]);
        lengthCD = LineUtil.calculateLength(points[2], points[3]);
    }

    @Override
    public double calculateArea(Figure figure) {
        double p = calculatePerimeter(figure) / 2;
        double area = Math.sqrt(p * (p - lengthAB) * (p - lengthAD) * (p - lengthBC) * (p - lengthCD));
        return (int) area;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        setLengths(figure);
        return lengthAB + lengthAD + lengthBC + lengthCD;
    }
}
