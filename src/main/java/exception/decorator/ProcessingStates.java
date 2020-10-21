package exception.decorator;

public enum ProcessingStates {
    ON(1),
    OFF(0),
    EXTRA(2);

    private final int flag;

    ProcessingStates(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }
}
