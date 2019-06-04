package order;

import bioClass.Mammalia;
public class Carnivora extends Mammalia{
    protected static final String ORDER = "Carnivora";

    protected static final boolean EAT_MEAT = true;
    protected static final String[] DENTAL_SPECS = {"premolar carnassal", "first lower molar carnassal"};
    protected static final boolean HAS_CLAWS = true;

    protected boolean huntInPacks;
    protected boolean isSocial;
    protected boolean onlyEatMeat;


    public Carnivora() {
        super();
    }

    public boolean huntsInPacks() {
        return huntInPacks;
    }

    public void setHuntInPacks(boolean huntInPacks) {
        this.huntInPacks = huntInPacks;
    }

    public boolean isSocial() {
        return isSocial;
    }

    public void setSocial(boolean social) {
        isSocial = social;
    }

    public boolean onlyEatsMeat() {
        return onlyEatMeat;
    }

    public void setOnlyEatMeat(boolean onlyEatMeat) {
        this.onlyEatMeat = onlyEatMeat;
    }

    public boolean eatsMeat() {
        return EAT_MEAT;
    }

    public String[] getDentalSpecs() {
        return DENTAL_SPECS;
    }

    public boolean hasClaws() {
        return HAS_CLAWS;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tOrder: " + ORDER + "\n";
    }
}
