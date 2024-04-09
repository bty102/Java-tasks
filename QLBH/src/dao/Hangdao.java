package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import been.Hang;

/**
 * Hangdao
 */
public class Hangdao {

    public boolean ktMa(String maHang) throws Exception {
        KetNoidao kn = new KetNoidao();
        kn.ketNoi();
        String sql = "select * from Hang where maHang = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, maHang);
        ResultSet rs = cmd.executeQuery();
        boolean kq = rs.next();
        kn.cn.close();
        return kq;
    }

    public boolean themHangVaoCSDL(String maHang, String tenHang, Date ngayNhapHang, int soLuong, float gia) throws Exception {
        if(ktMa(maHang)) return false;
        KetNoidao kn = new KetNoidao();
        kn.ketNoi();
        String sql = "insert into Hang(maHang, tenHang, ngayNhapHang, soLuong, gia) values(?, ?, ?, ?, ?)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, maHang);
        cmd.setString(2, tenHang);
        cmd.setDate(3, new java.sql.Date(ngayNhapHang.getTime()));
        cmd.setInt(4, soLuong);
        cmd.setFloat(5, gia);
        cmd.executeUpdate();
        kn.cn.close();
        return true;
    }

    public void luuVaoCSDL(String file) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while(true) {
            String line = br.readLine();
            if(line==null || line.equals("")) break;
            String[] t_line = line.split(";");
            String maHang = t_line[0];
            String tenHang = t_line[1];
            Date ngayNhapHang = f.parse(t_line[2]);
            int soLuong = Integer.parseInt(t_line[3]);
            float gia = Float.parseFloat(t_line[4]);
            themHangVaoCSDL(maHang, tenHang, ngayNhapHang, soLuong, gia);
        }
        br.close();
        fr.close();
    }

    public ArrayList<Hang> getDS() throws Exception {
        ArrayList<Hang> ds = new ArrayList<Hang>();
        KetNoidao kn = new KetNoidao();
        kn.ketNoi();
        String sql = "select * from Hang";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
            String maHang = rs.getString("maHang");
            String tenHang = rs.getString("tenHang");
            Date ngayNhapHang = rs.getDate("ngayNhapHang");
            int soLuong = rs.getInt("soLuong");
            float gia = rs.getFloat("gia");
            ds.add(new Hang(maHang, tenHang, ngayNhapHang, soLuong, gia));
        }
        kn.cn.close();
        return ds;
    }

    public int XoaHang(String maHang) throws Exception {
        KetNoidao kn = new KetNoidao();
        kn.ketNoi();
        String sql = "delete from Hang where maHang = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, maHang);
        int soDongAnhHuong = cmd.executeUpdate();
        kn.cn.close();
        return soDongAnhHuong;
    }

    public int SuaHang(String maHang, String tenHang, Date ngayNhapHang, int soLuong, float gia) throws Exception {
        KetNoidao kn = new KetNoidao();
        kn.ketNoi();
        String sql = "update Hang set tenHang = ?, ngayNhapHang = ?, soLuong = ?, gia = ? where maHang = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, tenHang);
        cmd.setDate(2, new java.sql.Date(ngayNhapHang.getTime()));
        cmd.setInt(3, soLuong);
        cmd.setFloat(4, gia);
        cmd.setString(5, maHang);
        int soDongAnhHuong = cmd.executeUpdate();
        kn.cn.close();
        return soDongAnhHuong;
    }

    public static void main(String[] args) {
        try {
            Hangdao hdao = new Hangdao();
            hdao.luuVaoCSDL("hang.txt");
            for(Hang h : hdao.getDS()) {
                System.out.println(h.toString());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
