package ly;

/**
 * SvLy
 */
public class SvLy {

    private String maSV;
    private String hoTen;
    private double dm1;
    private double dm2;
    private double dm3;
    private double dm4;

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDm1() {
        return dm1;
    }

    public void setDm1(double dm1) {
        this.dm1 = dm1;
    }

    public double getDm2() {
        return dm2;
    }

    public void setDm2(double dm2) {
        this.dm2 = dm2;
    }

    public double getDm3() {
        return dm3;
    }

    public void setDm3(double dm3) {
        this.dm3 = dm3;
    }

    public double getDm4() {
        return dm4;
    }

    public void setDm4(double dm4) {
        this.dm4 = dm4;
    }

    public SvLy(String maSV, String hoTen, double dm1, double dm2, double dm3, double dm4) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.dm1 = dm1;
        this.dm2 = dm2;
        this.dm3 = dm3;
        this.dm4 = dm4;
    }

    public double getDTB() {
        return (dm1+dm2+dm3+dm4)/4;
    }

    public String getKetQua() {
        return (getDTB()>=5)?"dau":"rot";
    }

    public void hienThi() {
        System.out.println(maSV+"|"+hoTen+"|"+dm1+"|"+dm2+"|"+dm3+"|"+dm4+"|"+getDTB()+"|"+getKetQua());
    }

    public String getThongTin() {
        return maSV+"|"+hoTen+"|"+dm1+"|"+dm2+"|"+dm3+"|"+dm4+"|"+getDTB()+"|"+getKetQua();
    }
}
