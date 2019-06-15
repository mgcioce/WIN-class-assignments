package game;

public enum Position {
    LEFT("Left",0),
    RIGHT("Right",2),
    MIDDLE("Middle",1);

    private String position;
    private int value;

    Position(String position, int value) {
        this.position = position;
        this.value = value;
    }

    public String getPosition() {
        return this.position;
    }
}
