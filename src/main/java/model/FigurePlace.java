package model;

public class FigurePlace {
    private final Figure item;
    private int id;

    FigurePlace(Figure item, Integer id) {
        this.item = item;
        this.id = id;
    }

    public Figure getItem() {
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

