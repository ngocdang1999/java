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
public class GiaoDichNha extends GiaoDichChung{
    private String LoaiNha;
    private float DienTich;
    private String DiaChi;

    public GiaoDichNha() {
        super();
        this.LoaiNha = LoaiNha;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
    }

    public GiaoDichNha(String LoaiNha, float DienTich, String DiaChi, int MaGD, String Ngay, float DonGia) {
        super();
        this.LoaiNha = LoaiNha;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
    }

    public String getLoaiNha() {
        return LoaiNha;
    }

    public void setLoaiNha(String LoaiNha) {
        this.LoaiNha = LoaiNha;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    Scanner Nhap = new Scanner(System.in);
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhập địa chỉ: ");
        DiaChi = Nhap.nextLine();
        System.out.print("Nhập loại nhà (0: cao cấp, 1: thường): ");
        int choose = Nhap.nextInt();
        switch (choose) {
            case 0:
                LoaiNha = "cao cấp";
                break;
            case 1: 
                LoaiNha = "thường";
                break;
            default:
                System.out.println("Chọn số không hợp lệ.");
                break;
        }
    }
    public String toString() {
        return super.toString() + ", loại nhà: " + this.LoaiNha + ", địa chỉ: " + this.DiaChi;
    }
}
    

