public class company1 {
//    分析后的entity类
    private String com_name;
    private String SF;
    private String HY;
    private String job_num;
    private String NX;
    private String ZB;
    private String RZ;
    private String SS;
    private String SX;

    @Override
    public String toString() {
        return "company{" +
                "com_name='" + com_name + '\'' +
                ", SF='" + SF + '\'' +
                ", HY='" + HY + '\'' +
                ", job_num='" + job_num + '\'' +
                ", NX='" + NX + '\'' +
                ", ZB='" + ZB + '\'' +
                ", RZ='" + RZ + '\'' +
                ", SS='" + SS + '\'' +
                ", SX='" + SX + '\'' +
                '}';
    }
    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getSF() {
        return SF;
    }

    public void setSF(String SF) {
        this.SF = SF;
    }

    public String getHY() {
        return HY;
    }

    public void setHY(String HY) {
        this.HY = HY;
    }

    public String getJob_num() {
        return job_num;
    }

    public void setJob_num(String job_num) {
        this.job_num = job_num;
    }

    public String getNX() {
        return NX;
    }

    public void setNX(String NX) {
        this.NX = NX;
    }

    public String getZB() {
        return ZB;
    }

    public void setZB(String ZB) {
        this.ZB = ZB;
    }

    public String getRZ() {
        return RZ;
    }

    public void setRZ(String RZ) {
        this.RZ = RZ;
    }

    public String getSS() {
        return SS;
    }

    public void setSS(String SS) {
        this.SS = SS;
    }

    public String getSX() {
        return SX;
    }

    public void setSX(String SX) {
        this.SX = SX;
    }

}
