/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thu_vien_quan_li_x;

import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class SachGiaoKhoa {
    private String MaSach;
    private String NgayNhap;
    private float DonGia;
    private int SoLuong;
    private String NhaXuatBan;
    private String TinhTrang;

    public SachGiaoKhoa(String MaSach, String NgayNhap, float DonGia, int SoLuong, String NhaXuatBan, String TinhTrang) {
        this.MaSach = MaSach;
        this.NgayNhap = NgayNhap;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.NhaXuatBan = NhaXuatBan;
        this.TinhTrang = TinhTrang;
    }

    public SachGiaoKhoa() {
        this.MaSach = " ";
        this.NgayNhap = " ";
        this.DonGia = 1;
        this.SoLuong = 1;
        this.NhaXuatBan = " ";
        this.TinhTrang = " ";
    }
    
    
    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    public void Nhap(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập Mã Sách: ");
            this.MaSach = sc.nextLine();
            System.out.println("Ngày Nhập:");
            this.NgayNhap = sc.nextLine();
            System.out.println("Đơn Giá:");
            sc.nextLine();
            this.DonGia = sc.nextFloat();
            System.out.println("Số Lượng: ");
            this.SoLuong = sc.nextInt();
            System.out.println("Nhà Xuất Bản: ");
            this.NhaXuatBan = sc.nextLine();
            System.out.println("Tình Trạng (Mới/Cũ):");
            this.TinhTrang = sc.nextLine();
    }
    @Override
    public String toString() {
        return "Mã sách: " + this.MaSach + ", tên nhà xuất bản: " + this.NhaXuatBan + ", đơn giá: " + 
                this.DonGia + ", số lượng: " + this.SoLuong;
    }
    public String ToString(){
            String st=" ";
            st += " \n Nhập Mã Sách: " + this.MaSach;
            st += " \n Ngày Nhập: " + this.NgayNhap;
            st += " \n Đơn Giá: " + this.DonGia;
            st += " \n Số Lượng: " + this.SoLuong;
            st += " \n Nhà Xuất Bản: " + this.NhaXuatBan;
            st += " \n Tình Trạng (Mới/Cũ): " + this.TinhTrang;
            return st;
    }
    public float ThanhTien(float DonGia,int  SoLuong,String TinhTrang){
        float Tong;
        if(TinhTrang.equals("Mới")) Tong = SoLuong*DonGia; 
        else Tong = SoLuong*DonGia*(50/100);
        return Tong;
    }
    
}
