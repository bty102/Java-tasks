package QLBDX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * QuanLyBaiDoXe
 */
public class QuanLyBaiDoXe {

    public static void main(String[] args) {
        ArrayList<String> DLVao = new ArrayList<String>();
        ArrayList<String> DLRa = new ArrayList<String>();
        //ArrayList<Integer> TienThueBai = new ArrayList<Integer>();

        try {
            FileReader fr = new FileReader("input1.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                DLVao.add(line);// them vao cuoi
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}

        try {
            FileReader fr = new FileReader("input2.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                DLRa.add(line);//them vao cuoi
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}

        try {
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            int KichThuoc = DLVao.size();
            for(int i = 0; i <= KichThuoc-1; i++) {
                String[] DLXeVao = DLVao.get(i).split(";");
                String[] DLXeRa = DLRa.get(i).split(";");
                int TienThueBai;
                if(DLXeVao[0].equals("4")) {
                    SimpleDateFormat f = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                    Date tg_vao = f.parse(DLXeVao[3]);
                    Date tg_ra = f.parse(DLXeRa[3]);
                    float tg_gui = (tg_ra.getTime()-tg_vao.getTime())/((float)1000*60*60);
                    float tp_tg_gui = tg_gui - (int)tg_gui;
                    tg_gui = (int)tg_gui;
                    if(tp_tg_gui > 0 && tp_tg_gui <= 0.5) tg_gui += 0.5;
                    if(tp_tg_gui > 0.5) tg_gui += 1;
                    TienThueBai = (int)((tg_gui/0.5)*5000);
                    // FileWriter fw = new FileWriter("output.txt");
                    // BufferedWriter bw = new BufferedWriter(fw);
                    // bw.write(String.format("%s;%s;%s;%s;%s;%d\n", DLXeVao[0], DLXeVao[1], DLXeVao[2], DLXeVao[3], DLXeRa[3], TienThueBai));
                    // bw.close();
                    // fw.close();
                }
                else if(DLXeVao[0].equals("2")) {
                    SimpleDateFormat f = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                    Date tg_vao = f.parse(DLXeVao[3]);
                    Date tg_ra = f.parse(DLXeRa[3]);
                    float tg_gui = (tg_ra.getTime()-tg_vao.getTime())/((float)1000*60*60*24);
                    if(tg_gui != (int)tg_gui) tg_gui = (int)tg_gui + 1;
                    TienThueBai = (int)(tg_gui*3000);
                    // FileWriter fw = new FileWriter("output.txt");
                    // BufferedWriter bw = new BufferedWriter(fw);
                    // bw.write(String.format("%s;%s;%s;%s;%s;%d\n", DLXeVao[0], DLXeVao[1], DLXeVao[2], DLXeVao[3], DLXeRa[3], TienThueBai));
                    // bw.close();
                    // fw.close();
                }
                else {
                    SimpleDateFormat f = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                    Date tg_vao = f.parse(DLXeVao[3]);
                    Date tg_ra = f.parse(DLXeRa[3]);
                    float tg_gui = (tg_ra.getTime()-tg_vao.getTime())/((float)1000*60*60*24);
                    if(tg_gui != (int)tg_gui) tg_gui = (int)tg_gui + 1;
                    TienThueBai = (int)(tg_gui*1000);
                    // FileWriter fw = new FileWriter("output.txt");
                    // BufferedWriter bw = new BufferedWriter(fw);
                    // bw.write(String.format("%s;%s;%s;%s;%s;%d\n", DLXeVao[0], DLXeVao[1], DLXeVao[2], DLXeVao[3], DLXeRa[3], TienThueBai));
                    // bw.close();
                    // fw.close();
                }
                // try {
                //     FileWriter fw = new FileWriter("output.txt");
                //     BufferedWriter bw = new BufferedWriter(fw);
                //     bw.write(String.format("%s;%s;%s;%s;%s;%d\n", DLXeVao[0], DLXeVao[1], DLXeVao[2], DLXeVao[3], DLXeRa[3], TienThueBai));
                // } catch(Exception e) {System.out.println(e.getMessage());}


                bw.write(String.format("%s;%s;%s;%s;%s;%d\n", DLXeVao[0], DLXeVao[1], DLXeVao[2], DLXeVao[3], DLXeRa[3], TienThueBai));
            }
            bw.close();
            fw.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }
}
