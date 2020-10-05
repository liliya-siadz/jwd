package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strategy.impl.LinePropertiesStrategy;

public class Line extends Figure {
    static Logger logger = LoggerFactory.getLogger(Line.class);

    Line(Point[] points) {
        super(FigureType.LINE, LinePropertiesStrategy.INSTANCE);
        this.points = points;
    }

}
