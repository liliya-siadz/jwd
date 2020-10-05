package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strategy.impl.TrianglePropertiesStrategy;

public class Triangle extends Figure {

    static Logger logger = LoggerFactory.getLogger(Triangle.class);

    Triangle(Point[] points) {
        super(FigureType.TRIANGLE, TrianglePropertiesStrategy.INSTANCE);
        this.points = points;
    }

}
