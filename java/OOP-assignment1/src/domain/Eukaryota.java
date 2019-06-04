package domain;

public class Eukaryota {
    protected static final String DOMAIN = "Eukaryota";
    protected static final boolean CELLS_HAVE_NUCLEUS = true;
    protected static final String[] CELLULAR_REPRODUCTION_METHODS = {"mitosis (asexual)",
                                                        "meiosis (sexual)","gamete fusion(sexual)"};
    protected static final boolean ORGANELLES_IN_CELL_MEMBRANE = true;

    public Eukaryota() {
        super();
    }

    public boolean hasNucleus() {
        return CELLS_HAVE_NUCLEUS;
    }

    public String[] getCellularReproductionMethods() {
        return CELLULAR_REPRODUCTION_METHODS;
    }

    public boolean getHasCellMembrane() {
        return ORGANELLES_IN_CELL_MEMBRANE;
    }

    @Override
    public String toString() {
        return "\tDomain: " + DOMAIN + "\n";
    }
}
