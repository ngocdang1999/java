/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuvien;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class sach {
    private String maSach, nhaXuatBan;
    private double donGia;
    private int soLuong;
    Scanner scanner = new Scanner(System.in);

    public sach() {
        this.maSach = "";
        this.nhaXuatBan = "";
        this.donGia = 0;
        this.soLuong = 0;
    }

    public sach(String maSach, String nhaXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.nhaXuatBan = nhaXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

public void nhapsach(){
    System.out.print("Nhập mã sách:");
    maSach = scanner.nextLine();
    System.err.print("Nhập nhà xuất bản:");
    nhaXuatBan = scanner.nextLine();
    System.out.print("Nhập đơn giá: ");
    donGia = scanner.nextDouble();
    System.out.print("Nhập số lượng: ");
    soLuong = scanner.nextInt();
}
    
public String toString() {
        return "Mã sách: " + this.maSach + ", tên nhà xuất bản: " + this.nhaXuatBan + ", đơn giá: " + 
                this.donGia + ", số lượng: " + this.soLuong;
    }

}


