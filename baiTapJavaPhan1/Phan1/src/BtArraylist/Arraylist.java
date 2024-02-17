package BtArraylist;

import java.util.Scanner;

import BtFile.BtFile;

/**
 * Arraylist
 */
public class Arraylist {

    public static void main(String[] args) {
        // BtFile tmp_oj = new BtFile();
        // tmp_oj.TaoDanhSach(5);
        BtArraylist tmp_oj = new BtArraylist();
        tmp_oj.TaoDanhSach();
        tmp_oj.XuatDanhSach();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        tmp_oj.TimKiem(name);
        tmp_oj.ThongKe();
        System.out.println("TBC cua DTB: "+tmp_oj.TBCOfDTB());
    }
}
