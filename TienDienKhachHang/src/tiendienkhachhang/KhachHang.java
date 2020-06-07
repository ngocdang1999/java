/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendienkhachhang;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class KhachHang {
    private String Makh;
    private String Hoten;
    private Date Ngay;
    private float Sokw;
    private float Dongia;

    public KhachHang() {
        this.Makh = " ";
        this.Hoten = " ";
        this.Ngay = new Date();
        this.Sokw = 0.0f;
        this.Dongia = 0.0f;
    }    
    
    public KhachHang(String Makh, String Hoten, Date Ngay, float Sokw, float Dongia) {
        this.Makh = Makh;
        this.Hoten = Hoten;
        this.Ngay = Ngay;
        this.Sokw = Sokw;
        this.Dongia = Dongia;
    }

    public String getMaKh() {
        return Makh;
    }

    public void setMaKh(String Makh) {
        this.Makh = Makh;
    }

    public String getHoTen() {
        return Hoten;
    }

    public void setHoTen(String Hoten) {
        this.Hoten = Hoten;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public float getSoKw() {
        return Sokw;
    }

    public void setSoKw(float Sokw) {
        this.Sokw = Sokw;
    }

    public float getDonGia() {
        return Dongia;
    }

    public void setDonGia(float Dongia) {
        this.Dongia = Dongia;
    }

    Scanner scanner = new Scanner(System.in);
    
    public void Nhap() throws Exception{
        System.out.print("Nhap ma khach hàng: ");
        this.Makh = scanner.nextLine();
        System.out.println("Nhap ten khách hàng: ");
        this.Hoten = scanner.nextLine();
        System.out.println("Ngay tháng năm: ");
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        this.Ngay = time.parse(scanner.nextLine());
        System.out.println("Số KW: ");
        this.Sokw = scanner.nextFloat();
        System.out.println("Đơn giá: ");
        this.Dongia = scanner.nextFloat();
    }
    
    public double tinhThanhTien(){
        return this.Sokw*this.Dongia;
    }

        @Override
    public boolean equals(Object obj) {
        return this.Makh.equalsIgnoreCase(((KhachHang)obj).Makh); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Makh=" + Makh + ", Hoten=" + Hoten + ", Ngay=" + Ngay + ", Sokw=" + Sokw + ", Dongia=" + Dongia;
    }
    
    
}
