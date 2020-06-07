/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodichnhadat;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class GiaoDichDat extends GiaoDichChung{
    private String LoaiDat;
    private float DienTich;

    public GiaoDichDat() {
        super();
        this.LoaiDat = LoaiDat;
        this.DienTich = DienTich;
    }

    public GiaoDichDat(String LoaiDat, float DienTich, int MaGD, String Ngay, float DonGia) {
        super();
        this.LoaiDat = LoaiDat;
        this.DienTich = DienTich;
    }

    public String getLoaiDat() {
        return LoaiDat;
    }

    public void setLoaiDat(String LoaiDat) {
        this.LoaiDat = LoaiDat;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

        Scanner Nhap = new Scanner(System.in);
        
 public void Nhap() {
        super.Nhap();
        System.out.print("Nhập loại đất (A/B/C): ");
        LoaiDat = Nhap.nextLine();
    }
 
    public String toString() {
        return super.toString() + ", Loại đất: " + this.LoaiDat;
    }
}

    
