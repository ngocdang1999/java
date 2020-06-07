/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendienkhachhang;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class KhachHangVN extends KhachHang{
    private String DoiTuong;
    private int DinhMuc;

    KhachHangVN() {
        super();
        this.DoiTuong = " ";
        this.DinhMuc = 0;
    }

    KhachHangVN(String DoiTuong, int DinhMuc, String Makh, String Hoten, Date Ngay, float Sokw, float Dongia) {
        super();
        this.DoiTuong = DoiTuong;
        this.DinhMuc = DinhMuc;
    }

    public String getDoiTuong() {
        return DoiTuong;
    }

    public void setDoiTuong(String DoiTuong) {
        this.DoiTuong = DoiTuong;
    }

    public int getDinhMuc() {
        return DinhMuc;
    }

    public void setDinhMuc(int DinhMuc) {
        this.DinhMuc = DinhMuc;
    }

    @Override
    public double tinhThanhTien() {
        if(this.getSoKw()<this.getDinhMuc())
            return super.tinhThanhTien(); //To change body of generated methods, choose Tools | Templates.
        else
            return super.getDonGia()*this.getDinhMuc() + (super.getSoKw()-this.getDinhMuc())*this.getDonGia()*2.5;
    }
    
    Scanner scanner = new Scanner(System.in);

    @Override
    public void Nhap() throws Exception {
        super.Nhap(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Đối tượng: ");
        this.DoiTuong = scanner.nextLine();
        System.out.println("Định mức: ");
        this.DinhMuc = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "KhachHangVN{" + super.toString() + "DoiTuong=" + DoiTuong + ", DinhMuc=" + DinhMuc + '}';
    }
    
}
