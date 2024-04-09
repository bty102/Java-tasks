package bo;

import java.util.ArrayList;
import java.util.Date;

import been.Hang;
import dao.Hangdao;

/**
 * Hangbo
 */
public class Hangbo {
    
    Hangdao hd = new Hangdao();
    ArrayList<Hang> ds;

    public void luuVaoCSDL(String file) throws Exception {
    	hd.luuVaoCSDL(file);
    }
    
    public ArrayList<Hang> getDS() throws Exception {
        ds = hd.getDS();
        return ds;
    }

    public boolean ktMa(String maHang) {
        for(Hang h : ds) {
            if(h.getMaHang().equals(maHang)) return true;
        }
        return false;
    }

    public boolean them(String maHang, String tenHang, Date ngayNhapHang, int soLuong, float gia) throws Exception {
        if(ktMa(maHang)) return false;
        ds.add(new Hang(maHang, tenHang, ngayNhapHang, soLuong, gia));
        hd.themHangVaoCSDL(maHang, tenHang, ngayNhapHang, soLuong, gia);
        return true;
    }

    public int sua(String maHang, String tenHang, Date ngayNhapHang, int soLuong, float gia) throws Exception {
        for(Hang h : ds) {
            if(h.getMaHang().equals(maHang)) {
                h.setTenHang(tenHang);
                h.setNgayNhapHang(ngayNhapHang);
                h.setSoLuong(soLuong);
                h.setGia(gia);
                hd.SuaHang(maHang, tenHang, ngayNhapHang, soLuong, gia);
                return 1;
            }
        }
        return 0;
    }

    public int xoa(String maHang) throws Exception {
        for(Hang h : ds) {
            if(h.getMaHang().equals(maHang)) {
                ds.remove(h);
                hd.XoaHang(maHang);
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<Hang> timKiem(String tenHang) throws Exception {
        ArrayList<Hang> tmp = new ArrayList<Hang>();
        for(Hang h : ds) {
            if(h.getTenHang().contains(tenHang)) tmp.add(h);
        }
        return tmp;
    } 
}
