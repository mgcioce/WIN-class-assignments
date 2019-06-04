public enum Day {
    MONDAY ("Monday",true),
    TUESDAY ("Tuesday",true),
    WEDNESDAY ("Wednesday",true),
    THURSDAY ("Thursday",true),
    FRIDAY ("Friday",true),
    SATURDAY ("Saturday",false),
    SUNDAY ("Sunday",false);

    private final String day;
    private final boolean work;

    Day(String day, boolean work) {
        this.day = day;
        this.work = work;
    }

    public String toString() {
        String returnString = "Today is " + this.day;
        if (this.work) {
            return returnString + ". I have to work today.";
        } else {
            return returnString + ". I'm free today";
        }
    }
}