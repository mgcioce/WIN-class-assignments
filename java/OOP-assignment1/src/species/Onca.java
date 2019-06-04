package species;

import genus.Panthera;

import java.util.ArrayList;

public class Onca extends Panthera {
    protected static final String SPECIES = "Onca";

    protected static final String[] GEOGRAPHY = {"Americas"};
    protected static final boolean IS_APEX_PREDATOR = true;

    protected ArrayList<String> coatColors;
    protected boolean hasRosettes;
    protected String commonName;

    public Onca(String commonName, boolean hasRosettes) {
        super();
        this.coatColors = new ArrayList<String>();
        this.commonName = commonName;
        this.hasRosettes = hasRosettes;
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
        this.activityPattern = "crepuscular";
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

    public void addCoatColor(String color) {
        this.coatColors.add(color);
    }

    public void setCoatColors(ArrayList<String> colors) {
        this.coatColors = colors;
    }

    public ArrayList<String> getCoatColors() {
        return this.coatColors;
    }

    public void setHasRosettes(boolean hasRosettes) {
        this.hasRosettes = hasRosettes;
    }

    public boolean hasRosettes() {
        return this.hasRosettes;
    }

    public static String[] getGEOGRAPHY() {
        return GEOGRAPHY;
    }

    public static boolean isApexPredator() {
        return IS_APEX_PREDATOR;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tSpecies: " + SPECIES + "\n";
    }
}
