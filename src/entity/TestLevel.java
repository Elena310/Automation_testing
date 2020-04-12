package entity;

public enum TestLevel {
    UNIT(1), API(3), GUI(9);

    public final int COMPLEXITY;

    private TestLevel(int COMPLEXITY) {
        this.COMPLEXITY = COMPLEXITY;
    }

    public final int getCOMPLEXITY() {
        return COMPLEXITY;
    }


}
