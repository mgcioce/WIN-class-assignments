import kingdom.Animalia;
import species.Onca;
import species.Tigris;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        Onca jaguar = new Onca("Black Panther",false);
        jaguar.setSizeInCentimeters(150);
        jaguar.addCoatColor("black");
        jaguar.setMassInKilograms(60);
        System.out.println(Arrays.toString(jaguar.getCellularReproductionMethods()));
        System.out.println(jaguar.toString());

        Tigris tiger = new Tigris("Tiger",200);
        ArrayList<String> colors = new ArrayList<>();
        colors.add("orange");
        colors.add("black");
        colors.add("white");
        tiger.setCoatColors(colors);
        System.out.println(Arrays.toString(tiger.getCoatColors().toArray()));
        System.out.println(tiger.toString());
        System.out.println(Arrays.toString(tiger.getPossibleHabitat()));
        tiger.setHabitat("forest");
        System.out.println(tiger.getHabitat());
    }
}
