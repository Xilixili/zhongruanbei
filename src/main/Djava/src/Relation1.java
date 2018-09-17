public class Relation1
{
    private String com_name;
    private String reg_no;
    private String maxTZ;
    private String TZRQ;
    private String maxTZR;




    @Override
    public String toString() {
        return "Relation1{" +
                "com_name='" + com_name + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", maxTZ='" + maxTZ + '\'' +
                ", TZRQ='" + TZRQ + '\'' +
                ", maxTZR='" + maxTZR + '\'' +
                '}';
    }

    public String getMaxTZR() {
        return maxTZR;
    }

    public void setMaxTZR(String maxTZR) {
        this.maxTZR = maxTZR;
    }
    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getMaxTZ() {
        return maxTZ;
    }

    public void setMaxTZ(String maxTZ) {
        this.maxTZ = maxTZ;
    }

    public String getTZRQ() {
        return TZRQ;
    }

    public void setTZRQ(String TZRQ) {
        this.TZRQ = TZRQ;
    }


}
