package bioClass;

import phylum.Chordata;

public class Mammalia extends Chordata{
    protected static final String CLASS = "Mammalia";

    protected static final boolean HAS_MAMMARY_GLANDS = true;
    protected static final boolean HAS_NEOCORTEX = true;
    protected static final boolean HAS_FUR_OR_HAIR = true;
    protected static final int NUM_MIDDLE_EAR_BONES = 3;

    public Mammalia() {
        super();
    }

    public boolean hasMammaryGlands() {
        return HAS_MAMMARY_GLANDS;
    }

    public boolean hasNeocortex() {
        return HAS_NEOCORTEX;
    }

    public boolean hasFurOrHair() {
       return HAS_FUR_OR_HAIR;
    }

    public int getNumberOfInnerEarBones() {
        return NUM_MIDDLE_EAR_BONES;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tClass: " + CLASS + "\n";
    }
}
