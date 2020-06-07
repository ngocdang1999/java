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
public class sachgiaokhoa extends sach{
    private String trinhTrang;
    private int soLuong;
    private double thanhTien;

    sachgiaokhoa() {
        super();
        this.trinhTrang = "";
        this.soLuong = 0;
        this.thanhTien = 0;
    }

    public sachgiaokhoa(String trinhTrang, int soLuong, double thanhTien) {
        super();
        this.trinhTrang = trinhTrang;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getTrinhTrang() {
        return trinhTrang;
    }

    public void setTrinhTrang(String trinhTrang) {
        this.trinhTrang = trinhTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String trinhTrangSach(int x) {
        switch (soLuong) {
            case 0:
                trinhTrang = "cũ";
                break;
            case 1:
                trinhTrang = "mới";
                break;
            default:
                break;
        }
        return trinhTrang;
    }
     
    public void nhapsach() {
        super.nhapsach();
        System.out.print("Nhập tình trạng sách 0 - cũ or 1 - mới): ");
        soLuong = scanner.nextInt();
    }
     
    public String toString() {
        return super.toString() + ", Tình trạng sách: " + this.trinhTrangSach(soLuong);
    }

    int getNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
