package entity;

public enum Result {
    PASSED("Good!"),
    FAILED("Oh, no!");
    private final String result;

    Result(String result) {
        this.result = result;
    }

    public final String getResult() {
        return result;
    }
}
