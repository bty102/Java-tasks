package BtFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import BtMang.BtMang;

/**
 * BtFile
 */
public class BtFile {
    
    public void TaoDanhSach(int n) {
        try {
            FileWriter fw = new FileWriter("sv.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Random r = new Random();
            BtMang tmp_oj = new BtMang();
            for(int i = 1; i <= n; i++) {
                String fname = tmp_oj.TaoHoTen();
                String ngaySinh = tmp_oj.TaoNgay("1/1/2000", "1/1/2024");
                String gioiTinh = r.nextBoolean()? "nu" : "nam";
                float dtb = r.nextFloat()*10;
                String kq = (dtb>=5)? "dau" : "rot";
                String xl;
                if(dtb < 3) xl = "kem";
                else if(dtb <= 4.9) xl = "yeu";
                else if(dtb <= 6.4) xl = "tb";
                else if(dtb <= 7.9) xl = "kha";
                else xl = "gioi";
                bw.write(String.format("sv%d;%s;%s;%s;%f;%s;%s\n", i, fname, ngaySinh, gioiTinh, dtb, kq, xl));
            }
            bw.close();
            fw.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }

    public void XuatDanhSach() {
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.printf("*%s*\n", "-".repeat(91));
            System.out.printf("|%-5s|%-30s|%-15s|%-10s|%-15s|%-5s|%-5s|\n", "Ma SV", "Ho ten", "Ngay sinh", "Gioi tinh","DTB", "KQ", "XL");
            System.out.printf("*%s*\n", "-".repeat(91));
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                String[] t_line = line.split(";");
                System.out.printf("|%-5s|%-30s|%-15s|%-10s|%-15s|%-5s|%-5s|\n", t_line[0].trim(), t_line[1].trim(), t_line[2].trim(), t_line[3].trim(), t_line[4].trim(), t_line[5].trim(), t_line[6].trim());
                System.out.printf("|%s|\n", "-".repeat(91));
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }

    public void TimKiem(String name) {
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.printf("*%s*\n", "-".repeat(91));
            System.out.printf("|%-5s|%-30s|%-15s|%-10s|%-15s|%-5s|%-5s|\n", "Ma SV", "Ho ten", "Ngay sinh", "Gioi tinh","DTB", "KQ", "XL");
            System.out.printf("*%s*\n", "-".repeat(91));
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                String[] t_line = line.split(";");
                if(t_line[1].trim().toLowerCase().contains(name.trim().toLowerCase())) {   
                    System.out.printf("|%-5s|%-30s|%-15s|%-10s|%-15s|%-5s|%-5s|\n", t_line[0].trim(), t_line[1].trim(), t_line[2].trim(), t_line[3].trim(), t_line[4].trim(), t_line[5].trim(), t_line[6].trim());
                    System.out.printf("|%s|\n", "-".repeat(91));
                }
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }

    public void SL_Dau_Rot() {
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            int SL_Dau = 0;
            int SL_Rot = 0;
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                String[] t_line = line.split(";");
                if(t_line[5].trim().toLowerCase().equals("dau")) SL_Dau++;
                else SL_Rot++;
            }
            System.out.println("Dau: " + SL_Dau);
            System.out.println("Rot: " + SL_Rot);
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }

    public float TBCofDTB() {
        float sumOfDTB = 0;
        int SLSV = 0;
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                SLSV++;
                String[] t_line = line.split(";");
                sumOfDTB += Float.parseFloat(t_line[4]);
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
        return sumOfDTB/SLSV;
    }

    public boolean checkNgaySinh(String ngaySinh) {
        if(ngaySinh.split("/").length != 3) return false;
        if(ngaySinh.length() == 10) return true;
        return false;
    }

    public void InDongKhongHopLe() {
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                String[] t_line = line.split(";");
                String ngaySinh = t_line[2];
                float dtb = Float.parseFloat(t_line[4]);
                if(checkNgaySinh(ngaySinh)==false || (dtb < 0 || dtb > 10)) {
                    System.out.println(line);
                } 
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }
}
