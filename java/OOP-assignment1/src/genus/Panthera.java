package genus;

import family.Felidae;

public class Panthera extends Felidae{
    protected static final String GENUS = "Panthera";

    protected static final boolean COMPLETELY_OSSIFIED_HYOID_BONE = false;
    protected static final boolean CAN_PRUSTEN = true;

    protected boolean canRoar;


    public Panthera() {
        super();
    }

    public boolean hasCompletelyOssifiedHyoidBone() {
        return COMPLETELY_OSSIFIED_HYOID_BONE;
    }

    public boolean canPrusten() {
        return CAN_PRUSTEN;
    }

    public boolean canRoar() {
        return canRoar;
    }

    public void setCanRoar(boolean canRoar) {
        this.canRoar = canRoar;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tGenus: " + GENUS + "\n";
    }
}
