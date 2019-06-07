public enum Wheel {


    ROUND_ONE(Util.roundOne);

    private String[][] wheel;
    private String[] wheelValues;

    Wheel(String[][] wheel) {
        this.wheel = wheel;
        this.wheelValues = Util.parseWheelValues(this.wheel);
    }

    public String[] getWheelValues() {
        return this.wheelValues;
    }

}
