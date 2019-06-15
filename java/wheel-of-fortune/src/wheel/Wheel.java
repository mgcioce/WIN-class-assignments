package wheel;

import util.Util;

import java.util.Random;

public enum Wheel {


    ROUND_ONE(Util.ROUND_ONE_WHEEL);

    private String[][] wheel;
    private String[] wheelValues;

    Wheel(String[][] wheel) {
        this.wheel = wheel;
        try {
            this.wheelValues = Util.parseWheelValues(this.wheel);
        } catch (Exception e) {
            e.printStackTrace();
            this.wheelValues = null;
        }

    }

    public String[] getWheelValues() {
        return this.wheelValues;
    }

    public String spinWheel() {
        Random random = new Random();
        String[] value  = wheel[random.nextInt(wheel.length)];
        if (value.length > 1) {
            return value[random.nextInt(value.length)];
        } else {
            return value[0];
        }
    }

}
