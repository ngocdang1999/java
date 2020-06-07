/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlithuephong;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Kira
 */
public class HoaDon {
    private String MaHoaDon;
    private Date NgayHoaDon;
    private String TenKhachHang;
    private String MaPhong;
    private float DonGia;

    
    
    public HoaDon() {
        this.MaHoaDon = null;
        this.NgayHoaDon = new Date();
        this.TenKhachHang = null;
        this.MaPhong = null;
        this.DonGia = 0.0f;
    }

    public HoaDon(String MaHoaDon, Date NgayHoaDon, String TenKhachHang, String MaPhong, float DonGia) {
        this.MaHoaDon = MaHoaDon;
        this.NgayHoaDon = NgayHoaDon;
        this.TenKhachHang = TenKhachHang;
        this.MaPhong = MaPhong;
        this.DonGia = DonGia;
    }
    
    

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getNgayHoaDon() {
        return NgayHoaDon;
    }

    public void setNgayHoaDon(Date NgayHoaDon) {
        this.NgayHoaDon = NgayHoaDon;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
    public void Nhap() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã Hoá Đơn :");
        this.MaHoaDon = sc.nextLine();
        System.out.println("Ngày Hoá Đơn :");
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        this.NgayHoaDon = time.parse(sc.nextLine());
        System.out.println("Nhập Tên Khách Hàng:");
        this.TenKhachHang = sc.nextLine();
        System.out.println("Nhập Mã Phòng:");
        this.MaPhong = sc.nextLine();
        System.out.println("Nhập Đơn Giá:");
        this.DonGia = Float.parseFloat(sc.nextLine());
    }

    @Override
    public String toString() {
        return "HoaDon {" + "MaHoaDon=" + MaHoaDon + ", NgayHoaDon=" + NgayHoaDon + ", TenKhachHang=" + TenKhachHang + ", MaPhong=" + MaPhong + ", DonGia=" + DonGia ;
    }
    
    
}
