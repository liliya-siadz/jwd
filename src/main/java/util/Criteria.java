package util;

import model.FigureType;
import model.Point;

import java.util.List;

public class Criteria {
    private FigureType figureType;
    private List<Point> points;
    private Integer id;

    private Criteria() {
    }

    public static class Builder {
        private final List<Point> points;
        private FigureType figureType;
        private Integer id;


        public Builder(List<Point> points) {
            this.points = points;
        }

        public Builder withFigureType(FigureType figureType) {
            this.figureType = figureType;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Criteria build() {
            Criteria criteria = new Criteria();
            criteria.figureType = this.figureType;
            criteria.points = this.points;
            criteria.id = this.id;
            return criteria;
        }
    }
}
