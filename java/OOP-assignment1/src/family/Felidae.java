package family;

import order.Carnivora;

public class Felidae extends Carnivora{
    protected static final String FAMILY = "Felidae";

    protected static final boolean RETRACTILE_CLAWS = true;
    protected static final String[] POSSIBLE_GEOGRAPHY = {"Africa","Asia","Europe","Americas"};
    protected static final String[] POSSIBLE_HABITAT = {"forest","arid","wetlands","mountains"};
    protected static final boolean DIGITIGRADE = true;
    protected static final int FOREFEET_NUM_TOES = 5;
    protected static final int HINDFEET_NUM_TOES = 4;
    protected static final int NUM_TEETH = 30;
    protected static final String[] WHISKER_LOCATIONS = {"above the eyes","on the cheeks", "on the muzzle"};
    protected static final boolean PAPILLAE_ON_TONGUE = true;
    protected static final String VISION = "binocular";
    protected static final boolean TASTE_SWEETNESS = false;
    protected static final boolean VOMERONASAL_ORGAN = true;
    protected static final boolean CAN_PURR = true;


    protected String habitat;
    protected String activityPattern;


    public Felidae() {
        super();
    }

    public int getHindfeedNumToes() {
        return HINDFEET_NUM_TOES;
    }

    public int getNumTeeth() {
        return NUM_TEETH;
    }

    public String[] getWhiskerLocations() {
        return WHISKER_LOCATIONS;
    }

    public boolean hasPapillaeOnTongue() {
        return PAPILLAE_ON_TONGUE;
    }

    public String getVision() {
        return VISION;
    }

    public boolean canTasteSweetness() {
        return TASTE_SWEETNESS;
    }

    public boolean hasVomeronasalOrgan() {
        return VOMERONASAL_ORGAN;
    }

    public boolean canPurr() {
        return CAN_PURR;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getActivityPattern() {
        return activityPattern;
    }

    public void setActivityPattern(String activityPattern) {
        this.activityPattern = activityPattern;
    }

    public boolean hasRetractileClaws() {
        return RETRACTILE_CLAWS;
    }

    @Override
    public void setOnlyEatMeat(boolean onlyEatMeat) {
        this.onlyEatMeat = true;
    }

    public String[] getPossibleGeography() {
        return POSSIBLE_GEOGRAPHY;
    }

    public boolean isDigitigrade() {
        return DIGITIGRADE;
    }

    public int getForefeetNumToes() {
        return FOREFEET_NUM_TOES;
    }

    public String[] getPossibleHabitat() {
        return POSSIBLE_HABITAT;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tFamily: " + FAMILY + "\n";
    }
}
