public class GD {
    private String reg_no;
    private String GD_name;

    @Override
    public String toString() {
        return "GD{" +
                "reg_no='" + reg_no + '\'' +
                ", GD_name='" + GD_name + '\'' +
                ", GDLX='" + GDLX + '\'' +
                ", GDBL=" + GDBL +
                ", com_name='" + com_name + '\'' +
                '}';
    }

    private String GDLX;
    private Double GDBL;
    private String com_name;


    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
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

    public Double getGDBL() {
        return GDBL;
    }

    public void setGDBL(Double GDBL) {
        this.GDBL = GDBL;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }
}
