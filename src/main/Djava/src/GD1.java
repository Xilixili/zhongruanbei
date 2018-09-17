public class GD1 {


    private String GD_name;
    private String GDLX;
    private String GDBL;


    @Override
    public String toString() {
        return "GD1{" +
                "GD_name='" + GD_name + '\'' +
                ", GDLX='" + GDLX + '\'' +
                ", GDBL='" + GDBL + '\'' +
                '}';
    }

    public String getGD_name() {
        return GD_name;
    }

    public void setGD_name(String GD_name) {
        this.GD_name = GD_name;
    }

    public String getGDLX() {
        return GDLX;
    }

    public void setGDLX(String GDLX) {
        this.GDLX = GDLX;
    }

    public String getGDBL() {
        return GDBL;
    }

    public void setGDBL(String GDBL) {
        this.GDBL = GDBL;
    }
}
