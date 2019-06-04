package phylum;

import kingdom.Animalia;

public class Chordata extends Animalia{
    protected static final String PHYLUM = "Cordata";

    protected static final String[] LIFE_CYCLE_CHARACTERISTICS = {"notochord", "dorsal nerve chord",
                                                        "pharyngeal slits","endostyle",
                                                        "post-anal tail"};
    protected static final boolean BILATERALLY_SYMMETRIC = true;
    protected static final boolean HAS_COELOM = true;
    protected static final boolean HAS_METAMERIC_SEGMENTATION = true;
    protected static final boolean HAS_CIRCULATORY_SYSTEM = true;

    public Chordata() {
        super();
    }

    public String[] getLifeCycleCharacteristics() {
        return LIFE_CYCLE_CHARACTERISTICS;
    }

    public boolean isBilaterallySymmetric() {
        return BILATERALLY_SYMMETRIC;
    }

    public boolean hasCoelom() {
        return HAS_COELOM;
    }

    public boolean hasMetamericSegmentation() {
        return HAS_METAMERIC_SEGMENTATION;
    }

    public boolean hasCirculatorySystem() {
        return HAS_CIRCULATORY_SYSTEM;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tPhylum: " + PHYLUM + "\n";
    }
}
