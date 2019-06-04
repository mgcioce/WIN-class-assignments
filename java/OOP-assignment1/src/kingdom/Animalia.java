package kingdom;

import domain.Eukaryota;

public class Animalia extends Eukaryota {
    protected static final String KINGDOM = "Animalia";

    protected static final boolean MULTICELLULAR = true;

    protected boolean consumeOrganicMaterial;
    protected boolean breatheOxygen;
    protected boolean ableToMove;
    protected boolean canReproduceSexually;
    protected boolean growFromBlastula;

    protected double sizeInCentimeters;
    protected double massInKilograms;
    protected String gender;

    public Animalia() {
        super();
    }

    public boolean isMulticellular() {
        return MULTICELLULAR;
    }

    public boolean consumesOrganicMaterial() {
        return consumeOrganicMaterial;
    }

    public void setConsumeOrganicMaterial(boolean consumeOrganicMaterial) {
        this.consumeOrganicMaterial = consumeOrganicMaterial;
    }

    public boolean breathesOxygen() {
        return breatheOxygen;
    }

    public void setBreatheOxygen(boolean breatheOxygen) {
        this.breatheOxygen = breatheOxygen;
    }

    public boolean isAbleToMove() {
        return ableToMove;
    }

    public void setAbleToMove(boolean ableToMove) {
        this.ableToMove = ableToMove;
    }

    public boolean CanReproduceSexually() {
        return canReproduceSexually;
    }

    public void setCanReproduceSexually(boolean canReproduceSexually) {
        this.canReproduceSexually = canReproduceSexually;
    }

    public boolean isGrownFromBlastula() {
        return growFromBlastula;
    }

    public void setGrowFromBlastula(boolean growFromBlastula) {
        this.growFromBlastula = growFromBlastula;
    }

    public double getSizeInCentimeters() {
        return sizeInCentimeters;
    }

    public void setSizeInCentimeters(double sizeInCentimeters) {
        this.sizeInCentimeters = sizeInCentimeters;
    }

    public double getMassInKilograms() {
        return massInKilograms;
    }

    public void setMassInKilograms(double weightInKilograms) {
        this.massInKilograms = weightInKilograms;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tKingdom: " + KINGDOM + "\n";
    }
}
