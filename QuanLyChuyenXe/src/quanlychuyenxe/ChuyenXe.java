/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenxe;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class ChuyenXe {
    private String MSChuyen;
    private String HoTen;
    private String SoXe;
    private float DoanhThu;

    public ChuyenXe() {
        this.MSChuyen = " ";
        this.HoTen = " ";
        this.SoXe = " ";
        this.DoanhThu = 0.0f;
    }

    
    public ChuyenXe(String MSChuyen, String HoTen, String SoXe) {
        this.MSChuyen = MSChuyen;
        this.HoTen = HoTen;
        this.SoXe = SoXe;
        this.DoanhThu = DoanhThu;
    }

    public String getMSChuyen() {
        return MSChuyen;
    }

    public void setMSChuyen(String MSChuyen) {
        this.MSChuyen = MSChuyen;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoXe() {
        return SoXe;
    }

    public void setSoXe(String SoXe) {
        this.SoXe = SoXe;
    }


    Scanner scaner = new Scanner(System.in);
    
    public void Nhap(){
        System.out.print("Nhap ma so chuyen xe:");
        this.MSChuyen = scaner.nextLine();
        System.out.print("Nhap ho ten:");
        this.HoTen = scaner.nextLine();
        System.out.print("Nhap so xe");
        this.SoXe = scaner.nextLine();
        System.out.print("Nhap doanh thu");
        this.DoanhThu = scaner.nextFloat();
    }

    @Override
    public String toString() {
        return "MSChuyen=" + MSChuyen + ", HoTen=" + HoTen + ", SoXe=" + SoXe + ",DoanhThu=" + DoanhThu;
    }
    
    
}
