/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlygiaodich;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class giaodich {
    private int MaGiaoDich;
    private String NgayThang;
    private float DonGia;
    private double ThanhTien;
    private int SoLuong;
    Scanner in = new Scanner (System.in);

    public giaodich() {
        this.MaGiaoDich = 0;
        this.NgayThang = " ";
        this.DonGia = 0;
        this.ThanhTien = 0;
        this.SoLuong = 0;
    }
    
    
    public giaodich(int MaGiaoDich, String NgayThang, float DonGia, float ThanhTien, int SoLuong) {
        this.MaGiaoDich = MaGiaoDich;
        this.NgayThang = NgayThang;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
        this.SoLuong = SoLuong;
    }

    public int getMaGiaoDich() {
        return MaGiaoDich;
    }

    public void setMaGiaoDich(int MaGiaoDich) {
        this.MaGiaoDich = MaGiaoDich;
    }

    public String getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(String NgayThang) {
        this.NgayThang = NgayThang;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
	this.ThanhTien = thanhTien;
	}

    public int getSoLuong(){
        return SoLuong;
    }
    
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

public void nhap(){
    System.out.println("Ma giao dich: ");
    MaGiaoDich = in.nextInt();
    System.out.println("Ngày tháng: ");
    in.nextLine();
    NgayThang = in.nextLine();
    System.out.println("Don gia: ");
    DonGia = in.nextFloat();
    System.out.println("So luong: ");
    SoLuong = in.nextInt();
}

public String toString() {
        return " [MaGD" + MaGiaoDich + ",So luong =" + SoLuong + ", NgayGD =" + NgayThang + ", Don gia=" + DonGia;
    }
}
