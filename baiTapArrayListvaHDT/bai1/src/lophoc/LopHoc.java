package lophoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import cntt.SvCntt;
import ly.SvLy;
import toan.SvToan;

/**
 * LopHoc
 */
public class LopHoc {

    private ArrayList<Object> dsSV = new ArrayList<Object>();
    public void taoLop(String fileDS) throws Exception {
        FileReader fr = new FileReader(fileDS);
        BufferedReader br = new BufferedReader(fr);
        while(true) {
            String line = br.readLine();
            if(line==null || line.equals("")) break;
            String[] t_line = line.split("[|]");
            if(t_line.length==4) {
                // SV CNTT
                String maSV = t_line[0];
                String hoTen = t_line[1];
                double dm1 = Double.parseDouble(t_line[2]);
                double dm2 = Double.parseDouble(t_line[3]);
                dsSV.add(new SvCntt(maSV, hoTen, dm1, dm2));
            }
            else if(t_line.length==5) {
                // SV toan
                String maSV = t_line[0];
                String hoTen = t_line[1];
                double dm1 = Double.parseDouble(t_line[2]);
                double dm2 = Double.parseDouble(t_line[3]);
                double dm3 = Double.parseDouble(t_line[4]);
                dsSV.add(new SvToan(maSV, hoTen, dm1, dm2, dm3));
            }
            else if(t_line.length==6) {
                // SV ly
                String maSV = t_line[0];
                String hoTen = t_line[1];
                double dm1 = Double.parseDouble(t_line[2]);
                double dm2 = Double.parseDouble(t_line[3]);
                double dm3 = Double.parseDouble(t_line[4]);
                double dm4 = Double.parseDouble(t_line[5]);
                dsSV.add(new SvLy(maSV, hoTen, dm1, dm2, dm3, dm4));
            }
            else {}
        }
        br.close();
        fr.close();
    }
    public void hienThi() {
        System.out.println("SV CNTT:");
        for(Object sv : dsSV) {
            if(sv instanceof SvCntt) {
                SvCntt tmp = (SvCntt)sv;
                tmp.hienThi();
            }    
        }
        System.out.println("SV toan:");
        for(Object sv : dsSV) {
            if(sv instanceof SvToan) {
                SvToan tmp = (SvToan)sv;
                tmp.hienThi();
            }
        }
        System.out.println("SV ly:");
        for(Object sv : dsSV) {
            if(sv instanceof SvLy) {
                SvLy tmp = (SvLy)sv;
                tmp.hienThi();
            }
        }
    }
    public void hienThi(String khoa) {
        if(khoa.trim().toLowerCase().equals("cntt")) {
            for(Object sv : dsSV) {
                if(sv instanceof SvCntt) {
                    SvCntt tmp = (SvCntt)sv;
                    tmp.hienThi();
                }
            }
        }
        else if(khoa.trim().toLowerCase().equals("toan")) {
            for(Object sv : dsSV) {
                if(sv instanceof SvToan) {
                    SvToan tmp = (SvToan)sv;
                    tmp.hienThi();
                }
            }
        }
        else if(khoa.trim().toLowerCase().equals("ly")) {
            for(Object sv : dsSV) {
                if(sv instanceof SvLy) {
                    SvLy tmp = (SvLy)sv;
                    tmp.hienThi();
                }
            }
        }
        else {}
    }
    public void hienThiDTBtungKhoa() {
        double tongDTB_CNTT = 0, tongDTB_toan = 0, tongDTB_ly = 0;
        int SLSV_CNTT = 0, SLSV_toan = 0, SLSV_ly = 0;
        for(Object sv : dsSV) {
            if(sv instanceof SvCntt) {
                SvCntt tmp = (SvCntt)sv;
                tongDTB_CNTT += tmp.getDTB();
                SLSV_CNTT++;
            }
            if(sv instanceof SvToan) {
                SvToan tmp = (SvToan)sv;
                tongDTB_toan += tmp.getDTB();
                SLSV_toan++;
            }
            if(sv instanceof SvLy) {
                SvLy tmp = (SvLy)sv;
                tongDTB_ly += tmp.getDTB();
                SLSV_ly++;
            }
        }
        System.out.println("DTB cua khoa CNTT: "+tongDTB_CNTT/SLSV_CNTT);
        System.out.println("DTB cua khoa toan: "+tongDTB_toan/SLSV_toan);
        System.out.println("DTB cua khoa ly: "+tongDTB_ly/SLSV_ly);
    }
    public void luuFileTheoTungKhoa() throws Exception {
        FileWriter fw1 = new FileWriter("f1.txt");
        BufferedWriter bw1 = new BufferedWriter(fw1);
        FileWriter fw2 = new FileWriter("f2.txt");
        BufferedWriter bw2 = new BufferedWriter(fw2);
        FileWriter fw3 = new FileWriter("f3.txt");
        BufferedWriter bw3 = new BufferedWriter(fw3);
        for(Object sv : dsSV) {
            if(sv instanceof SvCntt) {
                SvCntt tmp = (SvCntt)sv;
                bw1.write(tmp.getThongTin()+"\n");
            }
            if(sv instanceof SvToan) {
                SvToan tmp = (SvToan)sv;
                bw2.write(tmp.getThongTin()+"\n");
            }
            if(sv instanceof SvLy) {
                SvLy tmp = (SvLy)sv;
                bw3.write(tmp.getThongTin()+"\n");
            }
        }
        bw1.close();
        fw1.close();
        bw2.close();
        fw2.close();
        bw3.close();
        fw3.close();
    }
    public void hienThi(String hoTen, String khoa) {
        if(khoa.trim().toLowerCase().equals("cntt")) {
            boolean timThay = false;
            for(Object sv : dsSV) {
                if(sv instanceof SvCntt) {
                    SvCntt tmp = (SvCntt)sv;
                    if(tmp.getHoTen().toLowerCase().contains(hoTen.trim().toLowerCase())) {
                        tmp.hienThi();
                        timThay = true;
                    }
                }
            }
            if(!timThay) System.out.println("Khong tim thay!!!");
        }
        else if(khoa.trim().toLowerCase().equals("toan")) {
            boolean timThay = false;
            for(Object sv : dsSV) {
                if(sv instanceof SvToan) {
                    SvToan tmp = (SvToan)sv;
                    if(tmp.getHoTen().toLowerCase().contains(hoTen.trim().toLowerCase())) {
                        tmp.hienThi();
                        timThay = true;
                    }
                }
            }
            if(!timThay) System.out.println("Khong tim thay!!!");
        }
        else if(khoa.trim().toLowerCase().equals("ly")) {
            boolean timThay = false;
            for(Object sv : dsSV) {
                if(sv instanceof SvLy) {
                    SvLy tmp = (SvLy)sv;
                    if(tmp.getHoTen().toLowerCase().contains(hoTen.trim().toLowerCase())) {
                        tmp.hienThi();
                        timThay = true;
                    }
                }
            }
            if(!timThay) System.out.println("Khong tim thay");
        }
        else {
            System.out.println("Khong tim thay!!!");
        }
    }
    public static void main(String[] args) {
        try {
            LopHoc lh = new LopHoc();
            lh.taoLop("sv.txt");
            lh.hienThi();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap vao mot khoa: ");
            String khoa = sc.nextLine();
            lh.hienThi(khoa);
            lh.hienThiDTBtungKhoa();
            lh.luuFileTheoTungKhoa();
            System.out.println("Da luu file theo tung khoa!!!");
            System.out.print("Nhap vao ho ten can tim: ");
            String hoTen = sc.nextLine();
            System.out.print("Nhap vao khoa can tim: ");
            khoa = sc.nextLine();
            lh.hienThi(hoTen, khoa);
        } catch(Exception e) {System.out.println(e.getMessage());}
    }
}
