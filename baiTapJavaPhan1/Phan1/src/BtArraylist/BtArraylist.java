package BtArraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * BtArraylist
 */
public class BtArraylist {

    public ArrayList<String> dsHoTen = new ArrayList<String>();
    public ArrayList<Float> dsDTB = new ArrayList<Float>();

    public void TaoDanhSach() {
        try {
            FileReader fr = new FileReader("sv.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if(line == null || line == "") break;
                String[] t_line = line.split(";");
                dsHoTen.add(t_line[1].trim());
                dsDTB.add(Float.parseFloat(t_line[4]));
            }
            br.close();
            fr.close();
        } catch(Exception e) {System.out.println(e.getMessage());}
    }

    public void XuatDanhSach() {
        int AL_size = dsHoTen.size();
        for(int i = 0; i <= AL_size-1; i++) {
            System.out.printf("%s: %f\n", dsHoTen.get(i), dsDTB.get(i));
        }
    }

    public void TimKiem(String name) {
        for (String HT : dsHoTen) {
            if(HT.toLowerCase().contains(name.trim().toLowerCase()))
                System.out.println(HT);
        }
    }

    public void ThongKe() {
        int SL_dau = 0;
        int SL_rot = 0;
        for (Float DTB : dsDTB) {
            if(DTB >= 5) SL_dau++;
            else SL_rot++;
        }
        System.out.println("Dau: "+SL_dau);
        System.out.println("Rot: "+SL_rot);
    }

    public float TBCOfDTB() {
        float sumOfDTB = 0;
        for (Float DTB : dsDTB) {
            sumOfDTB += DTB;
        }
        return sumOfDTB/dsDTB.size();
    }
}
