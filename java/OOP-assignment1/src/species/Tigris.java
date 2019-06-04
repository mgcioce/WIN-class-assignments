package species;

import genus.Panthera;

import java.util.ArrayList;

public class Tigris extends Panthera {
    protected static final String SPECIES = "Tigris";

    protected static final String[] GEOGRAPHY = {"Asia"};
    protected static final boolean IS_APEX_PREDATOR = true;
    protected static final boolean HAS_STRIPES = true;
    protected static final boolean SEXUALLY_DIMORPHIC = true;

    protected ArrayList<String> coatColors;
    protected double skullLengthInMillimeters;
    protected String commonName;

    public Tigris(String commonName, double skullLengthInMillimeters) {
        super();
        this.commonName = commonName;
        this.skullLengthInMillimeters = skullLengthInMillimeters;
        this.coatColors = new ArrayList<String>();
        this.setAbleToMove(true);
        this.setHuntInPacks(false);
        this.setCanRoar(true);
        this.setActivityPattern(null);
        this.setConsumeOrganicMaterial(true);
        this.setBreatheOxygen(true);
        this.setCanReproduceSexually(true);
        this.setGrowFromBlastula(true);
        this.setSocial(false);
    }

    @Override
    public void setHuntInPacks(boolean huntInPacks) {
        this.huntInPacks = false;
    }

    @Override
    public void setCanRoar(boolean canRoar) {
        this.canRoar = true;
    }

    @Override
    public void setActivityPattern(String activityPattern) {
        this.activityPattern = "diurnal";
    }

    @Override
    public void setConsumeOrganicMaterial(boolean consumeOrganicMaterial) {
        this.consumeOrganicMaterial = true;
    }

    @Override
    public void setBreatheOxygen(boolean breatheOxygen) {
        this.breatheOxygen = true;
    }

    @Override
    public void setAbleToMove(boolean ableToMove) {
        this.ableToMove = ableToMove;
    }

    @Override
    public void setCanReproduceSexually(boolean canReproduceSexually) {
        this.canReproduceSexually = true;
    }

    @Override
    public void setGrowFromBlastula(boolean growFromBlastula) {
        this.growFromBlastula = true;
    }

    @Override
    public void setSocial(boolean social) {
        isSocial = false;
    }

    public static String[] getGEOGRAPHY() {
        return GEOGRAPHY;
    }

    public static boolean isIsApexPredator() {
        return IS_APEX_PREDATOR;
    }

    public static boolean isHasStripes() {
        return HAS_STRIPES;
    }

    public static boolean isSexuallyDimorphic() {
        return SEXUALLY_DIMORPHIC;
    }

    public ArrayList<String> getCoatColors() {
        return coatColors;
    }

    public void addCoatColor(String color) {
        this.coatColors.add(color);
    }

    public void setCoatColors(ArrayList<String> coatColors) {
        this.coatColors = coatColors;
    }

    public double getSkullLengthInMillimeters() {
        return skullLengthInMillimeters;
    }

    public void setSkullLengthInMillimeters(double skullLengthInMillimeters) {
        this.skullLengthInMillimeters = skullLengthInMillimeters;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tSpecies: " + SPECIES + "\n";
    }
}
