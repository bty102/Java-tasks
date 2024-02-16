package BtMang;

import java.util.Scanner;

/**
 * Mang
 */
public class Mang {

    public static void main(String[] args) {
        // BtMang m = new BtMang();

        // String ngay1 = "01/01/2000";
        // String ngay2 = "12/10/2023";

        // // System.out.println(m.TaoHoTen());
        // // System.out.println(m.TaoNgay(ngay1, ngay2));

        // for(int i = 1; i <= 100; i++) {
        //     // System.out.println(m.TaoHoTen());
        //     // System.out.println(m.TaoNgay(ngay1, ngay2));
        //     System.out.printf("%d %s: %s\n", i, m.TaoHoTen(), m.TaoNgay(ngay1, ngay2));
        // }


        BtMang m = new BtMang();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        m.HienThi(n);
    }
}
