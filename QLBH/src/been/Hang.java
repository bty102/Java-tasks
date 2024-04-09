package been;

import java.util.Date;

/**
 * Hang
 */
public class Hang {

    private String maHang;
    private String tenHang;
    private Date ngayNhapHang;
    private int soLuong;
    private float gia;

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public Date getNgayNhapHang() {
		return ngayNhapHang;
	}

	public void setNgayNhapHang(Date ngayNhapHang) {
		this.ngayNhapHang = ngayNhapHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Hang(String maHang, String tenHang, Date ngayNhapHang, int soLuong, float gia) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngayNhapHang = ngayNhapHang;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	@Override
	public String toString() {
        return maHang+";"+tenHang+";"+ngayNhapHang+";"+soLuong+";"+gia;
	}

}
