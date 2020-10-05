package model;

import exception.FigureException;
import service.FigurePostProcessor;
import service.FigurePreProcessor;
import service.impl.FigurePostProcessorImpl;
import service.impl.FigurePreProcessorImpl;

public class FigureFactory {
    public static FigureStorehouse figureStorehouse;
    private final FigurePreProcessor figurePreProcessor;
    private final FigurePostProcessor figurePostProcessor;
    private Figure figure;
    private FigureType figureType;
    private Point[] points;

    public FigureFactory() {
        this.figurePreProcessor = new FigurePreProcessorImpl();
        this.figurePostProcessor = new FigurePostProcessorImpl();
        figureStorehouse = FigureStorehouse.getInstance();
    }

    public Figure createFigure(FigureType figureType, Point[] points) throws FigureException {
        figure = figurePreProcessor.process(figureType, points);
        if (figure == null) {
            switch (figureType) {
                case LINE:
                    figure = new Line(points);
                case TRIANGLE:
                    figure = new Triangle(points);
                case SQUARE:
                    figure = new Square(points);
                default:
                    break;
            }
        }
        return figurePostProcessor.process(figure);
    }
}

