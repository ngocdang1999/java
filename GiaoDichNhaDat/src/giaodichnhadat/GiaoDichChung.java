/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodichnhadat;

import java.sql.Time;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class GiaoDichChung {
    private int MaGD;
    private String Ngay;
    private float DonGia;

    public GiaoDichChung() {
        this.MaGD = 0;
        this.Ngay = " ";
        this.DonGia = 0.0f;
    }

    Scanner Nhap = new Scanner(System.in);
    
    public GiaoDichChung(int MaGD, String Ngay, float DonGia, float DienTich) {
        this.MaGD = MaGD;
        this.Ngay = Ngay;
        this.DonGia = DonGia;
    }

    public int getMaGD() {
        return MaGD;
    }

    public void setMaGD(int MaGD) {
        this.MaGD = MaGD;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
    public void Nhap(){
        System.out.print("Nhap ma giao dich: ");
        this.MaGD = Nhap.nextInt();
        System.out.print("Nhap ngay thang giao dich: ");
        this.Ngay = Nhap.nextLine();
        System.out.print("Don gia: ");
        this.DonGia = Nhap.nextFloat();
    }

    public String toString() {
        return "MaGD=" + MaGD + ", Ngay=" + Ngay + ", DonGia=" + DonGia;
    }
}
