/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlithuephong;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Kira
 */
public class HoaDonTheoNgay extends HoaDon{
    private int SoNgayThue;

    public HoaDonTheoNgay() {
        super();
        this.SoNgayThue = 0;
    }

    public HoaDonTheoNgay(int SoNgayThue, String MaHoaDon, Date NgayHoaDon, String TenKhachHang, String MaPhong, float DonGia) {
        super(MaHoaDon, NgayHoaDon, TenKhachHang, MaPhong, DonGia);
        this.SoNgayThue = SoNgayThue;
    }
    

    public int getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(int SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }
    
    @Override
    public void Nhap() throws Exception {
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Số Ngày Thuê:");
        this.SoNgayThue = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "HoaDonTheoNgay{" + super.toString()+ "SoNgayThue=" + SoNgayThue + "ThanhTien" + this.TinhThanhTien()+ '}';
    }
    
    public double TinhThanhTien(){
       if(this.getSoNgayThue()<7 ) return this.getSoNgayThue() * super.getDonGia();
       else return 7*super.getDonGia()+ (this.getSoNgayThue()-7)*super.getDonGia()*(20/100);
    }
}
