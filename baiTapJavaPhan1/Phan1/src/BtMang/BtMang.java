package BtMang;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * BtMang
 */
public class BtMang {

    //ham tra ve 1 ngay ngau nhien thuoc [ngay1, ngay2]
    public String TaoNgay(String ngay1, String ngay2) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date day1 = f.parse(ngay1);
            Date day2 = f.parse(ngay2);
            Random random = new Random();
            while (true) {
                Long tmp = random.nextLong();
                if(tmp >= day1.getTime() && tmp <= day2.getTime()) {
                    Date ngn = new Date(tmp);
                    return f.format(ngn);
                }
            }
        } catch(Exception tt) {
            System.out.println("Loi: " + tt.getMessage());
            return null;
        }
    }

    //ham tra ve mot ho ten ngau nhien
    public String TaoHoTen() {
        String[] ho = {"Pham", "Vo", "Truong", "Nguyen", "Tran", "Duong"};
        String[] hoDem = {"Ngoc Mong", "Hoang", "Thi Thanh", "Van", "Thi", "Van Tan", "Thi Ngoc"};
        String[] ten = {"Phuoc", "Minh", "Huyen", "Nhi", "Tai", "Loc"};
        Random random = new Random();
        int idxHo = random.nextInt(ho.length);
        int idxHoDem = random.nextInt(hoDem.length);
        int idxTen = random.nextInt(ten.length);
        return ho[idxHo] + " " + hoDem[idxHoDem] + " " + ten[idxTen];
    }

    //ham hien thi thong tin cua n sinh vien
    public void HienThi(int n) {
        Random random = new Random();
        for(int i = 1; i <= n; i++) {
            double dtb = random.nextDouble()*10;
            boolean gt = random.nextBoolean();
            String kq = (dtb>=5)?"Dau":"Rot";
            String xl;
            if(dtb < 3) xl = "Kem";
            else if(dtb <= 4.9) xl = "Yeu";
            else if(dtb <= 6.4) xl = "TB";
            else if(dtb <= 7.9) xl = "Kha";
            else xl = "Gioi";
            //System.out.print(TaoHoTen()+";"+TaoNgay("14/01/2000", "02/11/2023")+";"+dtb);
            System.out.print(TaoHoTen()+";"+TaoNgay("01/01/2000", "01/01/2023")+";");
            System.out.print(gt?"Nu;":"Nam;");
            System.out.println(dtb+";"+kq+";"+xl);
        }
    }
}
