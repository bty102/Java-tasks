package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import been.Hang;
import bo.Hangbo;

public class Hangview {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Hangbo hbo = new Hangbo();
			hbo.luuVaoCSDL("hang.txt");
			System.out.println("DS hang:");
			for(Hang h : hbo.getDS()) {
				System.out.println(h.toString());
			}			
			System.out.println("Nhap hang muon them:");			
			System.out.print("Nhap ma hang: ");
		    String maHang = sc.nextLine();
		    System.out.print("Nhap ten hang: ");
		    String tenHang = sc.nextLine();
		    System.out.print("Nhap ngay nhap hang: ");
		    Date ngayNhapHang = f.parse(sc.nextLine());
		    System.out.print("Nhap so luong: ");
		    int soLuong = Integer.parseInt(sc.nextLine());
		    System.out.print("Nhap gia: ");
		    float gia = Float.parseFloat(sc.nextLine());
		    hbo.them(maHang, tenHang, ngayNhapHang, soLuong, gia);
		    System.out.println("Sau khi them hang: ");
		    for(Hang h : hbo.getDS()) {
		    	System.out.println(h.toString());
		    }
		    System.out.print("Nhap ma hang muon xoa: ");
		    maHang = sc.nextLine();
		    hbo.xoa(maHang);
		    System.out.println("Sau khi xoa hang: ");
		    for(Hang h : hbo.getDS()) {
		    	System.out.println(h.toString());
		    }
		    System.out.println("Nhap hang muon sua: ");
			System.out.print("Nhap ma hang: ");
		    maHang = sc.nextLine();
		    System.out.print("Nhap ten hang: ");
		    tenHang = sc.nextLine();
		    System.out.print("Nhap ngay nhap hang: ");
		    ngayNhapHang = f.parse(sc.nextLine());
		    System.out.print("Nhap so luong: ");
		    soLuong = Integer.parseInt(sc.nextLine());
		    System.out.print("Nhap gia: ");
		    gia = Float.parseFloat(sc.nextLine());
		    hbo.sua(maHang, tenHang, ngayNhapHang, soLuong, gia);
		    System.out.println("Sau khi sua: ");
		    for(Hang h : hbo.getDS()) {
		    	System.out.println(h.toString());
		    }
			System.out.print("Nhap hang can tim: ");
			tenHang = sc.nextLine();
			System.out.println("Ket qua tim:");
			for(Hang h : hbo.timKiem(tenHang)) {
				System.out.println(h.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
