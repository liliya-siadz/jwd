package service;

import model.FigureType;
import model.Point;

import java.util.List;
import java.util.Objects;

public class Criteria {
    private final FigureType figureType;
    private final List<Point> points;

    private Criteria(Builder builder) {
        figureType = builder.figureType;
        points = builder.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(figureType, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Criteria criteria = (Criteria) o;
        return figureType == criteria.figureType && Objects.equals(points, criteria.points);
    }

    public static class Builder {
        private final FigureType figureType;
        private final List<Point> points;

        public Builder(FigureType figureType, List<Point> points) {
            this.figureType = figureType;
            this.points = points;
        }

        public Criteria build() {
            return new Criteria(this);
        }

    }
}
